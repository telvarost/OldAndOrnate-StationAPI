package com.github.telvarost.oldandornate.block;

import com.github.telvarost.oldandornate.OldAndOrnate;
import com.github.telvarost.oldandornate.blockentity.PlatformBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.template.block.TemplateBlockWithEntity;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

import static com.github.telvarost.oldandornate.events.init.BlockListener.DUNGEON_PLATFORM;

public class FalteringPlatform extends TemplateBlockWithEntity {
    public FalteringPlatform(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    protected BlockEntity createBlockEntity() {
        return new PlatformBlockEntity();
    }

    @Override
    public int getTexture(int side) {
        if (side == 1) {
            return OldAndOrnate.FALTERING_PLATFORM_TEXTURE_TOP;
        } else {
            return side == 0 ? OldAndOrnate.FALTERING_PLATFORM_TEXTURE_BOTTOM : OldAndOrnate.FALTERING_PLATFORM_TEXTURE_SIDE;
        }
    }

    @Override
    public int getDroppedItemId(int blockMeta, Random random) {
        return DUNGEON_PLATFORM.id;
    }
}
