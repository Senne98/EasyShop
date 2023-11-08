package org.super_man2006.easyshop.shop.events;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.super_man2006.custom_item_api.CustomItems.items.CustomItem;
import org.super_man2006.easyshop.EasyShop;
import org.super_man2006.easyshop.shop.inventories.BuyInv;
import org.super_man2006.easyshop.shop.inventories.SellInv;
import org.super_man2006.easyshop.shop.inventories.ShopInv;
import org.super_man2006.easyshop.shop.types.Item;
import org.super_man2006.easyshop.shop.types.Shop;
import org.super_man2006.easyshop.shop.types.SingleItem;
import org.super_man2006.geldapi.currency.Currency;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ShopInvClick implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getClickedInventory() == null) return;
        if (!(e.getClickedInventory().getHolder() instanceof ShopInv)) return;

        e.setCancelled(true);

        ItemStack clickItem = e.getClickedInventory().getItem(e.getSlot());
        ItemMeta clickMeta = clickItem.getItemMeta();
        PersistentDataContainer container = clickMeta.getPersistentDataContainer();

        if (!container.has(new NamespacedKey(EasyShop.plugin, "shopinstance"), PersistentDataType.STRING)) return;

        String shopInstance = container.get(new NamespacedKey(EasyShop.plugin, "shopinstance"), PersistentDataType.STRING);
        NamespacedKey shopInstanceId = NamespacedKey.fromString(container.get(new NamespacedKey(EasyShop.plugin, "shopinstanceid"), PersistentDataType.STRING));

        Player player = (Player) e.getWhoClicked();

        if (shopInstance.equals("singleitem")) {

            if (e.isLeftClick() && SingleItem.instances.get(shopInstanceId).getBuyPrice() != -1) {
                int buyPrice = SingleItem.instances.get(shopInstanceId).getBuyPrice();
                Currency currency = SingleItem.instances.get(shopInstanceId).getCurrency();

                if (currency.get(player.getUniqueId()) >= buyPrice) {
                    currency.add(player.getUniqueId(), (long) -buyPrice);
                    player.getInventory().addItem(CustomItem.getItemStack(SingleItem.instances.get(shopInstanceId).getItem()));
                }

            } else if (e.isRightClick() && SingleItem.instances.get(shopInstanceId).getSellPrice() != -1) {
                SingleItem singleItem = SingleItem.instances.get(shopInstanceId);

                AtomicInteger amount = new AtomicInteger(1);
                Currency currency = singleItem.getCurrency();

                AtomicInteger itemsInInv = new AtomicInteger(0);

                AtomicBoolean custom = new AtomicBoolean(false);
                if (CustomItem.isCodeName(singleItem.getItem())) {
                    custom.set(true);
                }

                e.getWhoClicked().getInventory().forEach(itemStack -> {
                    if (itemStack != null) {
                        if (custom.get()) {
                            if (CustomItem.getCodeName(itemStack) == singleItem.getItem()) {
                                itemsInInv.addAndGet(itemStack.getAmount());
                            }
                        } else {
                            if (itemStack.getType() == CustomItem.getItemStack(singleItem.getItem()).getType()) {
                                itemsInInv.addAndGet(itemStack.getAmount());
                            }
                        }
                    }
                });

                if (amount.get() > itemsInInv.get()) return;

                currency.add(e.getWhoClicked().getUniqueId(), (long) (singleItem.getSellPrice()));

                e.getWhoClicked().getInventory().forEach(itemStack -> {
                    if (itemStack != null) {
                        if (custom.get()) {
                            if (CustomItem.getCodeName(itemStack) == singleItem.getItem()) {
                                if (itemStack.getAmount() > amount.get()) {
                                    itemStack.setAmount(itemStack.getAmount() - amount.get());
                                    amount.addAndGet(-itemStack.getAmount());
                                } else {
                                    itemStack.setAmount(0);
                                    amount.addAndGet(-itemStack.getAmount());
                                }
                            }
                        } else {
                            if (itemStack.getType() == CustomItem.getItemStack(singleItem.getItem()).getType()) {
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

            return;
        }

        if (shopInstance.equals("item")) {

            NamespacedKey previous = NamespacedKey.fromString(e.getClickedInventory().getItem(0).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(EasyShop.plugin, "previousid"), PersistentDataType.STRING));

            if (e.isLeftClick() && Item.instances.get(shopInstanceId).getBuyPrice() != -1) {
                BuyInv gui = new BuyInv(Item.instances.get(shopInstanceId), previous);
                player.openInventory(gui.getInventory());

            } else if (e.isRightClick() && Item.instances.get(shopInstanceId).getSellPrice() != -1) {
                SellInv gui = new SellInv(Item.instances.get(shopInstanceId), previous);
                player.openInventory(gui.getInventory());
            }

            return;
        }

        if (shopInstance.equals("shop")) {
            ShopInv gui = new ShopInv(Shop.instances.get(shopInstanceId));
            player.openInventory(gui.getInventory());
        }
    }
}
