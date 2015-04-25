package net.underwater.mod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.underwater.mod.UnderwaterMod;

public class ModItemWetHelmet extends ItemArmor{
	public ModItemWetHelmet(String name, ArmorMaterial armormat) {
		super(armormat, 1, 0);
		this.setCreativeTab(UnderwaterMod.tab);
		this.setUnlocalizedName(name);
		ModItem.RegisterArmor(this);
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
}
