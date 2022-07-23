package net.boomexe.terrariatrinkets.item.trinket.face;

import dev.emi.trinkets.api.SlotReference;
import net.boomexe.terrariatrinkets.item.trinket.TerrariaTrinketItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DivingHelmetItem extends TerrariaTrinketItem {
    public DivingHelmetItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.terrariatrinkets.diving_helmet.tooltip"));
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (!entity.isSubmergedInWater()) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 200, 0, false, false, false));
        }
    }
}
