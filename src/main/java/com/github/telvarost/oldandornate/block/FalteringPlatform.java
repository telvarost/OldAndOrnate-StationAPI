package com.github.telvarost.oldandornate.block;

import com.github.telvarost.oldandornate.OldAndOrnate;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateSandBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

import static com.github.telvarost.oldandornate.events.init.BlockListener.GHOST_PLATFORM;

public class FalteringPlatform extends TemplateSandBlock {

    public FalteringPlatform(Identifier identifier, int textureId) {
        super(identifier, textureId);
        setTickRandomly(true);
    }

    @Override
    public int getTexture(int side) {
        return OldAndOrnate.FALTERING_PLATFORM_TEXTURE;
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
        if (canFallThrough(world, x, y - 1, z) && y >= 0) {
            byte var8 = 32;
            if (!fallInstantly && world.isRegionLoaded(x - var8, y - var8, z - var8, x + var8, y + var8, z + var8)) {
                FallingBlockEntity var9 = new FallingBlockEntity(world, (double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), this.id);
                world.spawnEntity(var9);
            } else {
                world.setBlock(x, y, z, GHOST_PLATFORM.id);

                while(canFallThrough(world, x, y - 1, z) && y > 0) {
                    --y;
                }

                if (y > 0) {
                    world.setBlock(x, y, z, this.id);
                }
            }
        }
    }
}
