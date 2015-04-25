package net.underwater.mod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.underwater.mod.UnderwaterMod;
import net.underwater.mod.player.PlayerTickHandler;

public class ModItemWetHelmet extends ItemArmor implements PlayerTickHandler.IPlayerTick{
	private boolean equipt = false;
	private boolean firstTick = true;
	
	public ModItemWetHelmet(String name, ArmorMaterial armormat) {
		super(armormat, 1, 0);
		this.setCreativeTab(UnderwaterMod.tab);
		this.setUnlocalizedName(name);
		ModItem.RegisterArmor(this);
		PlayerTickHandler.instance().register(this);
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
		
		NBTTagCompound data = ModItem.getNBTData(armor);
		boolean playerInWater = false;
		
		if (data.hasKey("playerInWater")) {
			playerInWater = data.getBoolean("playerInWater");
		}
		if (player.isInWater() != playerInWater) {
			if (player.isInWater()) {
				this.onWaterEnter(world, player, armor);
			} else {
				onWaterExit(world, player, armor);
			}
			data.setBoolean("playerInWater", player.isInWater());
		}
	}
	
	public void onWaterEnter(World world, EntityPlayer player, ItemStack armor) {
		
	}
	
	public void onWaterExit(World world, EntityPlayer player, ItemStack armor) {
	}
	
	public void onArmorEquipt(World world, EntityPlayer player, ItemStack armor) {
	}
	
	public void onArmorRemoved(World world, EntityPlayer player, ItemStack armor) {
	}

	private ItemStack lastArmor = null;
	
	@Override
	public void Tick(PlayerTickEvent event) {
		ItemStack armor = event.player.getCurrentArmor(3);
		if (this.firstTick) {
			this.equipt = armor != null && Item.getIdFromItem(armor.getItem()) == Item.getIdFromItem(this);
			this.firstTick = false;
		}
		boolean nowEquipt = armor != null && Item.getIdFromItem(armor.getItem()) == Item.getIdFromItem(this);
		if (nowEquipt != this.equipt) {
			
			if (nowEquipt) {
				onArmorEquipt(event.player.worldObj, event.player, armor);
			} else {
				onArmorRemoved(event.player.worldObj, event.player, this.lastArmor);
			}
			this.lastArmor = armor;
			
			this.equipt = nowEquipt;
		}
	}	
}
