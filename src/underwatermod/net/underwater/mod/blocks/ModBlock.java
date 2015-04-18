package net.underwater.mod.blocks;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.underwater.mod.Reference;
import net.underwater.mod.UnderwaterMod;

public class ModBlock extends Block{
	
	// List of blocks
	private static ArrayList<ModBlock> blocks = new ArrayList<ModBlock>();
	
	// Required constructors
	protected ModBlock(Material materialIn) {
		super(materialIn);
		blocks.add(this);
		this.setCreativeTab(UnderwaterMod.tab);
	}
	
	// Custom constructor
	public ModBlock(Material materialIn, String name) {
		this(materialIn);
		this.setUnlocalizedName(name);
	}

	
	
	public static void registerModBlock() {
		for(ModBlock b : blocks) {
			GameRegistry.registerBlock(b, b.getUnlocalizedName().substring(5));
		}
	}
	
	public static void registerRendersModBlock() {
		for(ModBlock b : blocks) {
			Item item = Item.getItemFromBlock(b);
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.modid + ":" + item.getUnlocalizedName().substring(5)));
		}
	}
	

}