package com.github.telvarost.oldandornate.item;

import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.client.item.CustomTooltipProvider;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class AdobeBrick extends TemplateItem implements CustomTooltipProvider {
    public AdobeBrick(Identifier i) {
        super(i);
    }

    @Override
    public String[] getTooltip(ItemStack itemInstance, String originalTooltip) {
        return new String[]{originalTooltip};
    }
}
