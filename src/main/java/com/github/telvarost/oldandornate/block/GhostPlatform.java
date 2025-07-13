package com.github.telvarost.oldandornate.block;

import com.github.telvarost.oldandornate.OldAndOrnate;
import com.github.telvarost.oldandornate.blockentity.PlatformBlockEntity;
import com.github.telvarost.zastavkaapi.ZastavkaHelper;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.material.Material;
import net.minecraft.entity.mob.MonsterEntity;
import net.minecraft.util.math.Box;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlockWithEntity;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.ArrayList;
import java.util.Random;

import static com.github.telvarost.oldandornate.events.init.BlockListener.DUNGEON_PLATFORM;

public class GhostPlatform extends TemplateBlockWithEntity {
    public GhostPlatform(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    protected BlockEntity createBlockEntity() {
        return new PlatformBlockEntity();
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public boolean isSolidFace(BlockView blockView, int x, int y, int z, int i) {
        return false;
    }

    @Override
    public boolean hasCollision() {
        return false;
    }

    @Override
    public boolean isOpaque() {
        return false;
    }

    @Override
    public int getTexture(int side) {
        if (side == 1) {
            return OldAndOrnate.GHOST_PLATFORM_TEXTURE_TOP;
        } else {
            return side == 0 ? OldAndOrnate.GHOST_PLATFORM_TEXTURE_TOP : OldAndOrnate.GHOST_PLATFORM_TEXTURE_SIDE;
        }
    }

    @Override
    public int getDroppedItemId(int blockMeta, Random random) {
        return DUNGEON_PLATFORM.id;
    }

    @Override
    public void addIntersectingBoundingBox(World world, int x, int y, int z, Box box, ArrayList boxes) {
        Box collisionBox = this.getCollisionShape(world, x, y, z);

        if (collisionBox != null && box.intersects(collisionBox)) {
            if (ZastavkaHelper.collisionEntity instanceof MonsterEntity) {
                boxes.add(collisionBox);
            }
        }
    }
}
