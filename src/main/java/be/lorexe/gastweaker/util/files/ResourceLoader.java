package be.lorexe.gastweaker.util.files;

import com.google.common.collect.Lists;

import be.lorexe.gastweaker.GasTweaker;
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

/*
 * Borrowed From B.A.S.E
 * (https://github.com/The-Acronym-Coders/BASE/blob/bf6a80399dd1a344edfa6dbd2d34f18e4a2d2aca/src/main/java/com/teamacronymcoders/base/util/files/ResourceLoader.java)
 */
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

			List<IResourcePack> defaultResourcePacks = ReflectionHelper.getPrivateValue(Minecraft.class, Minecraft.getMinecraft(), "defaultResourcePacks", "field_110449_ao", "ap");
			defaultResourcePacks.add(new DirectoryResourcePack(this.resourceFolder));
		}

		createPackMcMeta();
	}

	private void createFolder(File file) {
		if (!file.exists() && !file.mkdirs()) {

		}
	}

	private void createPackMcMeta() {
		String mcMeta = "{\"pack\":{\"pack_format\":3,\"description\":\"External Resources\"}}";
		writeStringToFile(mcMeta, new File(this.resourceFolder, "pack.mcmeta"));
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
	}

	private static void writeStringToFile(String string, File file) {
		boolean exists = file.exists();
		if (!exists) {
			try {
				file.getParentFile().mkdirs();
				exists = file.createNewFile();
			} catch (IOException e) {
				GasTweaker.instance.logger.error(e);
			}
		}
		if (exists) {
			try {
				FileUtils.writeStringToFile(file, string, Charset.defaultCharset());
			} catch (IOException e) {
				GasTweaker.instance.logger.error(e);
			}
		} else {
			GasTweaker.instance.logger.error("Couldn't create File: " + file.getName());
		}
	}
}
