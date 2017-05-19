package com.example.tutorial.blocks;

import com.example.tutorial.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class YepBlock extends Block {

	public YepBlock() {
		super(Material.IRON);
		setUnlocalizedName(Reference.TutorialBlocks.YEPBLOCK.getUnlocalizedName());
		setRegistryName(Reference.TutorialBlocks.YEPBLOCK.getRegistryName());
		//setHardness(6.0F);
		//setResistance(15.0F);
		//setLightLevel(0.5F);
	}

}
