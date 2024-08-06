package com.raidentokado.rotp_bat.init;

import com.raidentokado.rotp_bat.RotpBATAddon;
import com.raidentokado.rotp_bat.item.BatmanMaskItem;
import com.raidentokado.rotp_bat.item.ModArmorMaterials;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RotpBATAddon.MOD_ID);

    public static final RegistryObject<Item> BATMAN_SYMBOL = ITEMS.register("batman_symbol",
            ()->new Item(new Item.Properties().tab(ModItemGroup.BATMAN_GROUP)));
    public static final RegistryObject<Item> BATMAN_MASK = ITEMS.register("batman_mask",
            ()->new ArmorItem(ModArmorMaterials.BATMANV7, EquipmentSlotType.HEAD,
                    new Item.Properties().tab(ModItemGroup.BATMAN_GROUP)));
    public static final RegistryObject<Item> BATMAN_CHESTPLATE = ITEMS.register("batman_chestplate",
            ()->new ArmorItem(ModArmorMaterials.BATMANV7, EquipmentSlotType.CHEST,
                    new Item.Properties().tab(ModItemGroup.BATMAN_GROUP)));
    public static final RegistryObject<Item> BATMAN_LEGGINS = ITEMS.register("batman_leggins",
            ()->new ArmorItem(ModArmorMaterials.BATMANV7, EquipmentSlotType.LEGS,
                    new Item.Properties().tab(ModItemGroup.BATMAN_GROUP)));
    public static final RegistryObject<Item> BATMAN_BOOTS = ITEMS.register("batman_boots",
            ()->new ArmorItem(ModArmorMaterials.BATMANV7, EquipmentSlotType.FEET,
                    new Item.Properties().tab(ModItemGroup.BATMAN_GROUP)));
}