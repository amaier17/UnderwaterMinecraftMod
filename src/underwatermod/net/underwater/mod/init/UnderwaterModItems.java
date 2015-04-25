package net.underwater.mod.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
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
		
	}
	
	public static void registerRenders() {
		ModItem.registerRendersModItem();
		generateRecipes();
	}
	
	public static void generateRecipes() {
		GameRegistry.addRecipe(new ItemStack(UnderwaterModItems.scuba_helmet), new Object[]{" S ", " B ", 'B', Items.bucket, 'S', Items.string});
		GameRegistry.addRecipe(new ItemStack(UnderwaterModItems.scuba_helmet_w_glass), new Object[]{" S ", " B ", " G ", 'G', Blocks.glass_pane, 'B', Items.bucket, 'S', Items.string});
		GameRegistry.addRecipe(new ItemStack(UnderwaterModItems.scuba_helmet_w_glass_w_glowstone), new Object[]{" S ", "LBL", " G ", 'L', Items.glowstone_dust, 'G', Blocks.glass_pane, 'B', Items.bucket, 'S', Items.string});
		GameRegistry.addRecipe(new ItemStack(UnderwaterModItems.scuba_helmet_w_glass_w_glowstone), new Object[]{"LBL", "   ", "   ", 'L', Items.glowstone_dust, 'B', UnderwaterModItems.scuba_helmet_w_glass});
		
	}
	
	
}
