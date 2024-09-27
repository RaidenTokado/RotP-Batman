package com.raidentokado.rotp_bat.init;

import com.raidentokado.rotp_bat.RotpBATAddon;
import com.github.standobyte.jojo.action.Action;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.action.stand.StandEntityLightAttack;
import com.github.standobyte.jojo.action.stand.TimeStop;
import com.github.standobyte.jojo.entity.stand.StandEntityType;
import com.github.standobyte.jojo.init.power.stand.EntityStandRegistryObject;
import com.github.standobyte.jojo.power.impl.stand.StandInstance;
import com.github.standobyte.jojo.power.impl.stand.stats.TimeStopperStandStats;
import com.github.standobyte.jojo.power.impl.stand.type.EntityStandType;
import com.github.standobyte.jojo.power.impl.stand.type.StandType;
import com.raidentokado.rotp_bat.action.BMBatarang;
import com.raidentokado.rotp_bat.action.BMGrapple;
import com.raidentokado.rotp_bat.entity.stand.stands.BatmanEntity;
import net.minecraft.util.ResourceLocation;
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
                    .staminaCostTick(2).autoSummonStand().standUserWalkSpeed(1.0F)
                    .standSound(StandEntityAction.Phase.WINDUP, InitSounds.BATMAN_GRAPPLE)
                    .shiftVariationOf(BATMAN_GRAPPLE)));
    public static final RegistryObject<TimeStop> BATMAN_FEAR_TAKEDOWN = ACTIONS.register("batman_fear_takedown",
            () -> new TimeStop(new TimeStop.Builder().holdToFire(10, false).staminaCost(225).staminaCostTick(7.5F).heldWalkSpeed(0.25f)
                    .resolveLevelToUnlock(2).isTrained()
                    .ignoresPerformerStun()
                    .shout(InitSounds.NOTHING)
                    .partsRequired(StandInstance.StandPart.MAIN_BODY)
                    .voiceLineWithStandSummoned(InitSounds.NOTHING).timeStopSound(InitSounds.BATMAN_TAKEDOWN_START)
                    .addTimeResumeVoiceLine(InitSounds.NOTHING, true)
                    .timeResumeSound(InitSounds.NOTHING)
                    .shaderEffect(new ResourceLocation(RotpBATAddon.MOD_ID, "shaders/post/fear_takedown_bm.json"), true)));



    public static final EntityStandRegistryObject<EntityStandType<TimeStopperStandStats>, StandEntityType<BatmanEntity>> STAND_BATMAN =
            new EntityStandRegistryObject<>("batman",
                    STANDS,
                    () -> new EntityStandType.Builder<TimeStopperStandStats>()
                    .color(0x1a1a1a)
                    .storyPartName(PART_DC_NAME)
                    .leftClickHotbar(
                            BATMAN_PUNCH.get(),
                            BATMAN_BATARANG.get()
                            )
                    .rightClickHotbar(
                            BATMAN_GRAPPLE.get(),
                            BATMAN_FEAR_TAKEDOWN.get()
                            )
                    .defaultStats(TimeStopperStandStats.class, new TimeStopperStandStats.Builder()
                            .tier(6)
                            .power(15)
                            .speed(15)
                            .range(10)
                            .durability(20)
                            .precision(10)
                            .timeStopMaxTicks(60, 100)
                            .timeStopLearningPerTick(0.5F)
                            .timeStopDecayPerDay(0F)
                            .timeStopCooldownPerTick(3F)
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
