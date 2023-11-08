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
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.super_man2006.custom_item_api.CustomItems.items.CustomItem;
import org.super_man2006.easyshop.EasyShop;
import org.super_man2006.easyshop.shop.types.Item;
import org.super_man2006.easyshop.shop.types.Shop;
import org.super_man2006.easyshop.shop.types.SingleItem;

import java.util.ArrayList;
import java.util.List;

public class ShopInv implements InventoryHolder {

    Inventory inv;

    public ShopInv(Shop shop) {
        List<Object> layout = shop.getLayout();
        int size = layout.size();

        size = (int) Math.ceil(size/9);

        if (layout.size() % 9 != 0) size++;

        if (size > 6) size = 6;
        size *= 9;


        inv = Bukkit.createInventory(this, size, shop.getName());

        ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta fillerMeta = filler.getItemMeta();
        fillerMeta.displayName(Component.text(""));
        filler.setItemMeta(fillerMeta);
        for (int i = 0; i < size; i++) {
            inv.setItem(i, filler);
        }

        for (int i = 0; i < layout.size(); i++) {
            if (layout == null) {
                continue;
            }
            if (layout.get(i) instanceof SingleItem) {
                SingleItem singleItem = (SingleItem) layout.get(i);
                ItemStack icon = CustomItem.getItemStack(singleItem.getIcon());

                ItemMeta iconMeta = icon.getItemMeta();
                iconMeta.displayName(singleItem.getName().decoration(TextDecoration.ITALIC, false));
                PersistentDataContainer container = iconMeta.getPersistentDataContainer();
                container.set(new NamespacedKey(EasyShop.plugin, "shopinstanceid"), PersistentDataType.STRING, singleItem.getId().asString());
                container.set(new NamespacedKey(EasyShop.plugin, "shopinstance"), PersistentDataType.STRING, "singleitem");

                List<Component> lore = new ArrayList<>();
                if (singleItem.getBuyPrice() != -1) {
                    lore.add(Component.text("buy price: ").color(NamedTextColor.WHITE).append(Component.text(singleItem.getBuyPrice()).color(NamedTextColor.GREEN)).decoration(TextDecoration.ITALIC, false));
                }
                if (singleItem.getSellPrice() != -1) {
                    lore.add(Component.text("sell price: ").color(NamedTextColor.WHITE).append(Component.text(singleItem.getSellPrice()).color(NamedTextColor.RED)).decoration(TextDecoration.ITALIC, false));
                }
                if (singleItem.getBuyPrice() != -1) {
                    lore.add(Component.text("\u25a0 left click to buy instantly").color(NamedTextColor.YELLOW).decoration(TextDecoration.ITALIC, false));
                }
                if (singleItem.getSellPrice() != -1) {
                    lore.add(Component.text("\u25a0 right click to sell instantly").color(NamedTextColor.YELLOW).decoration(TextDecoration.ITALIC, false));
                }

                iconMeta.lore(lore);
                icon.setItemMeta(iconMeta);

                inv.setItem(i, icon);

            }
            if (layout.get(i) instanceof Item) {
                Item item = (Item) layout.get(i);
                ItemStack icon = CustomItem.getItemStack(item.getIcon());

                ItemMeta iconMeta = icon.getItemMeta();
                iconMeta.displayName(item.getName().decoration(TextDecoration.ITALIC, false));
                PersistentDataContainer container = iconMeta.getPersistentDataContainer();
                container.set(new NamespacedKey(EasyShop.plugin, "shopinstanceid"), PersistentDataType.STRING, item.getId().asString());
                container.set(new NamespacedKey(EasyShop.plugin, "shopinstance"), PersistentDataType.STRING, "item");

                List<Component> lore = new ArrayList<>();
                if (item.getBuyPrice() != -1) {
                    lore.add(Component.text("buy price: ").color(NamedTextColor.WHITE).append(Component.text(item.getBuyPrice()).color(NamedTextColor.GREEN)).decoration(TextDecoration.ITALIC, false));
                }
                if (item.getSellPrice() != -1) {
                    lore.add(Component.text("sell price: ").color(NamedTextColor.WHITE).append(Component.text(item.getSellPrice()).color(NamedTextColor.RED)).decoration(TextDecoration.ITALIC, false));
                }
                if (item.getBuyPrice() != -1) {
                    lore.add(Component.text("\u25a0 left click to buy").color(NamedTextColor.YELLOW).decoration(TextDecoration.ITALIC, false));
                }
                if (item.getSellPrice() != -1) {
                    lore.add(Component.text("\u25a0 right click to sell").color(NamedTextColor.YELLOW).decoration(TextDecoration.ITALIC, false));
                }

                iconMeta.lore(lore);
                icon.setItemMeta(iconMeta);

                inv.setItem(i, icon);

            }
            if (layout.get(i) instanceof Shop) {
                Shop shopPlace = (Shop) layout.get(i);
                ItemStack icon = CustomItem.getItemStack(shopPlace.getIcon());

                ItemMeta iconMeta = icon.getItemMeta();
                iconMeta.displayName(shopPlace.getName().decoration(TextDecoration.ITALIC, false));
                PersistentDataContainer container = iconMeta.getPersistentDataContainer();
                container.set(new NamespacedKey(EasyShop.plugin, "shopinstanceid"), PersistentDataType.STRING, shopPlace.getId().asString());
                container.set(new NamespacedKey(EasyShop.plugin, "shopinstance"), PersistentDataType.STRING, "shop");

                List<Component> lore = new ArrayList<>();
                lore.add(Component.text("\u25a0 click to open").color(NamedTextColor.YELLOW).decoration(TextDecoration.ITALIC, false));
                iconMeta.lore(lore);

                icon.setItemMeta(iconMeta);


                inv.setItem(i, icon);

            }

            ItemStack first = inv.getItem(0);
            ItemMeta firstMeta = first.getItemMeta();
            firstMeta.getPersistentDataContainer().set(new NamespacedKey(EasyShop.plugin, "previousid"), PersistentDataType.STRING, shop.getId().asString());
            first.setItemMeta(firstMeta);
        }
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }
}
