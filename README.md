GasTweaker is a CraftTweaker add-on that help adding Mekanism Gas.

Some temporary zenscript examples : 

```
import mods.gastweaker.GasFactory;
import mods.gastweaker.Gas;

var helium17 = GasFactory.createGas("helium17");
helium17.setNeedFluid(true);
helium17.setIcon("fluids/helium17");
helium17.register();


var lava = <liquid:lava>;
var lavaGas = GasFactory.createGas(lava);
lavaGas.register();


var helium3 = <liquid:helium3>; // <-- helium3 is created with ContentTweaker
var helium3Gas = GasFactory.createGas(helium3);
helium3Gas.setColorize(true);
helium3Gas.setColor(0xff69b4);
helium3Gas.register();
```