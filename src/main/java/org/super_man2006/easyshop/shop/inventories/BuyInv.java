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
import org.super_man2006.easyshop.shop.types.Item;

import java.util.ArrayList;
import java.util.List;

public class BuyInv implements InventoryHolder {

    Inventory inv;

    public BuyInv(Item item, NamespacedKey shopId) {
        int price = item.getBuyPrice();

        inv = Bukkit.createInventory(this, 27, item.getName());

        ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta fillerMeta = filler.getItemMeta();
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
        closeMeta.displayName(Component.text("Close").color(NamedTextColor.RED).decoration(TextDecoration.ITALIC, false));
        closeMeta.getPersistentDataContainer().set(new NamespacedKey(EasyShop.plugin, "shop"), PersistentDataType.STRING, shopId.asString());
        close.setItemMeta(closeMeta);
        inv.setItem(22, close);


        for (int i = 9; i < 18; i++) {
            int amount = (int) Math.pow(2, i - 9);

            ItemStack buy = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            ItemMeta buyMeta = buy.getItemMeta();
            buyMeta.displayName(Component.text("buy " + amount).color(NamedTextColor.GREEN).decoration(TextDecoration.ITALIC, false));
            List<Component> lore = new ArrayList<>();
            lore.add(Component.text("price: " + (item.getBuyPrice() * amount)).color(NamedTextColor.WHITE).decoration(TextDecoration.ITALIC, false));
            lore.add(Component.text("\u25a0 click to buy").color(NamedTextColor.YELLOW).decoration(TextDecoration.ITALIC, false));
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
