package io.github.armramzing.aier.recipe;

import io.github.armramzing.aier.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;

public class IceCookingRecipe extends AbstractCookingRecipe {
    public IceCookingRecipe(Identifier id, String group, Ingredient input, ItemStack output, float experience, int cookTime) {
        super(IceCookingRecipeRegistry.ICE_COOKING, id, group, input, output, experience, cookTime);
    }

    @Override
    public ItemStack getRecipeKindIcon() {
        return new ItemStack(Items.ICE_FURNACE);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return IceCookingRecipeRegistry.ICE_COOKING_SERIALIZER;
    }
}
