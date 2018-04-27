package be.lorexe.gastweaker.client;

import be.lorexe.gastweaker.CommonProxy;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
	@Override
	public void preInit() {
		GasTweakerRenderer.init();
	}
}
