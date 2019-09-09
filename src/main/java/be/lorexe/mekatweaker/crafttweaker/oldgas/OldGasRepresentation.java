package be.lorexe.mekatweaker.crafttweaker.oldgas;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import net.minecraftforge.fluids.Fluid;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ModOnly("mekanism")
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
