package io.github.armramzing.aier.recipe;

import io.github.armramzing.aier.Aier;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.registry.Registry;

public class CompressingRecipeRegistry {
    public static final RecipeType<CompressingRecipe> COMPRESSING;
    public static final RecipeSerializer<CompressingRecipe> COMPRESSING_SERIALIZER;

    static {
        COMPRESSING = Aier.register(Registry.RECIPE_TYPE,
                "compressing",
                new RecipeType<CompressingRecipe>() {
                    @Override
                    public String toString() {
                        return "compressing";
                    }
                });
        COMPRESSING_SERIALIZER = Aier.register(
                Registry.RECIPE_SERIALIZER,
                "compressing",
                new CookingRecipeSerializer<>(
                        CompressingRecipe::new,
                        200
                ));
    }
}
