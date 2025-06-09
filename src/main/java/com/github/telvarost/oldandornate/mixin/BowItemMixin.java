package com.github.telvarost.oldandornate.mixin;

import com.github.telvarost.oldandornate.Config;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BowItem.class)
public class BowItemMixin extends Item {
    public BowItemMixin(int i) {
        super(i);
    }

    @Inject(
            method = "<init>",
            at = @At("RETURN")
    )
    public void oldAndOrnate_init(CallbackInfo ci) {
        if (Config.config.bowsHaveDurability) {
            this.setMaxDamage(384);
        }
    }

    @Inject(
            method = "use",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/World;playSound(Lnet/minecraft/entity/Entity;Ljava/lang/String;FF)V"
            )
    )
    public void oldAndOrnate_use(ItemStack stack, World world, PlayerEntity user, CallbackInfoReturnable<ItemStack> cir) {
        if (Config.config.bowsHaveDurability) {
            stack.damage(1, user);
        }
    }
}
