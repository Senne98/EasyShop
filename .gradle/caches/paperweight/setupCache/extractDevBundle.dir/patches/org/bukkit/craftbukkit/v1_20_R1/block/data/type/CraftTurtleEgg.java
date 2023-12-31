package org.bukkit.craftbukkit.v1_20_R1.block.data.type;

import org.bukkit.block.data.type.TurtleEgg;
import org.bukkit.craftbukkit.v1_20_R1.block.data.CraftBlockData;

public abstract class CraftTurtleEgg extends CraftBlockData implements TurtleEgg {

    private static final net.minecraft.world.level.block.state.properties.IntegerProperty EGGS = getInteger("eggs");

    @Override
    public int getEggs() {
        return get(CraftTurtleEgg.EGGS);
    }

    @Override
    public void setEggs(int eggs) {
        set(CraftTurtleEgg.EGGS, eggs);
    }

    @Override
    public int getMinimumEggs() {
        return getMin(CraftTurtleEgg.EGGS);
    }

    @Override
    public int getMaximumEggs() {
        return getMax(CraftTurtleEgg.EGGS);
    }
}
