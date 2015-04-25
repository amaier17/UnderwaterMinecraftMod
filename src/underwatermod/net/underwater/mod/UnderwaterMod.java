package net.underwater.mod;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.underwater.mod.init.UnderwaterModBlocks;
import net.underwater.mod.init.UnderwaterModItems;
import net.underwater.mod.proxy.CommonProxy;


@Mod(modid = Reference.modid, version = Reference.version, name = Reference.modname)
public class UnderwaterMod {

	@SidedProxy(clientSide = Reference.client_proxy_class, serverSide = Reference.server_proxy_class)
	public static CommonProxy proxy;
	public static final UnderwaterTab tab = new UnderwaterTab("tabUnderwater");
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent preEvent) {
		UnderwaterModBlocks.init();
		UnderwaterModBlocks.register();
		
		UnderwaterModItems.init();
		UnderwaterModItems.register();
		
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event) {
		proxy.registerRenders();
		
		// All of the crafting recipes here
		GameRegistry.addRecipe(new ItemStack(UnderwaterModItems.scuba_helmet), new Object[]{"S", "B", 'B', Items.bucket, 'S', Items.string});
		GameRegistry.addRecipe(new ItemStack(UnderwaterModItems.scuba_helmet_w_glass), new Object[]{"S", "G", "B", 'G', Blocks.glass_pane, 'B', Items.bucket, 'S', Items.string});
		
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent postEvent) {
		
	}
}
