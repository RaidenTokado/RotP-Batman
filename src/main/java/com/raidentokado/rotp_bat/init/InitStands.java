package com.raidentokado.rotp_bat.init;

import com.github.standobyte.jojo.action.Action;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.action.stand.StandEntityLightAttack;
import com.github.standobyte.jojo.entity.stand.StandEntityType;
import com.github.standobyte.jojo.init.power.stand.EntityStandRegistryObject;
import com.github.standobyte.jojo.power.impl.stand.stats.StandStats;
import com.github.standobyte.jojo.power.impl.stand.type.EntityStandType;
import com.github.standobyte.jojo.power.impl.stand.type.StandType;
import com.raidentokado.rotp_bat.RotpBATAddon;
import com.raidentokado.rotp_bat.action.BMBatarang;
import com.raidentokado.rotp_bat.action.BMGrapple;
import com.raidentokado.rotp_bat.entity.stand.stands.BatmanEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class InitStands {
    @Deprecated public static final ITextComponent PART_DC_NAME = new TranslationTextComponent("multiverse.story_part.dc").withStyle(TextFormatting.DARK_BLUE);
    @SuppressWarnings("unchecked")
    public static final DeferredRegister<Action<?>> ACTIONS = DeferredRegister.create(
            (Class<Action<?>>) ((Class<?>) Action.class), RotpBATAddon.MOD_ID);
    @SuppressWarnings("unchecked")
    public static final DeferredRegister<StandType<?>> STANDS = DeferredRegister.create(
            (Class<StandType<?>>) ((Class<?>) StandType.class), RotpBATAddon.MOD_ID);
    
 // ======================================== Batman ========================================

    public static final RegistryObject<StandEntityAction> BATMAN_PUNCH = ACTIONS.register("batman_punch",
            () -> new StandEntityLightAttack(new StandEntityLightAttack.Builder()
                    .punchSound(InitSounds.BATMAN_PUNCH).swingHand().standOffsetFromUser(0,0,.5)
                    .standSound(StandEntityAction.Phase.WINDUP, InitSounds.BATMAN_PUNCH)));

    public static final RegistryObject<StandEntityAction> BATMAN_BATARANG = ACTIONS.register("batman_batarang",
            () -> new BMBatarang(new StandEntityAction.Builder()
                    .staminaCostTick(1).autoSummonStand().standUserWalkSpeed(1.0F)
                    .standSound(StandEntityAction.Phase.WINDUP, InitSounds.BATMAN_BATARANG)));

    public static final RegistryObject<StandEntityAction> BATMAN_GRAPPLE = ACTIONS.register("batman_grapple",
            () -> new BMGrapple(new StandEntityAction.Builder().holdType()
                    .staminaCostTick(1).autoSummonStand().standUserWalkSpeed(1.0F)
                    .standSound(StandEntityAction.Phase.WINDUP, InitSounds.BATMAN_GRAPPLE)));
    public static final RegistryObject<StandEntityAction> BATMAN_GRAPPLE_ENTITY = ACTIONS.register("batman_grapple_entity",
            () -> new BMGrapple(new StandEntityAction.Builder().holdType()
                    .staminaCostTick(1).autoSummonStand().standUserWalkSpeed(1.0F)
                    .standSound(StandEntityAction.Phase.WINDUP, InitSounds.BATMAN_GRAPPLE)
                    .shiftVariationOf(BATMAN_GRAPPLE)));
    
    

    public static final EntityStandRegistryObject<EntityStandType<StandStats>, StandEntityType<BatmanEntity>> STAND_BATMAN =
            new EntityStandRegistryObject<>("batman",
                    STANDS, 
                    () -> new EntityStandType.Builder<StandStats>()
                    .color(0x1a1a1a)
                    .storyPartName(PART_DC_NAME)
                    .leftClickHotbar(
                            BATMAN_PUNCH.get(),
                            BATMAN_BATARANG.get()
                            )
                    .rightClickHotbar(
                            BATMAN_GRAPPLE.get()
                            )
                    .defaultStats(StandStats.class, new StandStats.Builder()
                            .tier(6)
                            .power(15)
                            .speed(15)
                            .range(10)
                            .durability(20)
                            .precision(5)
                            .build())
                    .addOst(InitSounds.BATMAN_OST)
                    .disableManualControl().disableStandLeap()
                    .build(),
                    
                    InitEntities.ENTITIES,
                    () -> new StandEntityType<BatmanEntity>(BatmanEntity::new, 0.7F, 2.1F)
                    .summonSound(InitSounds.BATMAN_SUMMON)
                    .unsummonSound(InitSounds.BATMAN_UNSUMMON))
            .withDefaultStandAttributes();
}
