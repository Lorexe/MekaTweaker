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
    public static void registerGas(String unlocalizedName, String icon) {
		Gas gas = new Gas(unlocalizedName, icon);
		GasRegistry.register(gas);
		gas.registerFluid();
	}*/
	
	@ZenMethod
    public static GasRepresentation createGas(String unlocalizedName) {
		return new GasRepresentation(unlocalizedName);
	}
	
	@ZenMethod
    public static GasRepresentation createGas(ILiquidStack stackFluid) {
		Fluid fluid = (Fluid) stackFluid.getDefinition().getInternal();
		return new GasRepresentation(fluid);
	}
}
