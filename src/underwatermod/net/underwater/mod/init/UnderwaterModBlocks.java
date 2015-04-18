package net.underwater.mod.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.underwater.mod.Reference;
import net.underwater.mod.blocks.UnderwaterBlocks;

public class UnderwaterModBlocks {

	public static Block copperblock;
	
	public static void init() {
		copperblock = new UnderwaterBlocks(Material.cloth).setUnlocalizedName("copperblock");
	}
	
	public static void register() {
		GameRegistry.registerBlock(copperblock,copperblock.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders() {
		registerRender(copperblock);
	}
	
	public static void registerRender(Block block) {
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.modid + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
