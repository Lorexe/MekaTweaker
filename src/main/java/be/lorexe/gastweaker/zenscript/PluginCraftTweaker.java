package be.lorexe.gastweaker.zenscript;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import mekanism.api.gas.Gas;

public class PluginCraftTweaker {
	public static ArrayList<Gas> registeredGasses = new ArrayList<>();
	
	public static void init() {
		CraftTweakerAPI.registerClass(GasFactory.class);
		CraftTweakerAPI.registerClass(GasRepresentation.class);
	}
}
