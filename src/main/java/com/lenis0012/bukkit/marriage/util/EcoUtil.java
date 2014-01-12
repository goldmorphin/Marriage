package com.lenis0012.bukkit.marriage.util;


import org.bukkit.entity.Player;

import com.lenis0012.bukkit.marriage.Marriage;



public class EcoUtil {
	private static String msg = "&7Списано &f${Price} &7с Вашего баланса.";
	private static String nem = "&cВы не имеете &4${Price} &cна своём балансе!";

	public static double getPriceFromConfig(String value) {
		Marriage plugin = Marriage.instance;
		double price = plugin.getConfig().getDouble("price." + value, 0.0);
		return price;
	}

	public static boolean hasMoney(String user, double amount) {
		Marriage plugin = Marriage.instance;
		double balance = plugin.economy.getBalance(user);
		return balance >= amount;
	}

	public static boolean withrawMoneyIfEnough(Player player, double amount) {
		Marriage plugin = Marriage.instance;
		if(hasMoney(player.getName(), amount)) {
			withrawMoney(player, amount);
			return false;
		}else {
			String show = plugin.fixColors(nem).replace("{Price}", String.valueOf(amount));
			player.sendMessage(show);
			return true;
		}
	}

	public static void withrawMoney(Player player, double amount) {
		String user = player.getName();
		Marriage plugin = Marriage.instance;
		String show = plugin.fixColors(msg).replace("{Price}", String.valueOf(amount));
		plugin.economy.withdrawPlayer(user, amount);
		player.sendMessage(show);
	}

	public static void setMsg(int type, String value) {
		if(type == 1) {
			msg = value;
		}else if (type == 2) {
			nem = value;
		}
	}
}
