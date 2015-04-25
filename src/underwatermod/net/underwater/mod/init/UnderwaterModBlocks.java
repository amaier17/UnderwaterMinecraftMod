package net.underwater.mod.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.underwater.mod.Reference;
import net.underwater.mod.blocks.ModBlock;
import net.underwater.mod.blocks.StoneBench;

public class UnderwaterModBlocks {

	public static Block copperblock;
	public static Block stoneBench;
	public static final int guiIDStoneBench = 1;
	
	public static void init() {
		copperblock = new ModBlock(Material.rock,"copperblock");
		stoneBench = new StoneBench("stonebench");
	}
	
	public static void register() {
		ModBlock.registerModBlock();
	}
	
	public static void registerRenders() {
		ModBlock.registerRendersModBlock();
	}
	
}
