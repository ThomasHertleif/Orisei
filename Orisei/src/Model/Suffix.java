package Model;

public class Suffix implements RenameOperation {

	private String	suffix;
	private boolean	ignore_extension;

	public Suffix(String suffix) {
		this.suffix = suffix;
	}

	public Suffix(String suffix, boolean ignore_extension) {
		this.suffix = suffix;
		this.ignore_extension = ignore_extension;
	}

	public String getsuffix() {
		return suffix;
	}

	public void setsuffix(String suffix) {
		this.suffix = suffix;
	}

	/**
	 * Generate new file name by suffixing the suffix to the old name.
	 */
	@Override
	public String makeNewName(String oldName) {
		if (oldName == null) {
			return null;
		}
		if (suffix == null) {
			return oldName;
		}

		int extStart = oldName.lastIndexOf(".");

		if (extStart > -1) {
			return oldName.substring(0, extStart) + suffix + oldName.substring(extStart);
		}

		return oldName + suffix;
	}

}
