package io.github.armramzing.aier.item.tools;

import io.github.armramzing.aier.item.tools.CustomPickaxeItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

import java.util.List;

public class HeavyHammer extends CustomPickaxeItem {
    public HeavyHammer(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.heavy_hammer.fabric_item.tooltip"));
        tooltip.add(new TranslatableText("item.heavy_hammer.fabric_item.tooltip1"));
        tooltip.add(new TranslatableText("item.heavy_hammer.fabric_item.tooltip2"));
    }
}
