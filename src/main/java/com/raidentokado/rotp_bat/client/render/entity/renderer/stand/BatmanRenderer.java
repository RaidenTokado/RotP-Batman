package com.raidentokado.rotp_bat.client.render.entity.renderer.stand;

import com.raidentokado.rotp_bat.RotpBATAddon;
import com.raidentokado.rotp_bat.client.render.entity.model.stand.BatmanModel;
import com.raidentokado.rotp_bat.entity.stand.stands.BatmanEntity;
import com.github.standobyte.jojo.client.render.entity.renderer.stand.StandEntityRenderer;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class BatmanRenderer  extends StandEntityRenderer<BatmanEntity, BatmanModel> {

    public BatmanRenderer(EntityRendererManager renderManager) {
        super(renderManager, new BatmanModel(), new ResourceLocation(RotpBATAddon.MOD_ID, "textures/entity/stand/void.png"), 0);
    }

}