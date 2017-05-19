package com.example.tutorial;

import com.example.tutorial.init.ModBlocks;
import com.example.tutorial.proxy.CommonProxy;

import net.minecraft.init.Blocks;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)
public class Tutorial {
	@Instance
	public static Tutorial instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ModBlocks.init();
		ModBlocks.register();
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event) {
		proxy.init();
	}
	
	@EventHandler
	public void PostInit(FMLInitializationEvent event) {
		
	}
}
