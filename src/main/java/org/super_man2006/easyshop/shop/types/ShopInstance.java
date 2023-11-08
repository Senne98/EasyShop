package org.super_man2006.easyshop.shop.types;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;

public abstract class ShopInstance {

    private NamespacedKey icon;
    private Component name;

    public ShopInstance(Component name, NamespacedKey icon) {
        this.name = name;
        this.icon = icon;
    }

    public NamespacedKey getIcon() {
        return icon;
    }

    public Component getName() {
        return name;
    }


}
