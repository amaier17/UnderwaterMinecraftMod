package net.underwater.mod.blocks;

import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.underwater.mod.UnderwaterMod;
import net.underwater.mod.init.UnderwaterModBlocks;

public class StoneBench extends ModBlock {
	
	public StoneBench(String name) {
		super(Material.rock, name);
	}
	
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
		//todo figure out how to register gui graphics and events
		if (!player.isSneaking()) {
			if (!world.isRemote) {
				player.displayGui(new BlockWorkbench.InterfaceCraftingTable(world, pos));
			}
			return true;
		} else {
			return false;
		}
	}
}
