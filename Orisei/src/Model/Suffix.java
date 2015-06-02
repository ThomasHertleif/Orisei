package Model;

public class Suffix implements RenameOperation {

	private String	suffix;

	public Suffix(String suffix) {
		this.suffix = suffix;
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
