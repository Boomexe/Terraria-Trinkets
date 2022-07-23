package net.boomexe.terrariatrinkets.item.trinket.glove;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import net.boomexe.terrariatrinkets.item.trinket.TerrariaTrinketItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class CobaltShieldItem extends TerrariaTrinketItem {
    public CobaltShieldItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.terrariatrinkets.cobalt_shield.tooltip"));
    }

    public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
        var modifiers = super.getModifiers(stack, slot, entity, uuid);
        // +10 Knockback Resistance, +1 Armor
        modifiers.put(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, new EntityAttributeModifier(uuid, "terrariatrinkets:cobalt_shield_knockback_resistance", 10, EntityAttributeModifier.Operation.ADDITION));
        modifiers.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(uuid, "terrariatrinkets:cobalt_shield_armor", 1, EntityAttributeModifier.Operation.ADDITION));
        return modifiers;
    }
}
