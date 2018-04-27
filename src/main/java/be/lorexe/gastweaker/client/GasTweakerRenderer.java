package be.lorexe.gastweaker.client;

import be.lorexe.gastweaker.zenscript.PluginCraftTweaker;
import mekanism.api.gas.Gas;
import mekanism.api.gas.GasRegistry;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GasTweakerRenderer {
	public static void init(){
		//MinecraftForge.EVENT_BUS.register(new GasTweakerRenderer());
	}
	
	/*@SubscribeEvent(priority = EventPriority.LOWEST)
	public void onStitch(TextureStitchEvent.Pre event) {
		System.out.println("--------------------------- " + PluginCraftTweaker.registeredGasses.size());
		for(Gas gas : PluginCraftTweaker.registeredGasses) {
			gas.registerIcon(event.getMap());
		}
	}
	
	@SubscribeEvent
	public void onStitch(TextureStitchEvent.Post event) {
		for(Gas gas : PluginCraftTweaker.registeredGasses) {
			gas.updateIcon(event.getMap());
		}
	}*/
}
