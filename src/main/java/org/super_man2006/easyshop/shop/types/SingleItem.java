package org.super_man2006.easyshop.shop.types;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.super_man2006.geldapi.currency.Currency;

import java.util.HashMap;

/**
 * Represents an item that can be bought and/or sold in a shop. When selected in a shop one will
 * be bought/sold immediately without opening a UI.
 */
public class SingleItem extends ShopInstance {

    public static HashMap<NamespacedKey, SingleItem> instances = new HashMap<>();

    private NamespacedKey item;
    private Currency currency;
    private int sellPrice;
    private int buyPrice;
    private NamespacedKey id;

    /**
     * Initializes an item in a shop, buy or sell should be seen from the
     * perspective of the player opening the shop. The name provided by a {@link Component}
     * will be shown as the name of the icon in shop tabs that link to this item. The icon provided by
     * a {@link NamespacedKey} will be shown in tabs that link to this tab and can be in the format
     * "minecraft:[item]" or alternatively you can use the key of a
     * {@link org.super_man2006.custom_item_api.CustomItems.items.CustomItem} from Custom_Item_Api.
     * The item, also provided
     * by a {@link NamespacedKey} is the item you want to buy or sell and works in the same way as
     * the icon. The currency is a {@link Currency} from Geld_Api. The buyPrice and sellPrice (again
     * from the perspective of the player) are the prices of a single item.
     *
     * @param name
     * @param icon
     * @param item
     * @param currency
     * @param sellPrice
     * @param buyPrice
     */
    public SingleItem(Component name, NamespacedKey icon, NamespacedKey item, Currency currency, int sellPrice, int buyPrice, NamespacedKey id) {
        super(name, icon);
        this.item = item;
        this.currency = currency;
        this.sellPrice = sellPrice;
        this.buyPrice = buyPrice;
        instances.put(id, this);
        this.id = id;
    }

    /**
     * Initializes an item in a shop, buy or sell should be seen from the
     * perspective of the player opening the shop. The name provided by a {@link Component}
     * will be shown as the name of the icon in shop tabs that link to this item. The icon provided by
     * a {@link NamespacedKey} will be shown in tabs that link to this tab and can be in the format
     * "minecraft:[item]" or alternatively you can use the key of a
     * {@link org.super_man2006.custom_item_api.CustomItems.items.CustomItem} from Custom_Item_Api.
     * The item, also provided
     * by a {@link NamespacedKey} is the item you want to buy or sell and works in the same way as
     * the icon. The currency is a {@link Currency} from Geld_Api. The sellPrice (again
     * from the perspective of the player) is the price of a single item.
     *
     * @param name
     * @param icon
     * @param item
     * @param currency
     * @param sellPrice
     */
    public SingleItem(Component name, NamespacedKey icon, NamespacedKey item, Currency currency, int sellPrice, NamespacedKey id) {
        super(name, icon);
        this.item = item;
        this.currency = currency;
        this.sellPrice = sellPrice;
        instances.put(id, this);
        this.id = id;
    }

    /**
     * Initializes an item in a shop, buy or sell should be seen from the
     * perspective of the player opening the shop. The name provided by a {@link Component}
     * will be shown as the name of the icon in shop tabs that link to this item. The icon provided by
     * a {@link NamespacedKey} will be shown in tabs that link to this tab and can be in the format
     * "minecraft:[item]" or alternatively you can use the key of a
     * {@link org.super_man2006.custom_item_api.CustomItems.items.CustomItem} from Custom_Item_Api.
     * The item, also provided
     * by a {@link NamespacedKey} is the item you want to buy or sell and works in the same way as
     * the icon. The currency is a {@link Currency} from Geld_Api. The buyPrice (again
     * from the perspective of the player) is the price of a single item.
     *
     * @param name
     * @param icon
     * @param item
     * @param currency
     * @param buyPrice
     */
    public SingleItem(Component name, NamespacedKey icon, NamespacedKey item, int buyPrice, Currency currency, NamespacedKey id) {
        super(name, icon);
        this.item = item;
        this.currency = currency;
        this.buyPrice = buyPrice;
        instances.put(id, this);
        this.id = id;
    }

    public NamespacedKey getId() {
        return id;
    }

    public NamespacedKey getItem() {
        return item;
    }

    public Currency getCurrency() {
        return currency;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public int getBuyPrice() {
        return buyPrice;
    }
}
