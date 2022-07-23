package net.boomexe.terrariatrinkets.item.trinket.aglet;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import net.boomexe.terrariatrinkets.item.trinket.TerrariaTrinketItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;

import java.util.UUID;

public class AgletItem extends TerrariaTrinketItem {
    public AgletItem(Settings settings) {
        super(settings);
    }

    public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
        var modifiers = super.getModifiers(stack, slot, entity, uuid);
        // +40% movement speed
        modifiers.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier(uuid, "terrariatrinkets:movement_speed", 0.05, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
        return modifiers;
    }
}
