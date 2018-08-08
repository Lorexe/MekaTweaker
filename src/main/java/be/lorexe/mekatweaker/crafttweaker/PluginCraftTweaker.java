package be.lorexe.mekatweaker.crafttweaker;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import be.lorexe.mekatweaker.MekaTweaker;
import be.lorexe.mekatweaker.crafttweaker.gas.GasFactory;
import be.lorexe.mekatweaker.crafttweaker.gas.GasRepresentation;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import mekanism.api.gas.Gas;

public class PluginCraftTweaker {
	public static void init() {
		CraftTweakerAPI.registerClass(GasFactory.class);
		CraftTweakerAPI.registerClass(GasRepresentation.class);
		CraftTweakerAPI.registerClass(InfuserType.class);
		
		CraftTweakerAPI.tweaker.loadScript(false, MekaTweaker.MODID);
	}
}
