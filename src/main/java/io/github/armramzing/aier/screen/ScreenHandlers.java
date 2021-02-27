package io.github.armramzing.aier.screen;

import io.github.armramzing.aier.Aier;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

/**
 * @author squid233
 * @since 2021/01/17
 */
public final class ScreenHandlers {

    public static final ScreenHandlerType<IceFurnaceScreenHandler> ICE_FURNACE_SCREEN_HANDLER =
            register("ice_furnace", IceFurnaceScreenHandler::new);
    public static final ScreenHandlerType<HandCrankedGrinderScreenHandler> HAND_CRANKED_GRINDER_SCREEN_HANDLER =
            register("hand_cranked_grinder", HandCrankedGrinderScreenHandler::new);
    public static final ScreenHandlerType<CompressorScreenHandler> COMPRESSOR_HANDLER =
            register("compressor", CompressorScreenHandler::new);
    public static final ScreenHandlerType<ShapingMachineScreenHandler> SHAPING_MACHINE_HANDLER =
            register("shaping_machine", ShapingMachineScreenHandler::new);
    public static final ScreenHandlerType<FusionMachineScreenHandler> FUSION_MACHINE_HANDLER =
            register("fusion_machine", FusionMachineScreenHandler::new);

    private static <T extends ScreenHandler> ScreenHandlerType<T>
    register(String id,
             ScreenHandlerRegistry.SimpleClientHandlerFactory<T> factory) {
        return ScreenHandlerRegistry.registerSimple(new Identifier(Aier.MODID, id), factory);
    }
}
