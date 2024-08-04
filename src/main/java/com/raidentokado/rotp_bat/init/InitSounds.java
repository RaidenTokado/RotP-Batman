package com.raidentokado.rotp_bat.init;

import com.raidentokado.rotp_bat.RotpBATAddon;
import com.github.standobyte.jojo.util.mc.OstSoundList;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class InitSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, RotpBATAddon.MOD_ID);

    public static final Supplier<SoundEvent> BATMAN_PUNCH = SOUNDS.register("gl_punch",
            ()-> new SoundEvent(new ResourceLocation(RotpBATAddon.MOD_ID,"gl_punch")));
    public static final Supplier<SoundEvent> BATMAN_GRAPPLE = SOUNDS.register("gl_grapple",
            ()-> new SoundEvent(new ResourceLocation(RotpBATAddon.MOD_ID,"gl_grapple")));
    public static final Supplier<SoundEvent> BATMAN_GRAPPLE_CATCH = SOUNDS.register("gl_grapple_catch",
            ()-> new SoundEvent(new ResourceLocation(RotpBATAddon.MOD_ID,"gl_grapple_catch")));
    public static final RegistryObject<SoundEvent> BATMAN_SUMMON = SOUNDS.register("gl_summon",
            () -> new SoundEvent(new ResourceLocation(RotpBATAddon.MOD_ID, "gl_summon")));

    public static final RegistryObject<SoundEvent> BATMAN_UNSUMMON = SOUNDS.register("gl_unsummon",
            () -> new SoundEvent(new ResourceLocation(RotpBATAddon.MOD_ID, "gl_unsummon")));
    public static final RegistryObject<SoundEvent> USER_BATMAN = SOUNDS.register("gl_user",
            ()->new SoundEvent(new ResourceLocation(RotpBATAddon.MOD_ID, "gl_user")));

    static final OstSoundList BATMAN_OST = new OstSoundList(new ResourceLocation(RotpBATAddon.MOD_ID, "batman_ost"), SOUNDS);
}