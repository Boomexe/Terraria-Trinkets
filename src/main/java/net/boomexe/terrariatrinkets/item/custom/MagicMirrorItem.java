//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.boomexe.terrariatrinkets.item.custom;

import net.boomexe.terrariatrinkets.sounds.TerrariaTrinketsSoundEvents;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MagicMirrorItem extends Item {
    private static final int MAX_USE_TIME = 20;
    private static boolean CAN_TELEPORT;

    public MagicMirrorItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.terrariatrinkets.magic_mirror.tooltip"));
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            if (!(user.getAttacker() == null)) {
                ((ServerPlayerEntity) user).sendMessage(Text.literal("You can't teleport while in combat!"), true);
                CAN_TELEPORT = false;
                return stack;
            } else {
                Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
                serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
                CAN_TELEPORT = true;
            }
        }

        // MAKING UNABLE TO COMBAT LOG
        if (user instanceof PlayerEntity && !((PlayerEntity)user).getAbilities().creativeMode) {
            if (CAN_TELEPORT) {
                stack.decrement(1);
            }
        }

        if (!world.isClient) {
            ServerPlayerEntity player = (ServerPlayerEntity) user;
            BlockPos spawnPoint = player.getSpawnPointPosition();
            ServerWorld dimension = player.getServer().getWorld(player.getSpawnPointDimension());

            try {
                player.teleport(dimension, spawnPoint.getX(), spawnPoint.getY() + 1, spawnPoint.getZ(), player.getYaw(), player.getPitch());
                player.getWorld().playSound(null, player.getX(), player.getY(), player.getZ(), TerrariaTrinketsSoundEvents.RECALL, SoundCategory.PLAYERS, 1, 1);

            } catch (NullPointerException nullPointerException) {
                BlockPos worldSpawnPos = player.getWorld().getSpawnPos();
                player.teleport(player.getServer().getOverworld(), worldSpawnPos.getX(), worldSpawnPos.getY() + 1, worldSpawnPos.getZ(), player.getYaw(), player.getPitch());
                player.getWorld().playSound(null, player.getX(), player.getY(), player.getZ(), TerrariaTrinketsSoundEvents.RECALL, SoundCategory.PLAYERS, 1, 1);
            }
        }

        if (CAN_TELEPORT) {
            if (stack.isEmpty()) {
                return new ItemStack(Items.GLASS_BOTTLE);
            } else {
                if (user instanceof PlayerEntity && !((PlayerEntity)user).getAbilities().creativeMode) {
                    if (!(user.getAttacker() == null)) {}
                    ItemStack itemStack = new ItemStack(Items.GLASS_BOTTLE);
                    PlayerEntity playerEntity = (PlayerEntity)user;
                    if (!playerEntity.getInventory().insertStack(itemStack)) {
                        playerEntity.dropItem(itemStack, false);
                    }
                }
            }
        }

        return stack;
    }

    public int getMaxUseTime(ItemStack stack) {
        return MAX_USE_TIME;
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.SPYGLASS;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return ItemUsage.consumeHeldItem(world, user, hand);
    }
}
