package com.github.telvarost.oldandornate;

import net.minecraft.item.ItemStack;

public class SkyDungeonLoot {
    // randBound of -1 means to always spawn item if it gets picked
    public int randBound;

    // randCount of -1 to ignore random count
    public int randCount;

    // Item to spawn (count is ignored unless if randCount is -1)
    public ItemStack itemStack;

    public SkyDungeonLoot(int randBound, int randCount, ItemStack itemStack) {
        this.randBound = randBound;
        this.randCount = randCount;
        this.itemStack = itemStack;
    }

    @Override
    public String toString() {
        return "RandBound: " + randBound + ", ItemStack: " + itemStack;
    }
}
