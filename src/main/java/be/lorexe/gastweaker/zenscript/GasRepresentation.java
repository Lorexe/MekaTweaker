package be.lorexe.gastweaker.zenscript;

import be.lorexe.gastweaker.GasTweaker;
import mekanism.api.gas.Gas;
import mekanism.api.gas.GasRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.LoaderState;
import net.minecraftforge.fml.relauncher.Side;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenProperty;

@ZenClass("mods.gastweaker.Gas")
public class GasRepresentation {
	@ZenProperty
	public String unlocalizedName;
	@ZenProperty
	public ResourceLocation icon = new ResourceLocation(GasTweaker.MODID, "fluids/fluid_base");
	@ZenProperty
	public boolean colorize = false;
	@ZenProperty
	public int color;
	@ZenProperty
	public boolean needFluid = true;
	@ZenProperty
	public boolean needBucket = true;
	@ZenProperty
	public Fluid fluid;
	
	private boolean fromFluid = false;
	
	public GasRepresentation(String unlocalizedName) {
        this.unlocalizedName = unlocalizedName;
	}
	
	public GasRepresentation(Fluid fluid) {
		this.fluid = fluid;
		this.fromFluid = true;
	}
	
	@ZenMethod
    public String getUnlocalizedName() {
        return this.unlocalizedName;
    }
    @ZenMethod
    public void setUnlocalizedName(String unlocalizedName) {
        this.unlocalizedName = unlocalizedName;
    }
    
    @ZenMethod
    public ResourceLocation getIcon() {
        return this.icon;
    }
    @ZenMethod
    public void setIcon(String icon) {
    	setIcon(GasTweaker.MODID, icon);
    }
    @ZenMethod
    public void setIcon(String domain, String icon) {
        setIcon(new ResourceLocation(domain, icon));
    }
    private void setIcon(ResourceLocation icon) {
        this.icon = icon;
    }
    
    @ZenMethod
    public int getColor() {
        return this.color;
    }
    @ZenMethod
    public void setColor(int color) {
        this.color = color;
    }
    
    @ZenMethod
    public boolean isColorize() {
        return this.colorize;
    }
    @ZenMethod
    public void setColorize(boolean colorize) {
        this.colorize = colorize;
    }
    
    @ZenMethod
    public boolean needFluid() {
        return this.needFluid;
    }
    @ZenMethod
    public void setNeedFluid(boolean need) {
        this.needFluid = need;
    }
    
    @ZenMethod
    public boolean needBucket() {
        return this.needBucket;
    }
    @ZenMethod
    public void setNeedBucket(boolean need) {
        this.needBucket = need;
    }
    
    @ZenMethod
    public void register() {
    	Gas gas;
    	if(this.fromFluid)  gas = new Gas(this.fluid);
    	else				gas = new Gas(this.unlocalizedName, this.icon);
    	
		GasRegistry.register(gas);
		
		if(this.colorize) {
			gas.setTint(this.color);
		}
		
		/*
		if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
			gas.registerIcon(Minecraft.getMinecraft().getTextureMapBlocks());
			gas.updateIcon(Minecraft.getMinecraft().getTextureMapBlocks());
		}
		*/
		if(!this.fromFluid)
			PluginCraftTweaker.registeredGasses.add(gas);
		
		if(!this.fromFluid && this.needFluid) {
			gas.registerFluid();
			
			if(this.needBucket)
				FluidRegistry.addBucketForFluid(gas.getFluid());
		}
    }
}
