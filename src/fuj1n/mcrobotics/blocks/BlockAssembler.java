package fuj1n.mcrobotics.blocks;

import fuj1n.mcrobotics.tileentity.TileEntityAssembler;

import fuj1n.mcrobotics.MCRobotics;

import net.minecraft.entity.player.EntityPlayer;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;

public class BlockAssembler extends BlockContainer {

	public BlockAssembler(int par1) {
		super(par1, Material.iron);
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		par5EntityPlayer.openGui(MCRobotics.instance, 0, par1World, par2, par3, par4);
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityAssembler();
	}

}
