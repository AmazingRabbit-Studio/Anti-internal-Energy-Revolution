package io.github.armramzing.aier.item.tools;

import io.github.armramzing.aier.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class BlueFireToolMaterial implements ToolMaterial {
    @Override
    public int getDurability() {
        return 1024;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 5;
    }

    @Override
    public float getAttackDamage() {
        return 0;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 7;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.NETHER_IRON_ALLOY_INGOT);
    }

    public static final BlueFireToolMaterial INSTANCE = new BlueFireToolMaterial();
}
