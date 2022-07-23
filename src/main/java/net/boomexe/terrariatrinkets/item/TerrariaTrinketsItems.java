package net.boomexe.terrariatrinkets.item;

import net.boomexe.terrariatrinkets.TerrariaTrinkets;
import net.boomexe.terrariatrinkets.item.custom.MagicMirrorItem;
import net.boomexe.terrariatrinkets.item.custom.RecallPotionItem;
import net.boomexe.terrariatrinkets.item.trinket.aglet.AgletItem;
import net.boomexe.terrariatrinkets.item.trinket.face.ObsidianSkullItem;
import net.boomexe.terrariatrinkets.item.trinket.glove.CobaltShieldItem;
import net.boomexe.terrariatrinkets.item.trinket.glove.FeralClawsItem;
import net.boomexe.terrariatrinkets.item.trinket.glove.ObsidianShieldItem;
import net.boomexe.terrariatrinkets.item.trinket.belt.BezoarItem;
import net.boomexe.terrariatrinkets.item.trinket.face.DivingHelmetItem;
import net.boomexe.terrariatrinkets.item.trinket.shoe.HermesBootsItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TerrariaTrinketsItems {

    private static final FabricItemSettings TRINKET_SETTINGS = new FabricItemSettings().group(TerrariaTrinketsItemGroup.TERRARIA_TRINKETS).maxCount(1);

    public static final Item HERMES_BOOTS = registerItem("hermes_boots",
            new HermesBootsItem(TRINKET_SETTINGS));

    public static final Item OBSIDIAN_SKULL = registerItem("obsidian_skull",
            new ObsidianSkullItem(TRINKET_SETTINGS));

    public static final Item BEZOAR = registerItem("bezoar",
            new BezoarItem(TRINKET_SETTINGS));

    public static final Item RECALL_POTION = registerItem("recall_potion",
            new RecallPotionItem(new FabricItemSettings().group(TerrariaTrinketsItemGroup.TERRARIA_TRINKETS).maxCount(16)));

    public static final Item MAGIC_MIRROR = registerItem("magic_mirror",
            new MagicMirrorItem(TRINKET_SETTINGS));

    public static final Item COBALT_SHIELD = registerItem("cobalt_shield",
            new CobaltShieldItem(TRINKET_SETTINGS));

    public static final Item DIVING_HELMET = registerItem("diving_helmet",
            new DivingHelmetItem(TRINKET_SETTINGS));

    public static final Item AGLET = registerItem("aglet",
            new AgletItem(new FabricItemSettings().group(TerrariaTrinketsItemGroup.TERRARIA_TRINKETS).maxCount(16)));

    public static final Item OBSIDIAN_SHIELD = registerItem("obsidian_shield",
            new ObsidianShieldItem(TRINKET_SETTINGS));

    public static final Item FERAL_CLAWS = registerItem("feral_claws",
            new FeralClawsItem(TRINKET_SETTINGS));

    private static net.minecraft.item.Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(TerrariaTrinkets.MOD_ID, name), item);
    }

    public static void registerItems() {
        TerrariaTrinkets.LOGGER.info("Registering items for " + TerrariaTrinkets.MOD_ID);
    }
}
