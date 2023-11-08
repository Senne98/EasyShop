package org.super_man2006.easyshop.shop.events;

import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.persistence.PersistentDataType;
import org.super_man2006.custom_item_api.CustomItems.items.CustomItem;
import org.super_man2006.easyshop.EasyShop;
import org.super_man2006.easyshop.shop.inventories.SellInv;
import org.super_man2006.easyshop.shop.inventories.ShopInv;
import org.super_man2006.easyshop.shop.types.Item;
import org.super_man2006.easyshop.shop.types.Shop;
import org.super_man2006.geldapi.currency.Currency;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class SellInvClick implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getClickedInventory() == null) return;
        if (!(e.getClickedInventory().getHolder() instanceof SellInv)) return;

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

        AtomicInteger amount = new AtomicInteger((int) Math.pow(2, slot - 9));
        Currency currency = item.getCurrency();

        AtomicInteger itemsInInv = new AtomicInteger(0);

        AtomicBoolean custom = new AtomicBoolean(false);
        if (CustomItem.isCodeName(item.getItem())) {
            custom.set(true);
        }

        e.getWhoClicked().getInventory().forEach(itemStack -> {
            if (itemStack != null) {
                if (custom.get()) {
                    if (CustomItem.getCodeName(itemStack) == item.getItem()) {
                        itemsInInv.addAndGet(itemStack.getAmount());
                    }
                } else {
                    if (itemStack.getType() == CustomItem.getItemStack(item.getItem()).getType()) {
                        itemsInInv.addAndGet(itemStack.getAmount());
                    }
                }
            }
        });

        if (amount.get() > itemsInInv.get()) return;

        currency.add(e.getWhoClicked().getUniqueId(), (long) (item.getSellPrice() * amount.get()));

        e.getWhoClicked().getInventory().forEach(itemStack -> {
            if (itemStack != null) {
                if (custom.get()) {
                    if (CustomItem.getCodeName(itemStack) == item.getItem()) {
                        if (itemStack.getAmount() > amount.get()) {
                            itemStack.setAmount(itemStack.getAmount() - amount.get());
                            amount.addAndGet(-itemStack.getAmount());
                        } else {
                            itemStack.setAmount(0);
                            amount.addAndGet(-itemStack.getAmount());
                        }
                    }
                } else {
                    if (itemStack.getType() == CustomItem.getItemStack(item.getItem()).getType()) {
                        if (itemStack.getAmount() > amount.get()) {
                            itemStack.setAmount(itemStack.getAmount() - amount.get());
                            amount.addAndGet(-itemStack.getAmount());
                        } else {
                            itemStack.setAmount(0);
                            amount.addAndGet(-itemStack.getAmount());
                        }
                    }
                }
            }
        });
    }
}
