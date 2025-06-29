package com.github.telvarost.oldandornate;

import jadestrouble.musicdiscs.items.Discs;
import net.minecraft.item.ItemStack;

import java.util.Random;

public class ModHelperMusicDiscs {
    public static ItemStack getRandomDisc(Random random) {
        return new ItemStack(Discs.items[random.nextInt(Discs.items.length - 1)], 1);
    }
}
