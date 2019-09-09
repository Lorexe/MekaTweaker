package be.lorexe.mekatweaker.crafttweaker;

import be.lorexe.mekatweaker.MekaTweaker;
import crafttweaker.CraftTweakerAPI;

public class PluginCraftTweaker {
	public static void init() {
		CraftTweakerAPI.tweaker.loadScript(false, MekaTweaker.MODID);
	}
}
