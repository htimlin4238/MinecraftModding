package com.example.tutorial.blocks;

import java.util.List;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.dispenser.PositionImpl;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityDropper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.example.tutorial.Reference;
import com.google.common.base.Predicate;

public class PlacerBlock extends Block {
	
	
	public PlacerBlock() {
		super(Material.ROCK);
		setUnlocalizedName(Reference.TutorialBlocks.PLACERBLOCK.getUnlocalizedName());
		setRegistryName(Reference.TutorialBlocks.PLACERBLOCK.getRegistryName());
		setHardness(6.0F);
		setResistance(15.0F);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        this.setCreativeTab(CreativeTabs.REDSTONE);
        
	}
	public static final PropertyDirection FACING = PropertyDirection.create("facing");
	
	public int getMetaFromState(IBlockState state) { return 0; }
	public IBlockState getStateFromMeta(int meta) { return this.getDefaultState(); }
	
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        super.onBlockAdded(worldIn, pos, state);
        this.setDefaultDirection(worldIn, pos, state);
    }
	
	private void setDefaultDirection(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
            boolean flag = worldIn.getBlockState(pos.north()).getBlock().isFullBlock(state);
            boolean flag1 = worldIn.getBlockState(pos.south()).getBlock().isFullBlock(state);

            if (enumfacing == EnumFacing.NORTH && flag && !flag1)
            {
                enumfacing = EnumFacing.SOUTH;
            }
            else if (enumfacing == EnumFacing.SOUTH && flag1 && !flag)
            {
                enumfacing = EnumFacing.NORTH;
            }
            else
            {
                boolean flag2 = worldIn.getBlockState(pos.west()).getBlock().isFullBlock(state);
                boolean flag3 = worldIn.getBlockState(pos.east()).getBlock().isFullBlock(state);

                if (enumfacing == EnumFacing.WEST && flag2 && !flag3)
                {
                    enumfacing = EnumFacing.EAST;
                }
                else if (enumfacing == EnumFacing.EAST && flag3 && !flag2)
                {
                    enumfacing = EnumFacing.WEST;
                }
            }

            worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing));
        }
    }
	
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getDefaultState().withProperty(FACING, getFacingFromEntity(pos, placer));
    }
	
	protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FACING});
    }
	
	@Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        world.setBlockState(pos, state.withProperty(FACING, getFacingFromEntity(pos, placer)), 2);
    }
	
	public static EnumFacing getFacingFromEntity(BlockPos clickedBlock, EntityLivingBase entity) {
        return EnumFacing.getFacingFromVector(
             (float) (entity.posX - clickedBlock.getX()),
             0,//(float) (entity.posY - clickedBlock.getY()),
             (float) (entity.posZ - clickedBlock.getZ()));
    }
	
	//http://www.minecraftforge.net/forum/topic/44686-1102-how-to-get-the-side-of-a-block-relative-to-how-it-is-placed/
	
    
}