package com.raidentokado.rotp_bat.init;

import com.raidentokado.rotp_bat.RotpBATAddon;
import com.raidentokado.rotp_bat.item.BatmanMaskItem;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RotpBATAddon.MOD_ID);


    public static final RegistryObject<BatmanMaskItem> BATMAN_MASK = ITEMS.register("batman_mask_item",
            ()->new BatmanMaskItem(new Item.Properties().stacksTo(1)));
}