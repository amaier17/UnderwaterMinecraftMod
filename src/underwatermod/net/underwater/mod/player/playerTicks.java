package net.underwater.mod.player;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class playerTicks {
	public static playerTicks Instance = new playerTicks();
	
	private int i = 0;
	
	private int lastX, lastY, lastZ;
	
	public static void init() {
		FMLCommonHandler.instance().bus().register(playerTicks.Instance);
	}
	
	/*
	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		
	}
	*/
	
	@SubscribeEvent
	public void onClientTick(TickEvent.ClientTickEvent event) {
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		if (player != null) {
			int x, y, z;
			x = (int)MathHelper.floor_double(player.posX);
			y = (int)MathHelper.floor_double(player.posY - 0.2);
			z = (int)MathHelper.floor_double(player.posZ);
			
			if (x != lastX || y != lastY || z != lastZ) {
				IBlockState block = player.worldObj.getBlockState(new BlockPos(x, y, z));
				String name = block.getBlock().getUnlocalizedName();
				
				player.addChatMessage(new ChatComponentTranslation("Block:" + name));
				lastX = x;
				lastY = y;
				lastZ = z;
			}
		}
	}
	
	/*
	@SubscribeEvent
	public void onServerTick(TickEvent.ServerTickEvent event) {
		
	}
	
	@SubscribeEvent
	public void onRenderTick(TickEvent.RenderTickEvent event) {
		
	}
	
	@SubscribeEvent
	public void onWorldTick(TickEvent.WorldTickEvent event) {
		
	}
	*/
}
