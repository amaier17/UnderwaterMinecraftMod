package net.davcraft.mod.items.tools;

import net.davcraft.mod.DavCraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Axe extends ItemAxe {
	
	public Axe(ToolMaterial material) {
		super(material);
		this.setCreativeTab(DavCraft.davcraftTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(DavCraft.modid + ":" + this.getUnlocalizedName().substring(5));  //substring(5) removes "item."
	}
	
	public void generateRecipe(Object handle, Object material) {
		GameRegistry.addRecipe(new ItemStack(this, 1), new Object[] {
			"mm ",
			"mh ",
			" h ",
			'h', handle, 'm', material
		});
		GameRegistry.addRecipe(new ItemStack(this, 1), new Object[] {
			" mm",
			" hm",
			" h ",
			'h', handle, 'm', material
		});
	}
}
