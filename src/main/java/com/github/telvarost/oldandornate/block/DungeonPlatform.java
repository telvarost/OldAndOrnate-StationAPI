package com.github.telvarost.oldandornate.block;

import com.github.telvarost.oldandornate.OldAndOrnate;
import com.github.telvarost.zastavkaapi.ZastavkaHelper;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.ArrayList;

import static com.github.telvarost.oldandornate.events.init.BlockListener.FALTERING_PLATFORM;

public class DungeonPlatform extends TemplateBlock {
    public DungeonPlatform(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public int getTexture(int side) {
        if (side == 1) {
            return OldAndOrnate.DUNGEON_PLATFORM_TEXTURE_TOP;
        } else {
            return side == 0 ? OldAndOrnate.DUNGEON_PLATFORM_TEXTURE_BOTTOM : OldAndOrnate.DUNGEON_PLATFORM_TEXTURE_SIDE;
        }
    }

    @Override
    public void addIntersectingBoundingBox(World world, int x, int y, int z, Box box, ArrayList boxes) {
        Box collisionBox = this.getCollisionShape(world, x, y, z);

        if (collisionBox != null && box.intersects(collisionBox)) {
            if (ZastavkaHelper.collisionEntity instanceof PlayerEntity) {
                world.setBlock(x, y, z, FALTERING_PLATFORM.id);
            }

            boxes.add(collisionBox);
        }
    }
}
