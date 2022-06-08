package to.us.arsenalmc;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Arsenal extends JavaPlugin {

    public void onEnable() { Bukkit.getLogger().info("Arsenal is ALIVE!"); } {

    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        if (label.equalsIgnoreCase("arsenal")) {
            if (args[0].equalsIgnoreCase("firework")) {
                if (!player.hasPermission("arsenal.player")) {
                    Message.send(sender, "&8[&4Arsenal&8] &7You do not have permission.");
                } else {
                    Firework firework = player.getWorld().spawn(player.getLocation(), Firework.class);
                    FireworkMeta fireworkMeta = firework.getFireworkMeta();
                    FireworkEffect.Builder builder = FireworkEffect.builder();

                    fireworkMeta.addEffect(builder.withFlicker().withColor(Color.WHITE).build());
                    fireworkMeta.addEffect(builder.trail(true).build());
                    fireworkMeta.addEffect(builder.withFade(Color.BLACK).build());
                    fireworkMeta.setPower(1);

                    firework.setFireworkMeta(fireworkMeta);

                    Message.send(sender, "&8[&4Arsenal&8] &7Ka-boom!");
                }
            }
            return true;
        } else {
            Message.send(sender , "&8[&4Arsenal&8] &7Incorrect usage.");
        }
    return true;
    }
}