package net.underwater.mod.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.underwater.mod.Reference;

public class UnderwaterModItems extends Item{
	
	public static Item copperingot;
	
	public static void register() {
		GameRegistry.registerItem(copperingot, copperingot.getUnlocalizedName().substring(5));
	}
	
	public static void init() {
		copperingot = new Item().setUnlocalizedName("copperingot");
	}
	
	public static void registerRenders() {
		registerRender(copperingot);
	}
	
	public static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.modid + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
}
