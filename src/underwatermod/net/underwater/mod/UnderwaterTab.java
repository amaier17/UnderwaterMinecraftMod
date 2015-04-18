package net.underwater.mod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.underwater.mod.init.UnderwaterModItems;

public class UnderwaterTab extends CreativeTabs{

	public UnderwaterTab(String label) {
		super(label);
		this.setBackgroundImageName("underwater.png");
	}

	@Override
	public Item getTabIconItem() {
		return UnderwaterModItems.copperingot;
	}

}
