package com.github.telvarost.oldandornate.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.ToolMaterial;
import net.modificationstation.stationapi.api.template.item.TemplateSwordItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class LapisLazuliSword extends TemplateSwordItem {

    public LapisLazuliSword(Identifier identifier, ToolMaterial arg) {
        super(identifier, arg);
        this.setMaxDamage(64);
    }

    @Override
    public int getAttackDamage(Entity attackedEntity) {
        if (attackedEntity instanceof LivingEntity && !(attackedEntity instanceof SheepEntity && !((SheepEntity)attackedEntity).isSheared())) {
            ((LivingEntity)attackedEntity).oldAndOrnate_setFrozenTicks(20);
        }

        return 2;
    }
}
