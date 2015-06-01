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
		return oldName.substring(0,oldName.indexOf(".")) + suffix + oldName.substring(oldName.indexOf("."));
	}

}
