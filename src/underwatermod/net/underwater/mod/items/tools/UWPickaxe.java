package net.underwater.mod.items.tools;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.underwater.mod.UnderwaterMod;
import net.underwater.mod.items.ModItem;

public class UWPickaxe extends ItemPickaxe {

	public UWPickaxe(ToolMaterial material, String name) {
		super(material);
		ModItem.RegisterOddItem(this);
		this.setCreativeTab(UnderwaterMod.tab);
		this.setUnlocalizedName(name);
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		stack.addEnchantment(Enchantment.aquaAffinity, 1);
	}
	
	@Override
	public void onUsingTick(ItemStack stack, EntityPlayer player, int count)
    {
		stack.addEnchantment(Enchantment.aquaAffinity, 1);
    }
	
}
