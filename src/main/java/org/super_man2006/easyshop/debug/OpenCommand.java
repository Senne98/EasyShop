package org.super_man2006.easyshop.debug;

import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.super_man2006.easyshop.EasyShop;
import org.super_man2006.easyshop.shop.types.Shop;

public class OpenCommand implements CommandExecutor {
    @Override
    public boolean onCommand (CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) return true;

        if (cmd.getName().equalsIgnoreCase("shop")) {
            Shop.openShop((Player) sender, new NamespacedKey(EasyShop.plugin, "shop"));
            return true;
        }
        return true;
    }
}
