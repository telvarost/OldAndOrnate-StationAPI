package com.github.telvarost.oldandornate.blockentity;

import net.minecraft.block.SandBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.world.World;

import static com.github.telvarost.oldandornate.events.init.BlockListener.*;

public class PlatformBlockEntity extends BlockEntity {

    public int tickCount = 0;

    public PlatformBlockEntity() {
        /** - Do nothing */
    }

    @Override
    public void tick() {
        if (world != null) {
            tickCount++;

            if (20 < tickCount) {
                tickCount = 0;
                int blockMeta = world.getBlockMeta(x, y, z);

                if (5 <= blockMeta) {
                    world.setBlockMeta(x, y, z, 0);
                    int blockId = world.getBlockId(x, y, z);

                    if (FALTERING_PLATFORM.id == blockId) {
                        this.processDelayedFall(world, x, y, z, blockId);
                    } else {
                        world.setBlock(x, y, z, DUNGEON_PLATFORM.id);
                    }
                } else {
                    world.setBlockMeta(x, y, z, blockMeta + 1);
                }
            }
        }

        super.tick();
    }

    private void processDelayedFall(World world, int x, int y, int z, int blockId) {
        if (SandBlock.canFallThrough(world, x, y - 1, z) && y >= 0) {
            byte var8 = 32;
            if (!SandBlock.fallInstantly && world.isRegionLoaded(x - var8, y - var8, z - var8, x + var8, y + var8, z + var8)) {
                FallingBlockEntity var9 = new FallingBlockEntity(world, (double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), blockId);
                world.spawnEntity(var9);
            } else {
                world.setBlock(x, y, z, GHOST_PLATFORM.id);

                while(SandBlock.canFallThrough(world, x, y - 1, z) && y > 0) {
                    --y;
                }

                if (y > 0) {
                    world.setBlock(x, y, z, blockId);
                }
            }
        }
    }
}
