package net.underwater.mod;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.underwater.mod.init.UnderwaterModBlocks;
import net.underwater.mod.init.UnderwaterModItems;
import net.underwater.mod.player.PlayerTickHandler;
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
		
		FMLCommonHandler.instance().bus().register(PlayerTickHandler.instance());
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event) {
		proxy.registerRenders();
		
		
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent postEvent) {
		
	}
}
