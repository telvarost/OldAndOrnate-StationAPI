package com.github.telvarost.oldandornate.mixin;

import com.github.telvarost.oldandornate.Config;
import com.github.telvarost.zastavkaapi.ZastavkaHelper;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.vehicle.MinecartEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecartEntity.class)
public abstract class MinecartEntityMixin extends Entity {
    public MinecartEntityMixin(World world) {
        super(world);
    }

    @WrapOperation(
            method = "interact",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/PlayerInventory;getSelectedItem()Lnet/minecraft/item/ItemStack;"
            )
    )
    public ItemStack interact(PlayerInventory instance, Operation<ItemStack> original) {
        ItemStack itemStack = original.call(instance);

        if (Config.config.OTHER_CONFIG.enableFurnaceMinecartMusic) {
            if (itemStack != null && itemStack.itemId == Item.COAL.id && itemStack.getDamage() == 1) {
                this.world.playStreaming(
                        "oldandornate:zeldrys",
                        (int)Math.round(this.x),
                        (int)Math.round(this.y),
                        (int)Math.round(this.z)
                );
            }
        }

        return itemStack;
    }

    @Inject(
            method = "damage",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/vehicle/MinecartEntity;dropItem(IIF)Lnet/minecraft/entity/ItemEntity;",
                    ordinal = 2
            )
    )
    public void damage(Entity damageSource, int amount, CallbackInfoReturnable<Boolean> cir) {
        if (ZastavkaHelper.currentStreamingSong.startsWith("oldandornate:zeldrys")) {
            this.world.playStreaming(
                    null,
                    (int)Math.round(this.x),
                    (int)Math.round(this.y),
                    (int)Math.round(this.z)
            );
        }
    }
}
