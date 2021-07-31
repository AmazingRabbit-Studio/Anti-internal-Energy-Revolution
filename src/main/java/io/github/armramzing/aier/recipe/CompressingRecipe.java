package io.github.armramzing.aier.recipe;

import io.github.armramzing.aier.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;

public class CompressingRecipe extends AbstractCookingRecipe {
    public CompressingRecipe(Identifier id, String group, Ingredient input, ItemStack output, float experience, int compressTime) {
        super(CompressingRecipeRegistry.COMPRESSING, id, group, input, output, experience, compressTime);
    }

    @Override
    public ItemStack getRecipeKindIcon() {
        return new ItemStack(Items.COMPRESSOR);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return CompressingRecipeRegistry.COMPRESSING_SERIALIZER;
    }
}
