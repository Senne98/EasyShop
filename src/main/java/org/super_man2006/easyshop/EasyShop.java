package org.super_man2006.easyshop;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.super_man2006.easyshop.debug.OpenCommand;
import org.super_man2006.easyshop.shop.events.BuyInvClick;
import org.super_man2006.easyshop.shop.events.SellInvClick;
import org.super_man2006.easyshop.shop.events.ShopInvClick;
import org.super_man2006.easyshop.shop.types.Item;
import org.super_man2006.easyshop.shop.types.Shop;
import org.super_man2006.easyshop.shop.types.SingleItem;
import org.super_man2006.geldapi.Geld_API;
import org.super_man2006.geldapi.currency.Currency;

import java.util.ArrayList;
import java.util.List;

public final class EasyShop extends JavaPlugin {

    public static Plugin plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        // events
        getServer().getPluginManager().registerEvents(new ShopInvClick(), this);
        getServer().getPluginManager().registerEvents(new SellInvClick(), this);
        getServer().getPluginManager().registerEvents(new BuyInvClick(), this);

        // commands
        getCommand("shop").setExecutor(new OpenCommand());

        //
        Currency currency = new Currency(new NamespacedKey(this, "coins"), Component.text("coins"), Component.text("µ"));
        
        SingleItem singleItem = new SingleItem(Component.text("single"), new NamespacedKey("minecraft", "coal"), new NamespacedKey("minecraft", "coal"), Geld_API.currencyList.get(new NamespacedKey(this, "coins")), 1, 1, new NamespacedKey(this, "singleitem"));
        Item item = new Item(Component.text("item"), new NamespacedKey("minecraft", "coal"), new NamespacedKey("minecraft", "coal"), Geld_API.currencyList.get(new NamespacedKey(this, "coins")), 1, 1, new NamespacedKey(this, "item"));

        List<Object> layout = new ArrayList<>();
        layout.add(singleItem);
        layout.add(item);

        Shop shop2 = new Shop(Component.text("shop2"), new NamespacedKey("minecraft", "coal"), layout, new NamespacedKey(this, "shop2"));

        List<Object> layout2 = new ArrayList<>();
        layout2.add(singleItem);
        layout2.add(item);
        layout2.add(shop2);

        Shop shop = new Shop(Component.text("shop"), new NamespacedKey("minecraft", "coal"), layout2, new NamespacedKey(this, "shop"));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
