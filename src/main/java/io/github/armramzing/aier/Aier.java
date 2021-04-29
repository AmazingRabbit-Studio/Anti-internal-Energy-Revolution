package io.github.armramzing.aier;

import io.github.armramzing.aier.block.Blocks;
import io.github.armramzing.aier.item.Items;
import io.github.armramzing.aier.recipe.IceCookingRecipeRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public final class Aier implements ModInitializer {
    public static final String MODID = "aier";
    public static final Logger logger = LogManager.getLogger("AIER");

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
        logger.info("[AIER]Thanks for your playing");
        logger.info("[AIER]From ARMrAmzing, the creator of AmazingRabbit Studio");
        load(Blocks.class);
        load(Items.class);
        load(IceCookingRecipeRegistry.class);
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.BLACK_ICE, RenderLayer.getTranslucent());
    }
}
