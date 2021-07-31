package io.github.armramzing.aier.recipe;

import io.github.armramzing.aier.Aier;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.registry.Registry;

public class IceCookingRecipeRegistry {
    public static final RecipeType<IceCookingRecipe> ICE_COOKING;
    public static final RecipeSerializer<IceCookingRecipe> ICE_COOKING_SERIALIZER;

    static {
        ICE_COOKING = Aier.register(Registry.RECIPE_TYPE,
                "ice_cooking",
                new RecipeType<IceCookingRecipe>() {
                    @Override
                    public String toString() {
                        return "ice_cooking";
                    }
                });
        ICE_COOKING_SERIALIZER = Aier.register(
                Registry.RECIPE_SERIALIZER,
                "ice_cooking",
                new CookingRecipeSerializer<>(
                        IceCookingRecipe::new,
                        200
                ));
    }
}
