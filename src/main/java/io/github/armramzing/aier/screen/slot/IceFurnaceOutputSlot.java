package io.github.armramzing.aier.screen.slot;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

/**
 * @author squid233
 * @since 2021/01/17
 */
public class IceFurnaceOutputSlot extends Slot {
    public IceFurnaceOutputSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return false;
    }
}
