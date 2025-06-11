package com.github.telvarost.oldandornate.block;

import net.modificationstation.stationapi.api.template.block.TemplatePlantBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class StarFlower extends TemplatePlantBlock {
    public StarFlower(Identifier identifier, int texture) {
        super(identifier, texture);
        float var3 = 0.4F;
        this.setBoundingBox(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.8F, 0.5F + var3);
    }
}
