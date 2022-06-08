package to.us.arsenalmc;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Message {
    public static void send(CommandSender sender, String message) {
        send(sender, message, "&7");
    }

    public static void send(CommandSender sender, String message, String prefix) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + message));
    }
}
