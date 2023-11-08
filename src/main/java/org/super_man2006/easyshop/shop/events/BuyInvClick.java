package org.super_man2006.easyshop.shop.events;

import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.super_man2006.custom_item_api.CustomItems.items.CustomItem;
import org.super_man2006.easyshop.EasyShop;
import org.super_man2006.easyshop.shop.inventories.BuyInv;
import org.super_man2006.easyshop.shop.inventories.ShopInv;
import org.super_man2006.easyshop.shop.types.Item;
import org.super_man2006.easyshop.shop.types.Shop;
import org.super_man2006.geldapi.currency.Currency;

public class BuyInvClick implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getClickedInventory() == null) return;
        if (!(e.getClickedInventory().getHolder() instanceof BuyInv)) return;

        e.setCancelled(true);

        Item item = Item.instances.get(NamespacedKey.fromString(e.getClickedInventory().getItem(4).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(EasyShop.plugin, "shopinstanceid"), PersistentDataType.STRING)));
        int slot = e.getSlot();

        if (slot == 22) {
            Shop shop = Shop.instances.get(NamespacedKey.fromString(e.getClickedInventory().getItem(22).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(EasyShop.plugin, "shop"), PersistentDataType.STRING)));

            ShopInv gui = new ShopInv(shop);
            e.getWhoClicked().openInventory(gui.getInventory());
            return;
        }

        if (slot < 9 || slot > 17) return;

        int amount = (int) Math.pow(2, slot - 9);
        Currency currency = item.getCurrency();

        if (currency.get(e.getWhoClicked().getUniqueId()) >= item.getBuyPrice() * amount) {
            currency.add(e.getWhoClicked().getUniqueId(), (long) -(item.getBuyPrice() * amount));
            ItemStack giveItem = CustomItem.getItemStack(item.getItem());
            giveItem.setAmount(amount);
            e.getWhoClicked().getInventory().addItem(giveItem);
        }


    }
}
