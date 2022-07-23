package net.boomexe.terrariatrinkets.sounds;

import net.boomexe.terrariatrinkets.TerrariaTrinkets;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TerrariaTrinketsSoundEvents {
    public static SoundEvent TRINKET_EQUIP = registerSoundEvent("trinket_equip");

    public static SoundEvent RECALL = registerSoundEvent("recall");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(TerrariaTrinkets.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

    public static void registerSounds() {
        TerrariaTrinkets.LOGGER.info("Registering sounds for " + TerrariaTrinkets.MOD_ID);
    }
}
