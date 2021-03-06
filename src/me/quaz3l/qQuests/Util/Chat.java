package me.quaz3l.qQuests.Util;

import me.quaz3l.qQuests.qQuests;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Chat {
	// General Message
	public static void message(String player, String msg)
	{
		Player p = qQuests.plugin.getServer().getPlayer(player);
		if(p == null || msg == null)
			return;
		p.sendMessage(parseColors(qQuests.plugin.chatPrefix + msg));
	}
	public static void message(CommandSender s, String msg)
	{
		s.sendMessage(parseColors(qQuests.plugin.prefix + msg));
	}

	// Message With No Former Formatting
	public static void noPrefixMessage(String player, String msg)
	{
		Player p = qQuests.plugin.getServer().getPlayer(player);
		if(p == null)
			return;
		p.sendMessage(parseColors(ChatColor.LIGHT_PURPLE + msg));
	}
	public static void noPrefixMessage(CommandSender s, String msg)
	{
		s.sendMessage(parseColors(ChatColor.LIGHT_PURPLE + msg));
	}

	// A Good Message For Successes
	public static void quotaMessage(String player, String msg, Integer currentAmount, Integer totalAmount, String unit)
	{
		Player p = qQuests.plugin.getServer().getPlayer(player);
		if(p == null)
			return;
		p.sendMessage(parseColors(qQuests.plugin.chatPrefix + ChatColor.LIGHT_PURPLE + msg + " " + ChatColor.GREEN + currentAmount + "/" + totalAmount + " " + unit));
	}

	// Red Error With Prefix
	public static void error(String player, String msg)
	{
		Player p = qQuests.plugin.getServer().getPlayer(player);
		if(p == null || msg == null)
			return;
		p.sendMessage(parseColors(qQuests.plugin.chatPrefix + ChatColor.RED + msg));
	}
	public static void error(CommandSender p, String msg)
	{
		p.sendMessage(parseColors(qQuests.plugin.chatPrefix + ChatColor.RED + msg));
	}

	// A Good Message For Successes
	public static void green(String player, String msg)
	{
		Player p = qQuests.plugin.getServer().getPlayer(player);
		if(p == null || msg == null)
			return;
		p.sendMessage(parseColors(qQuests.plugin.chatPrefix + ChatColor.GREEN + msg));
	}

	// No Permissions Message
	public static void noPerms(String player)
	{
		Player p = qQuests.plugin.getServer().getPlayer(player);
		if(p == null)
			return;
		p.sendMessage(parseColors(ChatColor.RED + Texts.NO_PERMISSION));
	}
	public static void noPerms(CommandSender s)
	{
		s.sendMessage(parseColors(ChatColor.RED + Texts.NO_PERMISSION));
	}

	// Logger
	public static void logger(String lvl, String s)
	{
		if(lvl.equalsIgnoreCase("debug") && qQuests.plugin.debug)
			qQuests.plugin.logger.info("[" + Thread.currentThread().getStackTrace()[2].getLineNumber() + "] " + parseColors(qQuests.plugin.prefix + s));
		else if(lvl.equalsIgnoreCase("info"))
			qQuests.plugin.logger.info(parseColors(qQuests.plugin.prefix + s));
		else if(lvl.equalsIgnoreCase("warning"))
			qQuests.plugin.logger.warning(parseColors(qQuests.plugin.prefix + s));
		else if(lvl.equalsIgnoreCase("severe"))
			qQuests.plugin.logger.severe(parseColors(qQuests.plugin.prefix + s));
	}

	// Parses Error Codes To Phrases
	public static String errorCode(Integer code, String type, String player)
	{
		if(type.equalsIgnoreCase("Commands"))
		{
			switch(code)
			{
			case -1:
				return null;
			case 0:
				return "Success";
			case 1:
				return null;
			case 2:
				return Texts.NOT_ENOUGH_FOR_QUEST;
			case 3:
				return Texts.COMMANDS_HAS_ACTIVE_QUEST(player);
			case 4:
				return Texts.COMMANDS_TASKS_NOT_COMPLETED;
			case 5:
				return Texts.NOT_ENOUGH_MONEY;
			case 6:
				return Texts.NOT_ENOUGH_HEALTH;
			case 7:
				return Texts.NOT_ENOUGH_FOOD;
			case 8:
				return Texts.NOT_ENOUGH_ITEMS;
			case 9:
				return Texts.COMMANDS_NO_ACTIVE_QUEST;
			case 10:
				return Texts.DELAY_NOT_FINISHED;
			case 11:
				return Texts.NO_QUESTS_AVAILABLE;
			case 12:
				return Texts.LEVEL_TOO_LOW;
			case 13:
				return Texts.LEVEL_TOO_HIGH;
			case 14:
				return Texts.QUEST_IS_FORCED;
			case 15:
				return Texts.COMMANDS_YOU_HAVE_THIS_QUEST;
			case 16:
				return Texts.REQUIREMENT_NOT_MET;
			default:
				return "Unknown";
			}
		}
		else
		{
			switch(code)
			{
			case -1:
				return null;
			case 0:
				return "Success";
			case 1:
				return null;
			case 2:
				return Texts.NOT_ENOUGH_FOR_QUEST;
			case 3:
				return Texts.HAS_ACTIVE_QUEST(player);
			case 4:
				return Texts.TASKS_NOT_COMPLETED;
			case 5:
				return Texts.NOT_ENOUGH_MONEY;
			case 6:
				return Texts.NOT_ENOUGH_HEALTH;
			case 7:
				return Texts.NOT_ENOUGH_FOOD;
			case 8:
				return Texts.NOT_ENOUGH_ITEMS;
			case 9:
				return Texts.NO_ACTIVE_QUEST;
			case 10:
				return Texts.DELAY_NOT_FINISHED;
			case 11:
				return Texts.NO_QUESTS_AVAILABLE;
			case 12:
				return Texts.LEVEL_TOO_HIGH;
			case 13:
				return Texts.LEVEL_TOO_LOW;
			case 14:
				return Texts.QUEST_IS_FORCED;
			case 15:
				return Texts.YOU_HAVE_THIS_QUEST;
			case 16:
				return Texts.REQUIREMENT_NOT_MET;
			default:
				return "Unknown";
			}
		}
	}


	// Corrects Color Codes
	public static String parseColors(String s)
	{
		return s.replaceAll("`0", ChatColor.BLACK + "")
				.replaceAll("`1", ChatColor.DARK_BLUE + "")
				.replaceAll("`2", ChatColor.DARK_GREEN + "")
				.replaceAll("`3", ChatColor.DARK_AQUA + "")
				.replaceAll("`4", ChatColor.DARK_RED + "")
				.replaceAll("`5", ChatColor.DARK_PURPLE + "")
				.replaceAll("`6", ChatColor.GOLD + "")
				.replaceAll("`7", ChatColor.GRAY + "")
				.replaceAll("`8", ChatColor.DARK_GRAY + "")
				.replaceAll("`9", ChatColor.BLUE + "")
				.replaceAll("`a", ChatColor.GREEN + "")
				.replaceAll("`b", ChatColor.AQUA + "")
				.replaceAll("`c", ChatColor.RED + "")
				.replaceAll("`d", ChatColor.LIGHT_PURPLE + "")
				.replaceAll("`e", ChatColor.YELLOW + "")
				.replaceAll("`f", ChatColor.WHITE + "")
				.replaceAll("`g", ChatColor.MAGIC + "");
	}
	/**
	 * @author destro168
	 */
	public static String removeColors(String line)
	{
		//Replace colors
		line = line.replaceAll(ChatColor.BLACK + "", "");
		line = line.replaceAll(ChatColor.DARK_BLUE + "", "");
		line = line.replaceAll(ChatColor.DARK_GREEN + "", "");
		line = line.replaceAll(ChatColor.DARK_AQUA + "", "");
		line = line.replaceAll(ChatColor.DARK_RED + "", "");
		line = line.replaceAll(ChatColor.DARK_PURPLE + "", "");
		line = line.replaceAll(ChatColor.GOLD + "", "");
		line = line.replaceAll(ChatColor.GRAY + "", "");
		line = line.replaceAll(ChatColor.DARK_GRAY + "", "");
		line = line.replaceAll(ChatColor.BLUE + "", "");
		line = line.replaceAll(ChatColor.GREEN + "", "");
		line = line.replaceAll(ChatColor.AQUA + "", "");
		line = line.replaceAll(ChatColor.RED + "", "");
		line = line.replaceAll(ChatColor.LIGHT_PURPLE + "", "");
		line = line.replaceAll(ChatColor.YELLOW + "", "");
		line = line.replaceAll(ChatColor.WHITE + "", "");

		return line;
	}
	public static void attention(int type) {
		switch(type)
		{
		case 0:
			Chat.logger("info", "################################################################");
			Chat.logger("info", "############################## INFO ############################");
			Chat.logger("info", "################################################################");
			break;
		case 1:
			Chat.logger("warning", "################################################################");
			Chat.logger("warning", "######################### WARNING! #############################");
			Chat.logger("warning", "################################################################");
			break;
		case 2:
			Chat.logger("severe", "################################################################");
			Chat.logger("severe", "########################## SEVERE! #############################");
			Chat.logger("severe", "################################################################");
			break;
		case 3:
			Chat.logger("warning", "################################################################");
			Chat.logger("warning", "################################################################");
			Chat.logger("warning", "################################################################");
			break;
		default:
			Chat.logger("warning", "################################################################");
			Chat.logger("warning", "################################################################");
			Chat.logger("warning", "################################################################");
			break;
		}
	}
}
