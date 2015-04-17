package net.underwater.mod.items;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.underwater.mod.Reference;

public class ModItem extends Item {
	
	private static ArrayList<ModItem> items = new ArrayList<ModItem>();
	
	public ModItem(String name) {
		this();
		this.setUnlocalizedName(name);
	}
	
	public ModItem() {
		items.add(this);
	}
	
	public static void registerModItem() {
		for(ModItem i : items) {
			GameRegistry.registerItem(i, i.getUnlocalizedName().substring(5));
		}
	}
	
	public static void registerRenderModItem() {
		for(ModItem i : items) {
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(i, 0,new ModelResourceLocation(Reference.modid + ":" + i.getUnlocalizedName().substring(5)));
		}
	}
}
