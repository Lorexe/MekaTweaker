package be.lorexe.gastweaker.client;

import be.lorexe.gastweaker.CommonProxy;
import be.lorexe.gastweaker.GasTweaker;
import be.lorexe.gastweaker.util.files.ResourceLoader;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
	private static ResourceLoader resourceLoader;
	
	@Override
	public void registerFluidBlockRendering(Block block, String name)  {
		final ModelResourceLocation fluidLocation = new ModelResourceLocation(new ResourceLocation(GasTweaker.MODID, name), null);

		ModelLoader.setCustomStateMapper(block, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return fluidLocation;
			}
		});
	}

	@Override
	public void createResourceLoader() {
		if (resourceLoader == null) {
			resourceLoader = new ResourceLoader();
			try {
				resourceLoader.setup();
				resourceLoader.createImportantFolders(GasTweaker.MODID);
			} catch (NoSuchFieldException | IllegalAccessException e) {
				GasTweaker.instance.logger.error(e);
			}
		}

	}
}
