package net.boomexe.terrariatrinkets.item.trinket.face;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.client.TrinketRenderer;
import net.boomexe.terrariatrinkets.item.TerrariaTrinketsItems;
import net.boomexe.terrariatrinkets.item.trinket.TerrariaTrinketItem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
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

public class ObsidianSkullItem extends TerrariaTrinketItem {//implements TrinketRenderer{
    public ObsidianSkullItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.terrariatrinkets.obsidian_skull.tooltip"));
    }

//    @Override
//    public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> contextModel, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, LivingEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
//        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
//        ItemStack itemStack = new ItemStack(TerrariaTrinketsItems.OBSIDIAN_SKULL);
//        TrinketRenderer.translateToFace(matrices, (PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, (AbstractClientPlayerEntity) entity, headYaw, headPitch);
//        itemRenderer.renderItem(entity, itemStack, ModelTransformation.Mode.FIXED, false, matrices, vertexConsumers, entity.world, light, OverlayTexture.DEFAULT_UV, 0);
//    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity.isOnFire() && !entity.isInLava()) {
            entity.extinguish();
        }
    }

    public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
        var modifiers = super.getModifiers(stack, slot, entity, uuid);
        // +1 Armor Point
        modifiers.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(uuid, "terrariatrinkets:obsidian_skull_armor", 1, EntityAttributeModifier.Operation.ADDITION));
        return modifiers;
    }
}
