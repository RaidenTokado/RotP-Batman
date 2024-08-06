package com.raidentokado.rotp_bat.client.render.entity.renderer.damaging.projectile;

import com.github.standobyte.jojo.client.render.entity.renderer.damaging.extending.ExtendingEntityRenderer;
import com.github.standobyte.jojo.entity.damaging.projectile.ownerbound.OwnerBoundProjectileEntity;
import com.raidentokado.rotp_bat.RotpBATAddon;
import com.raidentokado.rotp_bat.client.render.entity.model.projectile.BMVineModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public abstract class BMVineAbstractRenderer<T extends OwnerBoundProjectileEntity> extends ExtendingEntityRenderer<T, BMVineModel<T>> {

    public BMVineAbstractRenderer(EntityRendererManager renderManager, BMVineModel<T> model) {
        super(renderManager, model, new ResourceLocation(RotpBATAddon.MOD_ID, "textures/entity/projectile/bm_vine.png"));
    }
}