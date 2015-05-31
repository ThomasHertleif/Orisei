package Model;

public class SearchAndReplace implements RenameOperation {

	private String	pattern;
	private String	replacement;
	
	public SearchAndReplace(String pattern, String replacement) {
		this.pattern = pattern;
		this.replacement = replacement;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getReplacment() {
		return replacement;
	}

	public void setReplacment(String replacment) {
		this.replacement = replacment;
	}

	/**
	 * Generate a new file name by replacing the first occurrence of `pattern`
	 * with `replacement`.
	 */
	@Override
	public String makeNewName(String oldName) {
		return oldName.replaceFirst(this.pattern, this.replacement);
	}

}
