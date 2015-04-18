package net.underwater.mod.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.underwater.mod.Reference;
import net.underwater.mod.blocks.ModBlock;

public class UnderwaterModBlocks {

	public static Block copperblock;
	
	public static void init() {
		copperblock = new ModBlock(Material.rock,"copperblock");
	}
	
	public static void register() {
		ModBlock.registerModBlock();
	}
	
	public static void registerRenders() {
		ModBlock.registerRendersModBlock();
	}
	
}
