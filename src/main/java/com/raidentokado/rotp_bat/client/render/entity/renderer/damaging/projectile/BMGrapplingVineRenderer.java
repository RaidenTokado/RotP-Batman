package com.raidentokado.rotp_bat.client.render.entity.renderer.damaging.projectile;

import com.raidentokado.rotp_bat.client.render.entity.model.projectile.BMVineModel;
import com.raidentokado.rotp_bat.entity.damaging.projectile.BMGrapplingVineEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;

public class BMGrapplingVineRenderer extends BMVineAbstractRenderer<BMGrapplingVineEntity> {

    public BMGrapplingVineRenderer(EntityRendererManager renderManager) {
        super(renderManager, new BMVineModel<BMGrapplingVineEntity>());
    }
}