package com.github.telvarost.oldandornate;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.event.registry.DimensionRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

import java.util.ArrayList;
import java.util.Random;

public class OldAndOrnate {
    //public static final Namespace NAMESPACE = Namespace.resolve();
    @Entrypoint.Namespace
    public static Namespace OLD_AND_ORNATE = Null.get();

    public static int ADOBE_TEXTURE = 0;
    public static int ADOBE_BRICKS_TEXTURE = 0;
    public static int DUNGEON_PLATFORM_TEXTURE_TOP = 0;
    public static int DUNGEON_PLATFORM_TEXTURE_SIDE = 0;
    public static int DUNGEON_PLATFORM_TEXTURE_BOTTOM = 0;
    public static int FALTERING_PLATFORM_TEXTURE_TOP = 0;
    public static int FALTERING_PLATFORM_TEXTURE_SIDE = 0;
    public static int FALTERING_PLATFORM_TEXTURE_BOTTOM = 0;
    public static int GHOST_PLATFORM_TEXTURE_TOP = 0;
    public static int GHOST_PLATFORM_TEXTURE_SIDE = 0;
    public static int STAR_FLOWER_TEXTURE = 0;

    public static ArrayList<SkyDungeonLoot> skylandsDungeonLootTable = new ArrayList<>();

    @EventListener
    public static void registerDimensions(DimensionRegistryEvent event) {
        Random random = new Random();
        OldAndOrnate.skylandsDungeonLootTable.add(new SkyDungeonLoot(-1,  1, new ItemStack(Block.COBWEB        )));
        OldAndOrnate.skylandsDungeonLootTable.add(new SkyDungeonLoot(-1,  4, new ItemStack(Item.GOLD_INGOT     )));
        OldAndOrnate.skylandsDungeonLootTable.add(new SkyDungeonLoot(-1,  1, new ItemStack(Item.APPLE          )));
        OldAndOrnate.skylandsDungeonLootTable.add(new SkyDungeonLoot(-1,  4, new ItemStack(Item.SNOWBALL       )));
        OldAndOrnate.skylandsDungeonLootTable.add(new SkyDungeonLoot(-1,  4, new ItemStack(Item.DYE            , 1, 4)));
        OldAndOrnate.skylandsDungeonLootTable.add(new SkyDungeonLoot(-1,  4, new ItemStack(Item.CLAY           )));
        OldAndOrnate.skylandsDungeonLootTable.add(new SkyDungeonLoot(-1,  4, new ItemStack(Item.GLOWSTONE_DUST )));
        OldAndOrnate.skylandsDungeonLootTable.add(new SkyDungeonLoot(100, 1, new ItemStack(Item.GOLDEN_APPLE   )));
        OldAndOrnate.skylandsDungeonLootTable.add(new SkyDungeonLoot(10,  1, new ItemStack(Item.MAP            )));
        OldAndOrnate.skylandsDungeonLootTable.add(new SkyDungeonLoot(10,  1, new ItemStack(Item.RECORD_THIRTEEN)));
        OldAndOrnate.skylandsDungeonLootTable.add(new SkyDungeonLoot(-1,  1, new ItemStack(Item.DYE            , 1, 3)));
    }
}
