package net.underwater.mod.items;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.item.ItemEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DropHandler {

	public static DropHandler instance = new DropHandler();
	
	public static void init() {
		MinecraftForge.EVENT_BUS.register(DropHandler.instance);
	}
	
	/*
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onEvent(LivingDropsEvent event) {
		for (int i = 0; i < event.drops.size(); i++) {
			EntityItem item = event.drops.get(i);
		}
	}
	*/
	
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onEvent(ItemEvent event) {
		EntityItem ei = event.entityItem;
		if (ei.getEntityItem().getItem() == Items.bread) {
			if (ei.worldObj.getBlockState(new BlockPos(ei.posX, ei.posY, ei.posZ)).getBlock() == Blocks.water){
				Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentTranslation("Bread in water"));
				ei.setPositionAndUpdate(ei.posX, ei.posY, ei.posZ);
				ei.isAirBorne = false;
				ei.isCollided = true;
				ei.isCollidedHorizontally = true;
				ei.isCollidedVertically = true;
				ei.height = 0;
				ei.motionX = 0;
				ei.motionY = 0;
				ei.motionZ = 0;
				//still no luck on stopping entity motion... may have to add motion to global tick event with list of floating water elements
				//todo look into entity accelleration algorithms (can invers math safely be used?)
			}
		}
	}
	
}
