package be.lorexe.mekatweaker.crafttweaker.gas;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.liquid.ILiquidStack;
import net.minecraftforge.fluids.Fluid;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ModOnly("mekanism")
@ZenClass("mods.mekatweaker.GasFactory")
public class GasFactory {
	@ZenMethod
	public static GasRepresentation createGas(String unlocalizedName) {
		return new GasRepresentation(unlocalizedName);
	}
	
	@ZenMethod
	public static GasRepresentation createFromFluid(ILiquidStack stackFluid) {
		Fluid fluid = (Fluid) stackFluid.getDefinition().getInternal();
		return new GasRepresentation(fluid);
	}
}
