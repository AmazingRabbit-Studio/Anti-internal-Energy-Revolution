package io.github.armramzing.aier.screen;

import io.github.armramzing.aier.screen.slot.HandCrankedGrinderOutputSlot;
import io.github.armramzing.aier.screen.slot.IceFurnaceFuelSlot;
import io.github.armramzing.aier.screen.slot.IceFurnaceOutputSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class HandCrankedGrinderScreenHandler extends ScreenHandler {
    private final Inventory inventory;

    public HandCrankedGrinderScreenHandler(int syncId, PlayerInventory pInv) {
        this(syncId, pInv, new SimpleInventory(3));
    }

    public HandCrankedGrinderScreenHandler(int syncId, PlayerInventory pInv, Inventory inv) {
        super(ScreenHandlers.HAND_CRANKED_GRINDER_SCREEN_HANDLER, syncId);
        checkSize(inv, 3);
        inventory = inv;
        inv.onOpen(pInv.player);
        // Input
        addSlot(new Slot(inv, 0, 79, 17));
        // Output
        addSlot(new HandCrankedGrinderOutputSlot(inv, 1, 79, 53));
        int m;
        int l;
        //The player inventory
        for (m = 0; m < 3; ++m) {
            for (l = 0; l < 9; ++l) {
                addSlot(new Slot(pInv, l + m * 9 + 9, 8 + l * 18, 84 + m * 18));
            }
        }
        //The player Hotbar
        for (m = 0; m < 9; ++m) {
            addSlot(new Slot(pInv, m, 8 + m * 18, 142));
        }
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return inventory.canPlayerUse(player);
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int index) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = slots.get(index);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (index < inventory.size()) {
                if (!insertItem(originalStack, inventory.size(), slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!insertItem(originalStack, 0, inventory.size(), false)) {
                return ItemStack.EMPTY;
            }
            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }
        return newStack;
    }
}
