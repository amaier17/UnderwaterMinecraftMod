package net.underwater.mod.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.underwater.mod.Reference;
import net.underwater.mod.items.ModItem;

public class UnderwaterModItems extends Item{
	
	public static Item copperingot;
	public static Item scubahelmet;
	public static Item scubahelmetwglass;
	
	public static void register() {
		ModItem.registerModItem();
	}
	
	public static void init() {
		copperingot = new ModItem("copperingot");
		scubahelmet = new ModItem("scubahelmet");
		scubahelmetwglass = new ModItem("scubahelmetwglass");
	}
	
	public static void registerRenders() {
		ModItem.registerRendersModItem();
	}
}
