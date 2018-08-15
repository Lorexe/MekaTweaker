package be.lorexe.mekatweaker.crafttweaker.oldgas;

import be.lorexe.mekatweaker.crafttweaker.gas.GasRepresentation;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.api.liquid.ILiquidStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.gastweaker.GasFactory")
@Deprecated
public class OldGasFactory {
	@ZenMethod
	public static OldGasRepresentation createGas(String unlocalizedName) {
		CraftTweakerAPI.logError("MekaTweaker: You are using 'gastweaker' instead of 'mekatweaker'! See https://minecraft.curseforge.com/projects/mekatweaker for the new documentation.");
		return new OldGasRepresentation("");
	}
	@ZenMethod
	public static OldGasRepresentation createFromFluid(ILiquidStack stackFluid) { return createGas(""); }
}
