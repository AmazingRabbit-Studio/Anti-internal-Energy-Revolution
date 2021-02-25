package io.github.armramzing.aier.client;

import io.github.armramzing.aier.screen.HandCrankedGrinderScreen;
import io.github.armramzing.aier.screen.IceFurnaceScreen;
import io.github.armramzing.aier.screen.ScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

/**
 * @author squid233
 * @since 2021/01/17
 */
public final class AierClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(ScreenHandlers.ICE_FURNACE_SCREEN_HANDLER, IceFurnaceScreen::new);
        ScreenRegistry.register(ScreenHandlers.HAND_CRANKED_GRINDER_SCREEN_HANDLER, HandCrankedGrinderScreen::new);
    }
}
