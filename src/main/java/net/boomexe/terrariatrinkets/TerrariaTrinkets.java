package net.boomexe.terrariatrinkets;

import net.boomexe.terrariatrinkets.item.TerrariaTrinketsItems;
import net.boomexe.terrariatrinkets.sounds.TerrariaTrinketsSoundEvents;
import net.boomexe.terrariatrinkets.util.TerrariaTrinketsLootTableModifiers;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TerrariaTrinkets implements ModInitializer {

	public static final String MOD_ID = "terrariatrinkets";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		TerrariaTrinketsItems.registerItems();
		TerrariaTrinketsSoundEvents.registerSounds();
		TerrariaTrinketsLootTableModifiers.modifyLootTables();


		LOGGER.info("Initialized Terraria Trinkets");
	}
}
