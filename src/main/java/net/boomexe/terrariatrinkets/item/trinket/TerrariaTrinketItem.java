package net.boomexe.terrariatrinkets.item.trinket;

import dev.emi.trinkets.api.TrinketItem;
import net.boomexe.terrariatrinkets.sounds.TerrariaTrinketsSoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Rarity;
import org.jetbrains.annotations.Nullable;

public class TerrariaTrinketItem extends TrinketItem {
    public TerrariaTrinketItem(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public SoundEvent getEquipSound() { return TerrariaTrinketsSoundEvents.TRINKET_EQUIP; }

    @Override
    public Rarity getRarity(ItemStack stack) {
        return Rarity.EPIC;
    }
}
