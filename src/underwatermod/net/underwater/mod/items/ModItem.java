package net.underwater.mod.items;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.underwater.mod.Reference;
import net.underwater.mod.UnderwaterMod;

public class ModItem extends Item {
	
	private static ArrayList<Item> items = new ArrayList<Item>();
	
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
		for(Item i : items) {
			GameRegistry.registerItem(i, i.getUnlocalizedName().substring(5));
		}
	}
	
	public static void registerRendersModItem() {
		for(Item i : items) {
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(i, 0,new ModelResourceLocation(Reference.modid + ":" + i.getUnlocalizedName().substring(5),"inventory"));
		}
	}

	public static void RegisterArmor(ItemArmor item) {
		ModItem.items.add(item);		
	}

	public static void RegisterOddItem(Item item) {
		ModItem.items.add(item);		
	}

	public static NBTTagCompound getNBTData(ItemStack item) {
		NBTTagCompound data = item.getTagCompound();
		if (data == null) {
			data = new NBTTagCompound();
			item.setTagCompound(data);
		}
		return data;
	}
}
