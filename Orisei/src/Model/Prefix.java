package Model;

public class Prefix implements RenameOperation{

	private String prefix;
	
	public Prefix(String prefix) {
		this.prefix = prefix;
	}
	
	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	
	/**
	 * Generate new file name by prefixing the prefix to the old name. 
	 */
	@Override
	public String makeNewName(String oldName) {
		return prefix + oldName;
	}

}
