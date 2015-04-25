package net.underwater.mod.items;

import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.underwater.mod.UnderwaterMod;

public class ModItemArmor extends ItemArmor{
	public ModItemArmor(String name, ArmorMaterial armormat) {
		super(armormat, 1, 0);
		this.setCreativeTab(UnderwaterMod.tab);
		this.setUnlocalizedName(name);
		ModItem.RegisterArmor(this);
	}
}
