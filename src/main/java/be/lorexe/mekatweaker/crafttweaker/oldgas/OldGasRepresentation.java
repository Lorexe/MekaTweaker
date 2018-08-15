package be.lorexe.mekatweaker.crafttweaker.oldgas;

import be.lorexe.mekatweaker.MekaTweaker;
import crafttweaker.CraftTweakerAPI;
import mekanism.api.gas.Gas;
import mekanism.api.gas.GasRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.gastweaker.Gas")
@Deprecated
public class OldGasRepresentation {
	public OldGasRepresentation(String unlocalizedName) {}
	public OldGasRepresentation(Fluid fluid) {}
	@ZenMethod
	public String getUnlocalizedName() {return null;}
	@ZenMethod
	public void setUnlocalizedName(String unlocalizedName) {}
	@ZenMethod
	public void setIcon(String icon) {}
	@ZenMethod
	public void setIcon(String domain, String icon) {}
	@ZenMethod
	public int getColor() {return 0;}
	@ZenMethod
	public void setColor(int color) {}
	@ZenMethod
	public boolean isColorize() {return false;}
	@ZenMethod
	public void setColorize(boolean colorize) {}
	@ZenMethod
	public void register() {}
}
