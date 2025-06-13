package com.github.telvarost.oldandornate.mixin;

import com.github.telvarost.oldandornate.Config;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.vehicle.MinecartEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(MinecartEntity.class)
public class MinecartEntityMixin {

    @WrapOperation(
            method = "interact",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/PlayerInventory;getSelectedItem()Lnet/minecraft/item/ItemStack;"
            )
    )
    public ItemStack interact(PlayerInventory instance, Operation<ItemStack> original) {
        ItemStack itemStack = original.call(instance);

        if (itemStack != null && itemStack.itemId == Item.COAL.id) {
            if (Config.config.enableFurnaceMinecartMusic) {
                instance.player.world.playStreaming(
                        "oldandornate:zeldrys",
                        (int)Math.round(instance.player.x),
                        (int)Math.round(instance.player.y),
                        (int)Math.round(instance.player.z)
                );
            }
        }

        return itemStack;
    }
}
