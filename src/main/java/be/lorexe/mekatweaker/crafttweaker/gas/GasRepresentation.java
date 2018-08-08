package be.lorexe.mekatweaker.crafttweaker.gas;

import be.lorexe.mekatweaker.MekaTweaker;
import crafttweaker.CraftTweakerAPI;
import mekanism.api.gas.Gas;
import mekanism.api.gas.GasRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.LoaderState;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenProperty;

@ZenClass("mods.mekatweaker.Gas")
public class GasRepresentation {
	@ZenProperty
	public String unlocalizedName;
	@ZenProperty
	public ResourceLocation icon = null;
	@ZenProperty
	public ResourceLocation iconFlow = null;
	@ZenProperty
	public boolean colorize = false;
	@ZenProperty
	public int color;
	
	
	@ZenProperty
	public boolean needFluid = false;
	@ZenProperty
	public boolean needBucket = true;
	
	
	@ZenProperty
	public Fluid fluid = null;

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
	
	private ResourceLocation getIcon() {
		return this.icon;
	}
	
	@ZenMethod
	public void setIcon(String icon) {
		setIcon(MekaTweaker.MODID, icon);
	}
	@ZenMethod
	public void setIcon(String domain, String icon) {
		setIcon(new ResourceLocation(domain, icon));
	}
	private void setIcon(ResourceLocation icon) {
		this.icon = icon;
	}
	
	private ResourceLocation getIconFlowing() {
		return (this.iconFlow != null) ? this.iconFlow : getIcon();
	}
	
	@ZenMethod
	public void setIconFlowing(String icon) {
		setIconFlowing(MekaTweaker.MODID, icon);
	}
	@ZenMethod
	public void setIconFlowing(String domain, String icon) {
		setIconFlowing(new ResourceLocation(domain, icon));
	}
	private void setIconFlowing(ResourceLocation icon) {
		this.iconFlow = icon;
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
		if(!this.fromFluid && this.needFluid) {
			if(this.fluid == null) {
				if(FluidRegistry.getFluid(unlocalizedName) == null) {
					if(getIcon() == null) {
						CraftTweakerAPI.logWarning("MekaTweaker: Gas " + unlocalizedName + " doesn't have icon set!");
						return;
					}
					
					this.fluid = new Fluid(unlocalizedName, getIcon(), getIconFlowing());
					FluidRegistry.registerFluid(this.fluid);

					Block blockFluid = new BlockFluidClassic(this.fluid, Material.WATER);
					blockFluid.setRegistryName(new ResourceLocation(MekaTweaker.MODID, unlocalizedName));
					ForgeRegistries.BLOCKS.register(blockFluid);
					
					MekaTweaker.proxy.registerFluidBlockRendering(this.fluid);

					if(this.needBucket)
						FluidRegistry.addBucketForFluid(this.fluid);
				}
				else {
					this.fluid = FluidRegistry.getFluid(unlocalizedName);
				}
			}
			
			this.fromFluid = true;
		}
		
		Gas gas;
		if(this.fromFluid)  gas = new Gas(this.fluid);
    	else				gas = new Gas(this.unlocalizedName, this.icon);

		GasRegistry.register(gas);

		if(this.colorize) {
			gas.setTint(this.color);
		}
	}
}
