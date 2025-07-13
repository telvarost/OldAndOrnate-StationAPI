package com.github.telvarost.oldandornate.gen;

import java.util.Random;

import com.github.telvarost.oldandornate.ModHelperElementalCreepers;
import com.github.telvarost.oldandornate.ModHelperMusicDiscs;
import com.github.telvarost.oldandornate.OldAndOrnate;
import com.github.telvarost.oldandornate.SkyDungeonLoot;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.entity.MobSpawnerBlockEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.map.MapState;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;
import org.checkerframework.common.aliasing.qual.Unique;

import static com.github.telvarost.oldandornate.events.init.BlockListener.DUNGEON_PLATFORM;

public class SkyDungeonFeature extends Feature {
    @Unique
    private boolean hasDungeonMap = false;

    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        int yAdjusted = y + 7;
        hasDungeonMap = false;

        drawOctahedron(world, x, yAdjusted, z, 0, Block.CHEST.id);
        ChestBlockEntity chestEntity = (ChestBlockEntity)world.getBlockEntity(x, yAdjusted, z);

        for (int attemptIndex = 0; attemptIndex < 16; attemptIndex++) {
            ItemStack itemStack = this.getRandomChestItem(random, world, x, z);
            if (itemStack != null) {
                chestEntity.setStack(random.nextInt(chestEntity.size()), itemStack);
            }
        }

        drawOctahedron(world, x, yAdjusted, z, 1, Block.OBSIDIAN.id);
        drawOctahedron(world, x, yAdjusted, z, 2, 0);
        drawOctahedron(world, x, yAdjusted, z, 3, 0);
        drawOctahedron(world, x, yAdjusted, z, 4, 0);
        drawOctahedron(world, x, yAdjusted, z, 5, 0);
        drawOctahedron(world, x, yAdjusted, z, 6, 0);
        drawOctahedron(world, x, yAdjusted, z, 7, DUNGEON_PLATFORM.id);

        if (0 == world.random.nextInt(8)) {
            world.setBlock(x + 6, yAdjusted, z, Block.TNT.id, 1);
            world.setBlock(x - 6, yAdjusted, z, Block.TNT.id, 1);
            world.setBlock(x, yAdjusted, z + 6, Block.TNT.id, 1);
            world.setBlock(x, yAdjusted, z - 6, Block.TNT.id, 1);
        }

        if (0 == world.random.nextInt(2)) {
            world.setBlock(x + 5, yAdjusted, z, DUNGEON_PLATFORM.id);
            world.setBlock(x - 5, yAdjusted, z, DUNGEON_PLATFORM.id);
            world.setBlock(x, yAdjusted, z + 5, DUNGEON_PLATFORM.id);
            world.setBlock(x, yAdjusted, z - 5, DUNGEON_PLATFORM.id);
        }

        int direction = world.random.nextInt(4);
        int xOffset2 = 0;
        int zOffset2 = 0;

        if (0 == direction) {
            xOffset2++;
        } else if (1 == direction) {
            xOffset2--;
        } else if (2 == direction) {
            zOffset2++;
        } else {
            zOffset2--;
        }

        drawDiamond(world, x + zOffset2, yAdjusted - 3, z + xOffset2, 1, DUNGEON_PLATFORM.id);
        drawDiamond(world, x - zOffset2, yAdjusted - 3, z - xOffset2, 1, DUNGEON_PLATFORM.id);
        drawDiamond(world, x + zOffset2, yAdjusted - 3, z + xOffset2, 0, DUNGEON_PLATFORM.id);
        drawDiamond(world, x - zOffset2, yAdjusted - 3, z - xOffset2, 0, DUNGEON_PLATFORM.id);

        drawDiamond(world, x - (xOffset2 * 2), yAdjusted - 2, z - (zOffset2 * 2), 1, DUNGEON_PLATFORM.id);
        drawDiamond(world, x - (xOffset2 * 3), yAdjusted - 2, z - (zOffset2 * 3), 0, 0);
        drawDiamond(world, x - (xOffset2 * 2), yAdjusted - 1, z - (zOffset2 * 2), 0, DUNGEON_PLATFORM.id);

        world.setBlock(x + (zOffset2 * 2), yAdjusted, z + (xOffset2 * 2), DUNGEON_PLATFORM.id);
        world.setBlock(x - (zOffset2 * 2), yAdjusted, z - (xOffset2 * 2), DUNGEON_PLATFORM.id);

        if (0 != world.random.nextInt(4)) {
            world.setBlock(x + (zOffset2 * 3), yAdjusted, z + (xOffset2 * 3), DUNGEON_PLATFORM.id);
            world.setBlock(x - (zOffset2 * 3), yAdjusted, z - (xOffset2 * 3), DUNGEON_PLATFORM.id);
        }

        world.setBlock(x + (zOffset2 * 3), yAdjusted - 2, z + (xOffset2 * 3), DUNGEON_PLATFORM.id);
        world.setBlock(x - (zOffset2 * 3), yAdjusted - 2, z - (xOffset2 * 3), DUNGEON_PLATFORM.id);

        world.setBlock(x + (zOffset2 * 1) + xOffset2, yAdjusted + 1, z + (xOffset2 * 1) + zOffset2, DUNGEON_PLATFORM.id);
        world.setBlock(x - (zOffset2 * 1) + xOffset2, yAdjusted + 1, z - (xOffset2 * 1) + zOffset2, DUNGEON_PLATFORM.id);
        world.setBlock(x + (zOffset2 * 2) + xOffset2, yAdjusted + 1, z + (xOffset2 * 2) + zOffset2, DUNGEON_PLATFORM.id);
        world.setBlock(x - (zOffset2 * 2) + xOffset2, yAdjusted + 1, z - (xOffset2 * 2) + zOffset2, DUNGEON_PLATFORM.id);
        world.setBlock(x + (zOffset2 * 3) + xOffset2, yAdjusted + 1, z + (xOffset2 * 3) + zOffset2, DUNGEON_PLATFORM.id);
        world.setBlock(x - (zOffset2 * 3) + xOffset2, yAdjusted + 1, z - (xOffset2 * 3) + zOffset2, DUNGEON_PLATFORM.id);

        world.setBlock(x + (zOffset2 * 1) - xOffset2, yAdjusted - 1, z + (xOffset2 * 1) - zOffset2, DUNGEON_PLATFORM.id);
        world.setBlock(x - (zOffset2 * 1) - xOffset2, yAdjusted - 1, z - (xOffset2 * 1) - zOffset2, DUNGEON_PLATFORM.id);
        world.setBlock(x + (zOffset2 * 2) - xOffset2, yAdjusted - 1, z + (xOffset2 * 2) - zOffset2, DUNGEON_PLATFORM.id);
        world.setBlock(x - (zOffset2 * 2) - xOffset2, yAdjusted - 1, z - (xOffset2 * 2) - zOffset2, DUNGEON_PLATFORM.id);
        world.setBlock(x + (zOffset2 * 3) - xOffset2, yAdjusted - 1, z + (xOffset2 * 3) - zOffset2, DUNGEON_PLATFORM.id);
        world.setBlock(x - (zOffset2 * 3) - xOffset2, yAdjusted - 1, z - (xOffset2 * 3) - zOffset2, DUNGEON_PLATFORM.id);

        if (0 == world.random.nextInt(4)) {
            drawDiamond(world, x + (xOffset2 * 2), yAdjusted + 2, z + (zOffset2 * 2), 1, DUNGEON_PLATFORM.id);
            drawDiamond(world, x + (xOffset2 * 2), yAdjusted + 2, z + (zOffset2 * 2), 0, DUNGEON_PLATFORM.id);
            drawDiamond(world, x + (xOffset2 * 1), yAdjusted + 2, z + (zOffset2 * 1), 0, 0);
        } else {
            drawDiamond(world, x + (xOffset2 * 2), yAdjusted + 1, z + (zOffset2 * 2), 1, DUNGEON_PLATFORM.id);
            drawDiamond(world, x + (xOffset2 * 2), yAdjusted + 1, z + (zOffset2 * 2), 0, DUNGEON_PLATFORM.id);
            drawDiamond(world, x + (xOffset2 * 1), yAdjusted + 1, z + (zOffset2 * 1), 0, 0);
        }

        drawDiamond(world, x, yAdjusted + 2, z, 1, DUNGEON_PLATFORM.id);
        drawDiamond(world, x - xOffset2, yAdjusted + 2, z - zOffset2, 1, DUNGEON_PLATFORM.id);
        drawDiamond(world, x, yAdjusted + 2, z, 0, 0);
        drawDiamond(world, x, yAdjusted + 3, z, 0, DUNGEON_PLATFORM.id);


        String entityId = this.getRandomEntity(random);
        if (entityId.endsWith("WaterCreeper")) {
            if (0 == world.random.nextInt(2)) {
                world.setBlock(x + zOffset2 + xOffset2, yAdjusted - 1, z + xOffset2 + zOffset2, Block.SPAWNER.id);
                MobSpawnerBlockEntity spawnerBlockEntity1 = (MobSpawnerBlockEntity)world.getBlockEntity(x + zOffset2 + xOffset2, yAdjusted - 1, z + xOffset2 + zOffset2);
                spawnerBlockEntity1.setSpawnedEntityId("WaterCreeper");
                world.setBlock(x - zOffset2 + xOffset2, yAdjusted - 1, z - xOffset2 + zOffset2, Block.SPAWNER.id);
                MobSpawnerBlockEntity spawnerBlockEntity2 = (MobSpawnerBlockEntity)world.getBlockEntity(x - zOffset2 + xOffset2, yAdjusted - 1, z - xOffset2 + zOffset2);
                spawnerBlockEntity2.setSpawnedEntityId("IceCreeper");
            } else {
                world.setBlock(x + zOffset2 + xOffset2, yAdjusted - 1, z + xOffset2 + zOffset2, Block.SPAWNER.id);
                MobSpawnerBlockEntity spawnerBlockEntity1 = (MobSpawnerBlockEntity)world.getBlockEntity(x + zOffset2 + xOffset2, yAdjusted - 1, z + xOffset2 + zOffset2);
                spawnerBlockEntity1.setSpawnedEntityId("IceCreeper");
                world.setBlock(x - zOffset2 + xOffset2, yAdjusted - 1, z - xOffset2 + zOffset2, Block.SPAWNER.id);
                MobSpawnerBlockEntity spawnerBlockEntity2 = (MobSpawnerBlockEntity)world.getBlockEntity(x - zOffset2 + xOffset2, yAdjusted - 1, z - xOffset2 + zOffset2);
                spawnerBlockEntity2.setSpawnedEntityId("WaterCreeper");
            }
        } else {
            world.setBlock(x + xOffset2, yAdjusted, z + zOffset2, Block.SPAWNER.id);
            MobSpawnerBlockEntity spawnerBlockEntity = (MobSpawnerBlockEntity)world.getBlockEntity(x + xOffset2, yAdjusted, z + zOffset2);
            spawnerBlockEntity.setSpawnedEntityId(entityId);
        }

        return true;
    }

    private void drawOctahedron(World world, int x, int y, int z, int size, int blockId) {
        if (0 == size) {
            world.setBlock(x, y, z, blockId);
        } else {
            for (int drawIndex = 0; drawIndex < size; drawIndex++) {
                if (0 == drawIndex) {
                    drawDiamond(world, x, y, z, size, blockId);
                    world.setBlock(x, y + size, z, blockId);
                    world.setBlock(x, y - size, z, blockId);
                } else {
                    drawDiamond(world, x, y + drawIndex, z, size - drawIndex, blockId);
                    drawDiamond(world, x, y - drawIndex, z, size - drawIndex, blockId);
                }
            }
        }
    }

    private void drawDiamond(World world, int x, int y, int z, int size, int blockId) {
        if (0 == size) {
            world.setBlock(x, y, z, blockId);
        } else {
            for (int drawIndex = 0; drawIndex < size; drawIndex++) {
                world.setBlock((x + drawIndex) - size + 1, y, (z + drawIndex) + 1, blockId);
                //     n
                //   n   _
                // _       _
                //   _   _
                //     _

                world.setBlock((x + drawIndex), y, (z + drawIndex) - size, blockId);
                //     _
                //   _   _
                // _       _
                //   _   n
                //     n

                world.setBlock((x + drawIndex) - size, y, (z - drawIndex), blockId);
                //     _
                //   _   _
                // n       _
                //   n   _
                //     _

                world.setBlock((x + drawIndex) + 1, y, (z - drawIndex) + size - 1, blockId);
                //     _
                //   _   n
                // _       n
                //   _   _
                //     _
            }
        }
    }

    private ItemStack getRandomChestItem(Random random, World world, int x, int z) {
        int lootIndex = random.nextInt(OldAndOrnate.skylandsDungeonLootTable.size());
        SkyDungeonLoot skyDungeonLoot = OldAndOrnate.skylandsDungeonLootTable.get(lootIndex);
        ItemStack itemStackToSpawn = skyDungeonLoot.itemStack.copy();
        //itemStackToSpawn.writeNbt(skyDungeonLoot.itemStack.readNbt());

        if (-1 != skyDungeonLoot.randBound) {
            if (random.nextInt(skyDungeonLoot.randBound) != 0) {
                itemStackToSpawn = null;
            }
        }

        if (null != itemStackToSpawn) {
            if (1 < skyDungeonLoot.randCount) {
                itemStackToSpawn.count = random.nextInt(skyDungeonLoot.randCount) + 1;
            } else if (1 == skyDungeonLoot.randCount) {
                itemStackToSpawn.count = 1;
            }

            if (itemStackToSpawn.itemId == Item.MAP.id) {
                if (!hasDungeonMap) {
                    hasDungeonMap = true;
                    ItemStack mapItemStack = new ItemStack(Item.MAP);
                    mapItemStack.setDamage(world.getIdCount("map"));
                    String mapId = "map_" + mapItemStack.getDamage();
                    MapState mapState = new MapState(mapId);
                    world.setState(mapId, mapState);
                    mapState.centerX = x;
                    mapState.centerZ = z;
                    mapState.scale = 3;
                    mapState.dimension = (byte)world.dimension.id;
                    mapState.markDirty();
                    itemStackToSpawn = mapItemStack;
                } else {
                    itemStackToSpawn = new ItemStack(Item.STRING, random.nextInt(4) + 1);
                }
            } else if (itemStackToSpawn.itemId == Item.RECORD_THIRTEEN.id) {
                if (FabricLoader.getInstance().isModLoaded("musicdiscs")) {
                    itemStackToSpawn = ModHelperMusicDiscs.getRandomDisc(random);
                } else {
                    itemStackToSpawn = new ItemStack(Item.ITEMS[Item.RECORD_THIRTEEN.id + random.nextInt(2)]);
                }
            }
        }

        return itemStackToSpawn;
    }

    private String getRandomEntity(Random random) {
        if (FabricLoader.getInstance().isModLoaded("elementalcreepers")) {
            return ModHelperElementalCreepers.getRandomEntity(random);
        } else {
            return "Creeper";
        }
    }
}
