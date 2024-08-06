package com.raidentokado.rotp_bat.client.render.entity.renderer.damaging.projectile;

import com.raidentokado.rotp_bat.client.render.entity.model.projectile.BMVineModel;
import com.raidentokado.rotp_bat.client.render.entity.renderer.damaging.projectile.BMVineAbstractRenderer;
import com.raidentokado.rotp_bat.entity.damaging.projectile.BMVineEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;

public class BMVineRenderer extends BMVineAbstractRenderer<BMVineEntity> {

    public BMVineRenderer(EntityRendererManager renderManager) {
        super(renderManager, new BMVineModel<BMVineEntity>());
    }
}