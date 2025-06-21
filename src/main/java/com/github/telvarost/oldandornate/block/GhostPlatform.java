package com.github.telvarost.oldandornate.block;

import com.github.telvarost.oldandornate.OldAndOrnate;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.NoteBlockBlockEntity;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.Box;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlockWithEntity;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

import static com.github.telvarost.oldandornate.events.init.BlockListener.DUNGEON_PLATFORM;

public class GhostPlatform extends TemplateBlockWithEntity {
    public GhostPlatform(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    protected BlockEntity createBlockEntity() {
        return new NoteBlockBlockEntity();
    }

    @Environment(EnvType.CLIENT)
    @Override
    public Box getBoundingBox(World world, int x, int y, int z) {
        return Box.createCached(0, 0, 0, 0, 0, 0);
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
    public Box getCollisionShape(World world, int x, int y, int z) {
        return Box.createCached(0, 0, 0, 0, 0, 0);
    }

    @Override
    public boolean isOpaque() {
        return false;
    }

    @Override
    public int getTexture(int side) {
        return OldAndOrnate.GHOST_PLATFORM_TEXTURE;
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
        world.setBlock(x, y, z, DUNGEON_PLATFORM.id);
    }

    @Override
    public int getDroppedItemId(int blockMeta, Random random) {
        return DUNGEON_PLATFORM.id;
    }
}
