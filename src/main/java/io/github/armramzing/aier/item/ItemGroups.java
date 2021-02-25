package io.github.armramzing.aier.item;

import io.github.armramzing.aier.Aier;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

/**
 * @author ARMrAmzing
 */
public final class ItemGroups {
    public static final ItemGroup AIER = FabricItemGroupBuilder.build(
            new Identifier(Aier.MODID, "aier"),
            () -> new ItemStack(Items.ICE_CORE));
}
