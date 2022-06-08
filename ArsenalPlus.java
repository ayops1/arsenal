package to.us.arsenalmc;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

// Features available to Staff (Admin)
public class ArsenalPlus extends JavaPlugin {

    final Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("ArsenalMC");

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        if (label.equalsIgnoreCase("arsenal")) {
            if (args[0].equalsIgnoreCase("reload")) {
                if (!player.hasPermission("arsenal.admin")) {
                    Message.send(sender, "&8[&4Arsenal&8] &7You do not have permission.");
                } else {
                    // Reloads Arsenal
                    Message.send(sender, "&8[&4Arsenal&8] &7Reloading config.");
                    plugin.reloadConfig();
                    Message.send(sender, "&8[&4Arsenal&8] &7Reload complete.");
                }
            }
        } else {
            Message.send(sender, "&8[&4Arsenal&8] &7Incorrect usage.");
        }
    return true;
    }
}