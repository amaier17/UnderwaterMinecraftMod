package net.underwater.mod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.common.util.EnumHelper;
import net.underwater.mod.Reference;
import net.underwater.mod.UnderwaterMod;

public class ScubaHelmetArmor extends ItemArmor implements ISpecialArmor {

	public static ArmorMaterial ArmorMat = EnumHelper.addArmorMaterial("armMat_scubahelmet", Reference.modid + ":scubahelmet", 10, new int[] {1,1,1,1}, 15);
	
	public ScubaHelmetArmor(String name) {
		//armor type 0 is helmet
		super(ArmorMat, 1, 0);
		this.setCreativeTab(UnderwaterMod.tab);
		this.setUnlocalizedName(name);
	}
	
	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot) {
		if (source ==  DamageSource.drown) {
			return new ArmorProperties(1, 1, MathHelper.floor_double(damage * 0.25d));
		} else {
			return new ArmorProperties(0, 0, 0);
		}
	}
	
	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		return 1;
	}
	
	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {
		if (source == DamageSource.drown) {
			return;
		} else {
			stack.damageItem(damage * 2, entity);
		}
	}
	
	@Override
	public boolean getIsRepairable(ItemStack armor, ItemStack stack) {
		return stack.getItem() == Items.iron_ingot;
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
		player.addPotionEffect(new PotionEffect(Potion.blindness.id, 100, 4000));
		player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 100, 4));
	}
}
