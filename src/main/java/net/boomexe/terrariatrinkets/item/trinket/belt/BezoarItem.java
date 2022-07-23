package net.boomexe.terrariatrinkets.item.trinket.belt;

import dev.emi.trinkets.api.SlotReference;
import net.boomexe.terrariatrinkets.item.trinket.TerrariaTrinketItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BezoarItem extends TerrariaTrinketItem {
    public BezoarItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.terrariatrinkets.bezoar.tooltip"));
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        entity.removeStatusEffect(StatusEffects.POISON);
    }
}
