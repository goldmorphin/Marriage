package com.lenis0012.bukkit.marriage.listeners;

import java.util.HashMap;
import java.util.Map;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.lenis0012.bukkit.marriage.MPlayer;
import com.lenis0012.bukkit.marriage.Marriage;
import com.lenis0012.bukkit.marriage.util.PacketUtil;
import com.lenis0012.bukkit.marriage.util.Updater;
import com.lenis0012.bukkit.marriage.util.Updater.UpdateResult;


public class PlayerListener implements Listener {
	private Marriage plugin;
	public PlayerListener(Marriage i) { plugin = i; }
	
	private Map<String, Long> ingored = new HashMap<String, Long>();
	
	@EventHandler (priority = EventPriority.HIGHEST)
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		String pname = player.getName();
		MPlayer mp = plugin.getMPlayer(player);
		
		if(mp.isChatting()) {
			//Custom private chat
			Player partner = Bukkit.getServer().getPlayer(mp.getPartner());
			if(partner == null) {
				mp.setChatting(false);
				return;
			}
			if(!partner.isOnline()) {
				mp.setChatting(false);
				return;
			}
			
			String message = event.getMessage();
			String format = plugin.getConfig().getString("settings.private-chat.format");
			format = format.replace("{Player}", pname);
			format = format.replace("{Message}", message);
			format = plugin.fixColors(format);
			partner.sendMessage(format);
			player.sendMessage(format);
			plugin.getLogger().info("[Marriage] Чат: "+pname+": "+message);
			
			//Send to chatspy
			for(Player p : Bukkit.getOnlinePlayers()) {
				MPlayer ap = plugin.getMPlayer(p);
				if(ap.isChatspy()) {
					p.sendMessage("\247a[MSpy] \2477" + pname + " To " + partner.getName() + "\247a:" + message);
				}
			}
			
			event.setCancelled(true);
			//HeroChat fix?
			event.getRecipients().clear();
		} else if(mp.isMarried()) {
			//Replace chat with cusotm prefix
			if(plugin.getConfig().getBoolean("settings.chat-prefix.use")) {
				String format = plugin.getConfig().getString("settings.chat-prefix.format");
				format = plugin.fixColors(format);
				format = format.replace("{OLD_FORMAT}", event.getFormat());
				event.setFormat(format);
			}
		}
	}
	
	@EventHandler
	public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
		if(!Marriage.IS_COMPATIBLE)
			return; //Prevent problems with mc version
		
		Player player = event.getPlayer();
		MPlayer mp = plugin.getMPlayer(player);
		String pname = player.getName();
		
		if(this.ingored.containsKey(pname)) {
			long lastKiss = ingored.get(pname);
			if(lastKiss > System.currentTimeMillis())
				return;
		}
		
		if(player.isSneaking() && mp.isMarried()) {
			Entity entity = event.getRightClicked();
			if(entity != null && entity instanceof Player) {
				Player target = (Player) entity;
				String tname = target.getName();
				if(mp.getPartner().equals(tname)) {
					player.sendMessage(ChatColor.GREEN + "Ты поцеловал своего партнёра!");
					target.sendMessage(ChatColor.GREEN + "Твой партнёр чмокнул тебя <3");
					PacketUtil.createHearts(target, target.getLocation());
					PacketUtil.createHearts(player, target.getLocation());
					ingored.put(pname, System.currentTimeMillis() + 1500L);
				}
			}
		}
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		MPlayer mp = plugin.getMPlayer(player);
		mp.getConfig().set("last-logout", System.currentTimeMillis());
		mp.getConfig().save();
		plugin.clearPlayer(event.getPlayer());
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		final Player player = event.getPlayer();
		MPlayer mp = plugin.getMPlayer(player);
		mp.getConfig().set("last-login", System.currentTimeMillis());
		mp.getConfig().save();
		
		final Updater updater = plugin.getUpdater();
		if (updater.getResult() == UpdateResult.UPDATE_AVAILABLE
				&& player.hasPermission("marry.admin")
				&& plugin.getConfig().getBoolean("update-checker")) {
			Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {

				@Override
				public void run() {
					player.sendMessage("\247eНовая \247a"
							+ updater.getLatestType().toString().toLowerCase()
							+ " \247eверсия Marriage доступна! \247a"
							+ updater.getLatestName() + " \247efor \247a"
							+ updater.getLatestGameVersion()
							+ "\247e. Пожалуйста проверьте BukkitDev!");
				}
			}, 30L);
		}
	}
}