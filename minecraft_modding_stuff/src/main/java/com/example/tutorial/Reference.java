package com.example.tutorial;

public class Reference {
	public static final String MOD_ID = "htm";
	public static final String NAME = "Tutorial Mod";
	public static final String VERSION = "1.0";
	public static final String ACCEPTED_VERSIONS = "[1.11.2]";
	
	public static final String CLIENT_PROXY_CLASS = "com.example.tutorial.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "com.example.tutorial.proxy.ServerProxy";
	
	public static enum TutorialBlocks {
		YEPBLOCK("yepblock", "YepBlock"), PLACERBLOCK("placerblock", "PlacerBlock");
		
		private String unlocalizedName;
		private String registryName;
		
		TutorialBlocks(String unlocalizedName, String registryName) {
			this.unlocalizedName = unlocalizedName;
			this.registryName = registryName;
		}
		
		public String getUnlocalizedName() {
			return unlocalizedName;
		}
		
		public String getRegistryName() {
			return registryName;
		}
		
		
		
		
		
	}
}
