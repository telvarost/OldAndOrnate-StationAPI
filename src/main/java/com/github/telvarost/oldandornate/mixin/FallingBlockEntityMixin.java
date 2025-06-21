package com.github.telvarost.oldandornate.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

import static com.github.telvarost.oldandornate.events.init.BlockListener.GHOST_PLATFORM;
import static com.github.telvarost.oldandornate.events.init.BlockListener.FALTERING_PLATFORM;

@Mixin(FallingBlockEntity.class)
public abstract class FallingBlockEntityMixin extends Entity {

    @Shadow public int blockId;

    public FallingBlockEntityMixin(World world) {
        super(world);
    }

    @WrapOperation(
            method = "tick",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/World;setBlock(IIII)Z",
                    ordinal = 0
            )
    )
    public boolean oldAndOrnate_replaceSetBlock(World instance, int x, int y, int z, int blockId, Operation<Boolean> original) {
        if (FALTERING_PLATFORM.id == instance.getBlockId(x, y, z)) {
            return original.call(instance, x, y, z, GHOST_PLATFORM.id);
        } else {
            return original.call(instance, x, y, z, blockId);
        }
    }

    @WrapOperation(
            method = "tick",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/World;setBlock(IIII)Z",
                    ordinal = 1
            )
    )
    public boolean oldAndOrnate_cancelSetBlock(World instance, int x, int y, int z, int blockId, Operation<Boolean> original) {
        if (FALTERING_PLATFORM.id == blockId) {
            return false;
        } else {
            return original.call(instance, x, y, z, blockId);
        }
    }

    @WrapOperation(
            method = "tick",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/FallingBlockEntity;dropItem(II)Lnet/minecraft/entity/ItemEntity;"
            )
    )
    public ItemEntity oldAndOrnate_tickDropItem(FallingBlockEntity instance, int id, int amount, Operation<ItemEntity> original) {
        if (FALTERING_PLATFORM.id == id) {
            return null;
        } else {
            return original.call(instance, id, amount);
        }
    }
}
