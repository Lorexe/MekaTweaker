package be.lorexe.mekatweaker.crafttweaker;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import mekanism.api.infuse.InfuseObject;
import mekanism.api.infuse.InfuseRegistry;
import mekanism.api.infuse.InfuseType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.mekatweaker.InfuserType")
public class InfuserType {
	@ZenMethod
	public static void addType(String name) {
		
		InfuseType infuse = new InfuseType(name.toUpperCase(), new ResourceLocation("mekatweaker:blocks/infuse/" + name.toLowerCase()));
		infuse.setUnlocalizedName(name.toLowerCase());
		
		InfuseRegistry.registerInfuseType(infuse);
	}
	
	@ZenMethod
	public static void addTypeObject(IIngredient ingredients, String typeName, int typeQty) {
		InfuseType infuse = InfuseRegistry.get(typeName.toUpperCase());
		if(infuse == null) {
			CraftTweakerAPI.logError("Not a valid infuse type: " + typeName.toUpperCase());
			return;
		}
		
		InfuseObject object = new InfuseObject(infuse, typeQty);
		for(IItemStack item : ingredients.getItems()) {
			InfuseRegistry.registerInfuseObject(CraftTweakerMC.getItemStack(item), object);
		}
	}
}
