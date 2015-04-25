package net.underwater.mod.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.underwater.mod.items.ModItem;
import net.underwater.mod.items.ScubaHelmetArmor;
import net.underwater.mod.items.ScubaHelmetGlassArmor;
import net.underwater.mod.items.ScubaHelmetGlassGlowstoneArmor;

public class UnderwaterModItems extends Item{
	
	public static Item copperingot;
	public static ItemArmor scuba_helmet;
	public static ItemArmor scuba_helmet_w_glass;
	public static ItemArmor scuba_helmet_w_glass_w_glowstone;
	
	public static void register() {
		ModItem.registerModItem();
	}
	
	public static void init() {
		copperingot = new ModItem("copperingot");
		scuba_helmet_w_glass = new ScubaHelmetGlassArmor("scubahelmetwglass");
		scuba_helmet_w_glass_w_glowstone = new ScubaHelmetGlassGlowstoneArmor("scubahelmetwglasswglowstone");
		scuba_helmet = new ScubaHelmetArmor("scubahelmet");
		ModItem.RegisterArmor(scuba_helmet);
		ModItem.RegisterArmor(scuba_helmet_w_glass);
		ModItem.RegisterArmor(scuba_helmet_w_glass_w_glowstone);
	}
	
	public static void registerRenders() {
		ModItem.registerRendersModItem();
	}
}
