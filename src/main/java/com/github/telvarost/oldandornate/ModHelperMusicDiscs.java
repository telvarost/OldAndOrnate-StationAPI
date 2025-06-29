package com.github.telvarost.oldandornate;

import jadestrouble.musicdiscs.items.Discs;
import net.minecraft.item.ItemStack;

import java.util.Random;

public class ModHelperMusicDiscs {
    public static ItemStack getRandomDisc(Random random) {
        return new ItemStack(Discs.dungeonDiscSpawnList.get(random.nextInt(Discs.dungeonDiscSpawnList.size())), 1);
    }
}
