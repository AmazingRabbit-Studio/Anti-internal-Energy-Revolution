package io.github.armramzing.aier.screen.slot;

import io.github.armramzing.aier.block.CompressorEntity;
import io.github.armramzing.aier.block.ShapingMachineEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.slot.Slot;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ShapingMachineFuelSlot extends Slot {
    public ShapingMachineFuelSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public void markDirty() {
        if (inventory instanceof ShapingMachineEntity) {
            ShapingMachineEntity entity = (ShapingMachineEntity) inventory;
            World world = entity.getWorld();
            if (world != null) {
                BlockPos pos = entity.getPos();
                world.setBlockState(pos, world.getBlockState(pos).with(Properties.LIT, hasStack()));
            }
        }
        super.markDirty();
    }
}
