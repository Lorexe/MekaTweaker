package be.lorexe.gastweaker.zenscript;

import crafttweaker.api.liquid.ILiquidStack;
import mekanism.api.gas.Gas;
import mekanism.api.gas.GasRegistry;
import net.minecraftforge.fluids.Fluid;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.gastweaker.GasFactory")
public class GasFactory {
	/*@ZenMethod
	public static GasRepresentation createGas(String unlocalizedName) {
		return new GasRepresentation(unlocalizedName);
	}*/
	
	@ZenMethod
	public static GasRepresentation createFromFluid(ILiquidStack stackFluid) {
		Fluid fluid = (Fluid) stackFluid.getDefinition().getInternal();
		return new GasRepresentation(fluid);
	}
}
