package com.raidentokado.rotp_bat.init;

import com.raidentokado.rotp_bat.RotpBATAddon;

import com.raidentokado.rotp_bat.entity.damaging.projectile.BMBatarangEntity;
import com.raidentokado.rotp_bat.entity.damaging.projectile.BMGrapplingVineEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(
            ForgeRegistries.ENTITIES, RotpBATAddon.MOD_ID);
    public static final RegistryObject<EntityType<com.raidentokado.rotp_bat.entity.damaging.projectile.BMVineEntity>> BM_VINE = ENTITIES.register("bm_vine",
            () -> EntityType.Builder.<com.raidentokado.rotp_bat.entity.damaging.projectile.BMVineEntity>of(com.raidentokado.rotp_bat.entity.damaging.projectile.BMVineEntity::new, EntityClassification.MISC).sized(0.25F, 0.25F).noSummon().noSave().setUpdateInterval(20)
                    .build(new ResourceLocation(RotpBATAddon.MOD_ID, "bm_vine").toString()));

    public static final RegistryObject<EntityType<BMGrapplingVineEntity>> BM_GRAPPLING_VINE = ENTITIES.register("bm_grappling_vine",
            () -> EntityType.Builder.<BMGrapplingVineEntity>of(BMGrapplingVineEntity::new, EntityClassification.MISC).sized(0.25F, 0.25F).noSummon().noSave().setUpdateInterval(20)
                    .build(new ResourceLocation(RotpBATAddon.MOD_ID, "bm_grappling_vine").toString()));
    public static final RegistryObject<EntityType<BMBatarangEntity>> BM_BATARANG = ENTITIES.register("bm_batarang",
            () -> EntityType.Builder.<BMBatarangEntity>of(BMBatarangEntity::new, EntityClassification.MISC).sized(0.5F, 0.25F).noSummon().noSave().setUpdateInterval(10)
                    .build(new ResourceLocation(RotpBATAddon.MOD_ID, "hg_emerald").toString()));
};
