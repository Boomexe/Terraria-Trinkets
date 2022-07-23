package net.boomexe.terrariatrinkets.item;

import net.boomexe.terrariatrinkets.TerrariaTrinkets;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class TerrariaTrinketsItemGroup {
    public static final ItemGroup TERRARIA_TRINKETS = FabricItemGroupBuilder.build(new Identifier(TerrariaTrinkets.MOD_ID, "terraria_trinkets"),
            () -> new ItemStack(TerrariaTrinketsItems.OBSIDIAN_SKULL));
}
