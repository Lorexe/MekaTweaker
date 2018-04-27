package be.lorexe.gastweaker;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.init.Blocks;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

import org.apache.logging.log4j.Logger;

import be.lorexe.gastweaker.zenscript.PluginCraftTweaker;
import mekanism.api.gas.Gas;
import mekanism.api.gas.GasRegistry;

@Mod(modid = GasTweaker.MODID, name = GasTweaker.NAME, version = GasTweaker.VERSION, dependencies = GasTweaker.DEPENDS)
public class GasTweaker
{
    public static final String MODID = "gastweaker";
    public static final String NAME = "GasTweaker";
    public static final String VERSION = "1.0";
    public static final String DEPENDS = "required-after:crafttweaker;required-after:mekanism;";

    @Instance(MODID)
    public static GasTweaker instance;
    
    @SidedProxy(clientSide = "be.lorexe.gastweaker.client.ClientProxy", serverSide = "be.lorexe.gastweaker.CommonProxy")
    public static CommonProxy proxy;
    
    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        
        PluginCraftTweaker.init();
        
        proxy.preInit();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	
    }
}
