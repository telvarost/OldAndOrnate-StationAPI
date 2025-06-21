package com.github.telvarost.oldandornate.block;

import com.github.telvarost.oldandornate.OldAndOrnate;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class AdobeBricks extends TemplateBlock {
    public AdobeBricks(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public int getTexture(int side) {
        return OldAndOrnate.ADOBE_BRICKS_TEXTURE;
    }
}
