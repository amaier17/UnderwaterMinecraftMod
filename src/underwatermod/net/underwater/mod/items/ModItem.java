package net.underwater.mod.items;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.underwater.mod.Reference;
import net.underwater.mod.UnderwaterMod;

public class ModItem extends Item {
	
	private static ArrayList<ModItem> items = new ArrayList<ModItem>();
	
	public ModItem(String name) {
		this();
		this.setUnlocalizedName(name);
	}
	
	public ModItem() {
		super();
		items.add(this);
		this.setCreativeTab(UnderwaterMod.tab);
	}
	
	public static void registerModItem() {
		for(ModItem i : items) {
			GameRegistry.registerItem(i, i.getUnlocalizedName().substring(5));
		}
	}
	
	public static void registerRendersModItem() {
		for(ModItem i : items) {
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(i, 0,new ModelResourceLocation(Reference.modid + ":" + i.getUnlocalizedName().substring(5),"inventory"));
		}
	}
}
