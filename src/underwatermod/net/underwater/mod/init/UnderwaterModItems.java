package net.underwater.mod.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.underwater.mod.Reference;
import net.underwater.mod.items.ScubaHelmetArmor;
import net.underwater.mod.items.ModItem;
import net.underwater.mod.items.ScubaHelmetGlassArmor;

public class UnderwaterModItems extends Item{
	
	public static Item copperingot;
	public static ItemArmor scuba_helmet;
	public static ItemArmor scuba_helmet_w_glass;
	
	public static void register() {
		ModItem.registerModItem();
	}
	
	public static void init() {
		copperingot = new ModItem("copperingot");
		scuba_helmet_w_glass = new ScubaHelmetGlassArmor("scubahelmetwglass");
		scuba_helmet = new ScubaHelmetArmor("scubahelmet");
		ModItem.RegisterArmor(scuba_helmet);
		ModItem.RegisterArmor(scuba_helmet_w_glass);
	}
	
	public static void registerRenders() {
		ModItem.registerRendersModItem();
	}
}
