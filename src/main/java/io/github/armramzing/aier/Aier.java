package io.github.armramzing.aier;

import io.github.armramzing.aier.block.Blocks;
import io.github.armramzing.aier.item.Items;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public final class Aier implements ModInitializer {
    public static final String MODID = "aier";
    public static final Logger logger = LogManager.getLogger("Aier");

    @Override
    public void onInitialize() {
        logger.info("[AIER]Anti-internal Energy Revolution is starting!");
        logger.info("[AIER]Thanks for your playing");
        logger.info("[AIER]From ARMrAmzing, the creator of AmazingRabbit Studio");
        try {
            Class.forName(Blocks.class.getName());
            Class.forName(Items.class.getName());
        } catch (ClassNotFoundException e) {
            logger.catching(e);
        }
    }
}
