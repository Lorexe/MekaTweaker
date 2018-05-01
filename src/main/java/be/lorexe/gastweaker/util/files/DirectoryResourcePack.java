package be.lorexe.gastweaker.util.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Nonnull;

import net.minecraft.client.resources.AbstractResourcePack;

/*
 * Borrowed From B.A.S.E
 * (https://github.com/The-Acronym-Coders/BASE/blob/bf6a80399dd1a344edfa6dbd2d34f18e4a2d2aca/src/main/java/com/teamacronymcoders/base/util/files/DirectoryResourcePack.java)
 */
public class DirectoryResourcePack  extends AbstractResourcePack {
	private Set<String> domains;

	public DirectoryResourcePack(File resourceFolder) {
		super(resourceFolder);
	}

	@Override
	@Nonnull
	protected InputStream getInputStreamByName(@Nonnull String name) throws IOException {
		return new FileInputStream(this.getFile(name));
	}

	@Override
	protected boolean hasResourceName(@Nonnull String name) {
		return this.getFile(name).exists();
	}

	private File getFile(String name) {
		return new File(this.resourcePackFile, name.replace("assets/", ""));
	}

	@Override
	@Nonnull
	public Set<String> getResourceDomains() {
		if (domains == null) {
			this.domains = new HashSet<>();
			String[] folderNames = this.resourcePackFile.list();
			if (folderNames != null) {
				domains.addAll(Arrays.asList(folderNames));
			}
		}
		return domains;
	}
}
