package net.underwater.mod.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.underwater.mod.Reference;
import net.underwater.mod.items.ScubaHelmetArmor;
import net.underwater.mod.items.ModItem;

public class UnderwaterModItems extends Item{
	
	public static Item copperingot;
	public static ItemArmor scuba_helmet;
	public static Item scuba_helmet_w_glass;
	
	public static void register() {
		ModItem.registerModItem();
	}
	
	public static void init() {
		copperingot = new ModItem("copperingot");
		scuba_helmet_w_glass = new ModItem("scubahelmetwglass");
		scuba_helmet = new ScubaHelmetArmor("buckethelmet");
		ModItem.RegisterArmor(scuba_helmet);
	}
	
	public static void registerRenders() {
		ModItem.registerRendersModItem();
	}
}
