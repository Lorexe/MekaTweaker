package be.lorexe.mekatweaker;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;

import java.io.File;

import org.apache.logging.log4j.Logger;

import be.lorexe.mekatweaker.crafttweaker.PluginCraftTweaker;
import mekanism.api.gas.Gas;
import mekanism.api.gas.GasRegistry;
import mekanism.api.infuse.InfuseRegistry;
import mekanism.api.infuse.InfuseType;

@Mod(modid = MekaTweaker.MODID, name = MekaTweaker.NAME, version = MekaTweaker.VERSION, dependencies = MekaTweaker.DEPENDS)
public class MekaTweaker {

	public static final String MODID = "mekatweaker";
	public static final String NAME = "MekaTweaker";
	public static final String VERSION = "1.1";
	public static final String DEPENDS = "required-after:crafttweaker;required-after:mekanism;required-after:resourceloader";

	@Instance(MODID)
	public static MekaTweaker instance;

	@SidedProxy(clientSide = "be.lorexe.mekatweaker.client.ClientProxy", serverSide = "be.lorexe.mekatweaker.CommonProxy")
	public static CommonProxy proxy;

	public static Logger logger;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit();
		
		logger = event.getModLog();
		
		PluginCraftTweaker.init();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}

	public Logger getLogger() {
		return this.logger;
	}
}
