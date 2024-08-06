package com.raidentokado.rotp_bat.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {
    public static final ItemGroup BATMAN_GROUP = new ItemGroup("BatmanModTab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(InitItems.BATMAN_SYMBOL.get());
        }
    };
}
