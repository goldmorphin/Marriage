package com.lenis0012.bukkit.marriage.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.lenis0012.bukkit.marriage.MPlayer;


public class InfoCommand extends CommandBase {

	@Override
	public void perform(CommandSender sender, String[] args) {
		boolean isAdmin = sender.hasPermission("marry.admin");
		ChatColor g = ChatColor.GRAY;
		ChatColor l = ChatColor.GREEN;
		ChatColor r = ChatColor.RED;
		inform(sender, g + "==========-{"+l+" Marriage "+g+"}-==========");
		inform(sender, g + "Версия: "+l+plugin.getDescription().getVersion());
		inform(sender, g + "Авторы: "+l+plugin.getDescription().getAuthors().toString().replace("[", "").replace("]", ""));
		inform(sender, l + "/marry <игрок> "+g+"- Жениться/Выйти замуж за игрока");
		inform(sender, l + "/marry accept "+g+"- Принять предложение партнёра");
		inform(sender, l + "/marry divorce "+g+"- Развестить с Вашим партнёром");
		inform(sender, l + "/marry list "+g+"- Показать все пары");
		inform(sender, l + "/marry tp "+g+"- Телепортироваться к Вашему партнёру");
		inform(sender, l + "/marry gift "+g+"- Подарить партнёру предмет в руке");
		inform(sender, l + "/marry chat "+g+"- Приватный чат с Вашим партнёром");
		inform(sender, l + "/marry sethome "+g+"- Установить точку совместного дома");
		inform(sender, l + "/marry home "+g+"- Переместится в Ваш совместный дом");
		inform(sender, l + "/marry seen - Проверить последний онлайн Вашего партнёра");
		if(sender.hasPermission("marry.reload") || isAdmin) {
			inform(sender, l + "/marry reload"+g+" - Перезагружает все файлы конфигураций");
		} if(plugin.getConfig().getBoolean("settings.enable-chatspy") && (sender.hasPermission("marry.chatspy") || isAdmin)) {
			inform(sender, l + "/marry chatspy - Показывает все приватные чаты");
		}
		
		inform(sender, l + "Присесть + Правый клик"+g+" - Чмокнуть партнёра :)");
		
		if(this.isPlayer()) {
			Player player = (Player) sender;
			MPlayer mp = plugin.getMPlayer(player);
			if(mp.isMarried()) {
				inform(sender, "Партнёр: "+l+mp.getPartner());
			}else {
				inform(sender, "Партнёр: "+r+"Нет");
			}
		}
	}

	@Override
	public String getPermission() {
		return null;
	}

	@Override
	public boolean playersOnly() {
		return false;
	}
}
