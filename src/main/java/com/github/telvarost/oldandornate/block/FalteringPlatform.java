package com.github.telvarost.oldandornate.block;

import com.github.telvarost.oldandornate.OldAndOrnate;
import net.minecraft.block.SandBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.NoteBlockBlockEntity;
import net.minecraft.block.material.Material;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlockWithEntity;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

import static com.github.telvarost.oldandornate.events.init.BlockListener.DUNGEON_PLATFORM;
import static com.github.telvarost.oldandornate.events.init.BlockListener.GHOST_PLATFORM;

public class FalteringPlatform extends TemplateBlockWithEntity {
    public FalteringPlatform(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    protected BlockEntity createBlockEntity() {
        return new NoteBlockBlockEntity();
    }

    @Override
    public int getTexture(int side) {
        return OldAndOrnate.FALTERING_PLATFORM_TEXTURE;
    }

    @Override
    public void onPlaced(World world, int x, int y, int z) {
        world.scheduleBlockUpdate(x, y, z, this.id, this.getTickRate());
    }

    @Override
    public void neighborUpdate(World world, int x, int y, int z, int id) {
        world.scheduleBlockUpdate(x, y, z, this.id, this.getTickRate());
    }

    @Override
    public int getTickRate() {
        return 100;
    }

    @Override
    public void onTick(World world, int x, int y, int z, Random random) {
        this.processDelayedFall(world, x, y, z);
    }

    private void processDelayedFall(World world, int x, int y, int z) {
        if (SandBlock.canFallThrough(world, x, y - 1, z) && y >= 0) {
            byte var8 = 32;
            if (!SandBlock.fallInstantly && world.isRegionLoaded(x - var8, y - var8, z - var8, x + var8, y + var8, z + var8)) {
                FallingBlockEntity var9 = new FallingBlockEntity(world, (double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), this.id);
                world.spawnEntity(var9);
            } else {
                world.setBlock(x, y, z, GHOST_PLATFORM.id);

                while(SandBlock.canFallThrough(world, x, y - 1, z) && y > 0) {
                    --y;
                }

                if (y > 0) {
                    world.setBlock(x, y, z, this.id);
                }
            }
        }
    }

    @Override
    public int getDroppedItemId(int blockMeta, Random random) {
        return DUNGEON_PLATFORM.id;
    }
}
