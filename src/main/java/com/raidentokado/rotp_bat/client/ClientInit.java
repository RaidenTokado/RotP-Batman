package com.raidentokado.rotp_bat.client;

import com.github.standobyte.jojo.client.ClientUtil;
import com.raidentokado.rotp_bat.RotpBATAddon;
import com.raidentokado.rotp_bat.client.render.entity.renderer.stand.BatmanRenderer;
import com.raidentokado.rotp_bat.init.AddonStands;

import com.raidentokado.rotp_bat.init.InitEntities;
import com.raidentokado.rotp_bat.init.InitItems;
import net.minecraft.client.Minecraft;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = RotpBATAddon.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientInit {

    private static final IItemPropertyGetter STAND_ITEM_INVISIBLE = (itemStack, clientWorld, livingEntity) -> {
        return !ClientUtil.canSeeStands() ? 1 : 0;
    };

    @SubscribeEvent
    public static void onFMLClientSetup(FMLClientSetupEvent event) {
        Minecraft mc = event.getMinecraftSupplier().get();;

        RenderingRegistry.registerEntityRenderingHandler(AddonStands.BATMAN_STAND.getEntityType(), BatmanRenderer::new);

        event.enqueueWork(() -> {
            ItemModelsProperties.register(InitItems.BATMAN_MASK.get(),
                    new ResourceLocation(RotpBATAddon.MOD_ID, "stand_invisible"),
                    STAND_ITEM_INVISIBLE);
        });


    }

}