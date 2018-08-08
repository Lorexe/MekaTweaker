[![](http://cf.way2muchnoise.eu/293110.svg)](https://minecraft.curseforge.com/projects/mekatweaker) [![](http://cf.way2muchnoise.eu/versions/Minecraft_293110_all.svg)](https://minecraft.curseforge.com/projects/mekatweaker)

# [MekaTweaker](https://minecraft.curseforge.com/projects/mekatweaker)

MekaTweaker is a CraftTweaker add-on that help adding Mekanism Gas and Infuser Type.

More information on CurseForge Project Page : https://minecraft.curseforge.com/projects/mekatweaker

Some CraftTweaker examples : 

```
#loader mekatweaker
import mods.mekatweaker.Gas;
import mods.mekatweaker.GasFactory;
import mods.mekatweaker.InfuserType;

InfuserType.addType("EMERALD");

var helium17 = GasFactory.createGas("helium17");
helium17.setIcon("blocks/helium17");
helium17.setIconFlowing("blocks/helium17_flow");
helium17.setNeedFluid(true);
helium17.setNeedBucket(true);
helium17.register();
```

```
import mods.mekanism.infuser as Infuser; // From Mekanism, see http://crafttweaker.readthedocs.io/en/latest/#Mods/Mekanism/Metallurgic_Infuser/
import mods.mekatweaker.InfuserType;
import mods.mekatweaker.Gas;
import mods.mekatweaker.GasFactory;

InfuserType.addTypeObject(<minecraft:emerald>, "EMERALD", 10);
Infuser.addRecipe("EMERALD", 10, <minecraft:iron_ingot>, <minecraft:nether_star>);

var lavaGas = GasFactory.createFromFluid(<liquid:lava>);
lavaGas.register();
```