package net.underwater.mod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.underwater.mod.init.UnderwaterModBlocks;
import net.underwater.mod.init.UnderwaterModItems;
import net.underwater.mod.proxy.CommonProxy;


@Mod(modid = Reference.modid, version = Reference.version, name = Reference.modname)
public class UnderwaterMod {

	@SidedProxy(clientSide = Reference.client_proxy_class, serverSide = Reference.server_proxy_class)
	public static CommonProxy proxy;
	
	
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
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent postEvent) {
		
	}
}
