package net.boomexe.terrariatrinkets.util;

import io.netty.util.Constant;
import net.boomexe.terrariatrinkets.item.TerrariaTrinketsItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class TerrariaTrinketsLootTableModifiers {
    private static final Identifier NETHER_FORTRESS_STRUCTURE_CHEST_ID
            = new Identifier("minecraft","chests/nether_bridge");

    private static final Identifier RUINED_PORTAL_STRUCTURE_CHEST_ID
            = new Identifier("minecraft","chests/ruined_portal");

    private static final Identifier ANCIENT_CITY_STRUCTURE_CHEST_ID
            = new Identifier("minecraft","chests/ancient_city");

    private static final Identifier FISHING_TREASURE_ID
            = new Identifier("minecraft","gameplay/fishing/treasure");

    private static final Identifier DESERT_PYRAMID_STRUCTURE_CHEST_ID
            = new Identifier("minecraft","chests/desert_pyramid");

    private static final Identifier CAVE_SPIDER_ID
            = new Identifier("minecraft","entities/cave_spider");

    private static final Identifier SHIPWRECK_TREASURE_STRUCTURE_CHEST_ID
            = new Identifier("minecraft","chests/shipwreck_treasure");

    private static final Identifier SIMPLE_DUNGEON_STRUCTURE_CHEST_ID
            = new Identifier("minecraft","chests/simple_dungeon");

    private static final Identifier UNDERWATER_RUIN_BIG_STRUCTURE_CHEST_ID
            = new Identifier("minecraft","chests/underwater_ruin_big");

    private static final Identifier ABANDONED_MINESHAFT_CHEST_ID
            = new Identifier("minecraft","chests/abandoned_mineshaft");

    private static final Identifier VILLAGE_PLAINS_HOUSE_CHEST_ID
            = new Identifier("minecraft","chests/village/village_plains_house");

    private static final Identifier VILLAGE_DESERT_HOUSE_CHEST_ID
            = new Identifier("minecraft","chests/village/village_desert_house");

    private static final Identifier VILLAGE_SAVANNA_HOUSE_CHEST_ID
            = new Identifier("minecraft","chests/village/village_savanna_house");

    private static final Identifier VILLAGE_SNOWY_HOUSE_CHEST_ID
            = new Identifier("minecraft","chests/village/village_snowy_house");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (NETHER_FORTRESS_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .with(ItemEntry.builder(TerrariaTrinketsItems.OBSIDIAN_SKULL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if (RUINED_PORTAL_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(TerrariaTrinketsItems.OBSIDIAN_SKULL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if (ANCIENT_CITY_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(TerrariaTrinketsItems.MAGIC_MIRROR))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if (FISHING_TREASURE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .with(ItemEntry.builder(TerrariaTrinketsItems.HERMES_BOOTS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if (DESERT_PYRAMID_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(TerrariaTrinketsItems.COBALT_SHIELD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if (CAVE_SPIDER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.02f))
                        .with(ItemEntry.builder(TerrariaTrinketsItems.BEZOAR))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if (SHIPWRECK_TREASURE_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(TerrariaTrinketsItems.RECALL_POTION))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if (SIMPLE_DUNGEON_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1, 4))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(TerrariaTrinketsItems.RECALL_POTION))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if (UNDERWATER_RUIN_BIG_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.3f))
                        .with(ItemEntry.builder(TerrariaTrinketsItems.DIVING_HELMET))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if (VILLAGE_PLAINS_HOUSE_CHEST_ID.equals(id) || VILLAGE_DESERT_HOUSE_CHEST_ID.equals(id) || VILLAGE_SAVANNA_HOUSE_CHEST_ID.equals(id) || VILLAGE_SNOWY_HOUSE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.15f))
                        .with(ItemEntry.builder(TerrariaTrinketsItems.AGLET))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if (ABANDONED_MINESHAFT_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.33f))
                        .with(ItemEntry.builder(TerrariaTrinketsItems.FERAL_CLAWS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

        });
    }
}
