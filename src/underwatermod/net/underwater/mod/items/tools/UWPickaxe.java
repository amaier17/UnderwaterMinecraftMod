package net.underwater.mod.items.tools;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.underwater.mod.UnderwaterMod;
import net.underwater.mod.items.ModItem;

public class UWPickaxe extends ItemPickaxe {

	private float digModifier = 1f;
	
	public UWPickaxe(ToolMaterial material, String name) {
		super(material);
		ModItem.RegisterOddItem(this);
		this.setCreativeTab(UnderwaterMod.tab);
		this.setUnlocalizedName(name);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
		if (isSelected) {
			if (entityIn.isInWater()) {
				this.digModifier = 5;
			} else {
				this.digModifier = 1;				
			}
		}
    }
	
	@Override
	public float getDigSpeed(ItemStack itemstack, net.minecraft.block.state.IBlockState state) {
		return super.getDigSpeed(itemstack, state) * this.digModifier;
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, Block blockIn, BlockPos pos, EntityLivingBase playerIn)
    {
		if(!playerIn.isInsideOfMaterial(Material.water)){
			stack.damageItem(150, playerIn);
		}
        return false;
    }
	
}
