package org.bukkit.craftbukkit.v1_20_R1.inventory;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.ResultContainer;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.SmithingInventory;

public class CraftInventorySmithing extends CraftResultInventory implements SmithingInventory {

    private final Location location;

    public CraftInventorySmithing(Location location, Container inventory, ResultContainer resultInventory) {
        super(inventory, resultInventory);
        this.location = location;
    }

    @Override
    public ResultContainer getResultInventory() {
        return (ResultContainer) super.getResultInventory();
    }

    @Override
    public Location getLocation() {
        return this.location;
    }

    @Override
    public ItemStack getResult() {
        return getItem(net.minecraft.world.inventory.SmithingMenu.RESULT_SLOT); // Paper
    }

    @Override
    public void setResult(ItemStack item) {
        setItem(net.minecraft.world.inventory.SmithingMenu.RESULT_SLOT, item); // Paper
    }

    @Override
    public Recipe getRecipe() {
        net.minecraft.world.item.crafting.Recipe recipe = this.getResultInventory().getRecipeUsed();
        return (recipe == null) ? null : recipe.toBukkitRecipe();
    }
}
