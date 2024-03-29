package io.github.armramzing.aier;

import io.github.armramzing.aier.block.Blocks;
import io.github.armramzing.aier.item.Items;
import io.github.armramzing.aier.recipe.IceCookingRecipe;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public final class Aier implements ModInitializer {
    public static final String MODID = "aier";
    public static final Logger logger = LogManager.getLogger("AIER");
    public static final RecipeType<IceCookingRecipe> RECIPE_TYPE = RecipeType.register("aier:recipe_type");

    public static <V, T extends V> T register(Registry<V> registry, String path, T t) {
        return Registry.register(registry, new Identifier(MODID, path), t);
    }

    private static void load(Class<?> clazz) {
        try {
            Class.forName(clazz.getName());
        } catch (ClassNotFoundException e) {
            logger.catching(e);
        }
    }

    @Override
    public void onInitialize() {
        logger.info("[AIER]Anti-internal Energy Revolution is starting!");
        logger.info("[AIER]Thanks for playing");
        logger.info("[AIER]From ARMrAmzing, the creator of AmazingRabbit Studio");
        load(Blocks.class);
        load(Items.class);
        //transparent block
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.BLACK_ICE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.HCV_ICE, RenderLayer.getCutout());
    }
}
