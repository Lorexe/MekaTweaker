[![](http://cf.way2muchnoise.eu/293110.svg)](https://minecraft.curseforge.com/projects/gastweaker) [![](http://cf.way2muchnoise.eu/versions/Minecraft_293110_all.svg)](https://minecraft.curseforge.com/projects/gastweaker)

# [GasTweaker](https://minecraft.curseforge.com/projects/gastweaker)

GasTweaker is a CraftTweaker add-on that help adding Mekanism Gas.

More information on CurseForge Project Page : https://minecraft.curseforge.com/projects/gastweaker

Some zenscript examples : 

```
import mods.gastweaker.GasFactory; 
import mods.gastweaker.Gas; 
// Retrieve fluid with crafttweaker 
var lava = <liquid:lava>; 
// Create Gas 
var lavaGas = GasFactory.createFromFluid(lava); 
// Register Gas lavaGas.register();

// Another one
var helium3 = <liquid:helium3>; // <- He3 is a fluid from another mod
var helium3Gas = GasFactory.createFromFluid(helium3);
helium3Gas.setColorize(true);
helium3Gas.setColor(0xff69b4);
helium3Gas.register();
```