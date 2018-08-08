package be.lorexe.mekatweaker.util.files;

import com.google.common.collect.Lists;

import be.lorexe.mekatweaker.MekaTweaker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IResourcePack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.nio.charset.MalformedInputException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SideOnly(Side.CLIENT)
public class ResourceLoader {
	private File resourceFolder;

	public ResourceLoader() {
		
	}
	
	public void setup() throws NoSuchFieldException, IllegalAccessException {
		Field minecraftDirField = Loader.class.getDeclaredField("minecraftDir");
		minecraftDirField.setAccessible(true);
		Object minecraftDirObject = minecraftDirField.get(null);
		if (minecraftDirObject instanceof File) {
			File minecraftDir = (File)minecraftDirObject;
			this.resourceFolder = new File(minecraftDir, "resources");
			createFolder(this.resourceFolder);
		}
	}

	private void createFolder(File file) {
		if (!file.exists() && !file.mkdirs()) { }
	}

	public void createImportantFolders(String modid) {
		File modFolder = new File(resourceFolder, modid);
		createFolder(modFolder);
		File lang = new File(modFolder, "lang");
		createFolder(lang);
		File enUsLang = new File(lang, "en_us.lang");
		if (!enUsLang.exists()) {
			writeStringToFile("", enUsLang);
		}
		
		File texturesFolder = new File(modFolder, "textures");
		createFolder(texturesFolder);
		File blocksFolder = new File(texturesFolder, "blocks");
		createFolder(blocksFolder);
		File infuseFolder = new File(blocksFolder, "infuse");
		createFolder(infuseFolder);
		
		File blockstates = new File(modFolder, "blockstates");
		createFolder(blockstates);
		
		File fluids = new File(blockstates, "fluids.json");
		if (!fluids.exists()) {
			writeStringToFile("{\n", fluids);
			writeStringToFile("\t\"forge_marker\": 1,\n", fluids, true);
			writeStringToFile("\t\"variants\": {\n", fluids, true);
			writeStringToFile("\t\t\"example_fluid\": {\n", fluids, true);
			writeStringToFile("\t\t\t\"model\": \"forge:fluid\",\n", fluids, true);
			writeStringToFile("\t\t\t\"custom\": { \"fluid\": \"example_fluid\" }\n", fluids, true);
			writeStringToFile("\t\t},\n", fluids, true);
			writeStringToFile("\t\t\"example_fluid_2\": {\n", fluids, true);
			writeStringToFile("\t\t\t\"model\": \"forge:fluid\",\n", fluids, true);
			writeStringToFile("\t\t\t\"custom\": { \"fluid\": \"example_fluid_2\" }\n", fluids, true);
			writeStringToFile("\t\t}\n", fluids, true);
			writeStringToFile("\t}\n", fluids, true);
			writeStringToFile("}", fluids, true);
		}
	}

	private static void writeStringToFile(String string, File file) {
		writeStringToFile(string, file, false);
	}
	
	private static void writeStringToFile(String string, File file, boolean append) {
		boolean exists = file.exists();
		if (!exists) {
			try {
				file.getParentFile().mkdirs();
				exists = file.createNewFile();
			} catch (IOException e) {
				MekaTweaker.instance.logger.error(e);
			}
		}
		if (exists) {
			try {
				FileUtils.writeStringToFile(file, string, Charset.defaultCharset(), append);
			} catch (IOException e) {
				MekaTweaker.instance.logger.error(e);
			}
		} else {
			MekaTweaker.instance.logger.error("Couldn't create File: " + file.getName());
		}
	}
}
