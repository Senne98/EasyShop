package org.super_man2006.easyshop.shop.types;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.super_man2006.easyshop.shop.inventories.ShopInv;

import java.util.HashMap;
import java.util.List;

/**
 * Is used to represent a shop page in a shop tree. In {@link #layout} you can put {@link Shop},
 * {@link SingleItem}, {@link Item} or {@link null} for an empty spot. The size of {@link #layout} can not
 * exceed 54 as this is maximum inventory size allowed by minecraft.
 */
public class Shop extends ShopInstance {

    public static HashMap<NamespacedKey, Shop> instances = new HashMap<>();
    private List<Object> layout;
    private NamespacedKey id;

    /**
     * Initializes a shop tab. The name provided by a {@link Component} will be shown as the name of the
     * inventory and the name of the icon in other shop tabs that link to this tab. The icon provided by
     * a {@link NamespacedKey} will be shown in tabs that link to this tab and can be in the format
     * "minecraft:[item]" or alternatively you can use the key of a
     * {@link org.super_man2006.custom_item_api.CustomItems.items.CustomItem} from Custom_Item_Api.
     * The id of the shop provided by a {@link NamespacedKey} is the id used to open the shop, but
     * won't be shown anywhere in-game.
     * @param name
     * @param icon
     * @param layout
     * @param id
     */
    public Shop(Component name, NamespacedKey icon, List<Object> layout, NamespacedKey id) {
        super(name, icon);
        this.layout = layout;
        instances.put(id, this);
        this.id = id;
    }

    public NamespacedKey getId() {
        return id;
    }

    public List<Object> getLayout() {
        return layout;
    }

    public static void openShop(Player player, NamespacedKey id) {
        ShopInv gui = new ShopInv(instances.get(id));
        player.openInventory(gui.getInventory());
    }
}
