package be.lorexe.mekatweaker.client;

import be.lorexe.mekatweaker.CommonProxy;
import be.lorexe.mekatweaker.MekaTweaker;
import be.lorexe.mekatweaker.util.files.ResourceLoader;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
	private static ResourceLoader resourceLoader;
	
	@Override
	public void preInit() {
		createResourceLoader();
	}
	
	@Override
	public void registerFluidBlockRendering(Fluid fluid)  {
		Block block = fluid.getBlock();
        Item item = Item.getItemFromBlock(block);
        FluidStateMapper mapper = new FluidStateMapper(fluid);
        ModelLoader.registerItemVariants(item);
        ModelLoader.setCustomMeshDefinition(item, mapper);
        ModelLoader.setCustomStateMapper(block, mapper);
	}

	@Override
	public void createResourceLoader() {
		if (resourceLoader == null) {
			resourceLoader = new ResourceLoader();
			try {
				resourceLoader.setup();
				resourceLoader.createImportantFolders(MekaTweaker.MODID);
			} catch (NoSuchFieldException | IllegalAccessException e) {
				MekaTweaker.instance.logger.error(e);
			}
		}

	}
}
