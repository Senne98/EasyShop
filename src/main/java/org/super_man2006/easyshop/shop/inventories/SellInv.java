package org.super_man2006.easyshop.shop.inventories;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.super_man2006.custom_item_api.CustomItems.items.CustomItem;
import org.super_man2006.easyshop.EasyShop;
import org.super_man2006.easyshop.settings.Cmd;
import org.super_man2006.easyshop.shop.types.Item;

import java.util.ArrayList;
import java.util.List;

public class SellInv implements InventoryHolder {

    Inventory inv;

    public SellInv(Item item, NamespacedKey shopId) {
        int price = item.getSellPrice();

        inv = Bukkit.createInventory(this, 27, item.getName());

        ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta fillerMeta = filler.getItemMeta();
        if (Cmd.background != -1) {
            fillerMeta.setCustomModelData(Cmd.background);
        }
        fillerMeta.displayName(Component.text(""));
        filler.setItemMeta(fillerMeta);
        for (int i = 0; i < 27; i++) {
            inv.setItem(i, filler);
        }

        ItemStack icon = CustomItem.getItemStack(item.getIcon());
        ItemMeta iconMeta = icon.getItemMeta();
        iconMeta.getPersistentDataContainer().set(new NamespacedKey(EasyShop.plugin, "shopinstanceid"), PersistentDataType.STRING, item.getId().asString());
        iconMeta.displayName(item.getName().decoration(TextDecoration.ITALIC, false));
        icon.setItemMeta(iconMeta);
        inv.setItem(4, icon);

        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        if (Cmd.backbutton != -1) {
            closeMeta.setCustomModelData(Cmd.backbutton);
        }
        closeMeta.displayName(Component.text("Close").color(NamedTextColor.RED).decoration(TextDecoration.ITALIC, false));
        closeMeta.getPersistentDataContainer().set(new NamespacedKey(EasyShop.plugin, "shop"), PersistentDataType.STRING, shopId.asString());
        close.setItemMeta(closeMeta);
        inv.setItem(22, close);


        for (int i = 9; i < 18; i++) {
            int amount = (int) Math.pow(2, i - 9);

            int cmd;
            if (amount == 1) {
                cmd = Cmd.sellone;
            } else if (amount == 2) {
                cmd = Cmd.selltwo;
            } else if (amount == 4) {
                cmd = Cmd.sellfour;
            } else if (amount == 8) {
                cmd = Cmd.selleight;
            } else if (amount == 16) {
                cmd = Cmd.sellsixteen;
            } else if (amount == 32) {
                cmd = Cmd.sellthirtytwo;
            } else if (amount == 64) {
                cmd = Cmd.sellsixtyfour;
            } else if (amount == 128) {
                cmd = Cmd.sellonehundredtwentyeight;
            } else if (amount == 256) {
                cmd = Cmd.selltwohundredfiftysix;
            } else {
                cmd = -1;
            }

            ItemStack buy = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            ItemMeta buyMeta = buy.getItemMeta();
            if (cmd != -1) {
                buyMeta.setCustomModelData(cmd);
            }
            buyMeta.displayName(Component.text("sell " + amount).color(NamedTextColor.RED).decoration(TextDecoration.ITALIC, false));
            List<Component> lore = new ArrayList<>();
            lore.add(Component.text("price: " + (item.getSellPrice() * amount)).color(NamedTextColor.WHITE).decoration(TextDecoration.ITALIC, false));
            lore.add(Component.text("\u25a0 click to sell").color(NamedTextColor.YELLOW).decoration(TextDecoration.ITALIC, false));
            buyMeta.lore(lore);
            buy.setItemMeta(buyMeta);
            inv.setItem(i, buy);
        }


    }

    @Override
    public Inventory getInventory() {
        return inv;
    }
}
