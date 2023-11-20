package org.super_man2006.easyshop.shop.types;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;

public class Empty extends ShopInstance{
    public Empty() {
        super(Component.text(""), NamespacedKey.minecraft("gray_stained_glass_pane"));
    }
}
