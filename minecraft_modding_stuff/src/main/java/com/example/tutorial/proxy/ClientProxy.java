package com.example.tutorial.proxy;

import com.example.tutorial.init.ModBlocks;

public class ClientProxy implements CommonProxy {

	@Override
	public void init() {
		ModBlocks.registerRenders();
	}
}
