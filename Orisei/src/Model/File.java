package Model;

import java.nio.file.Path;

public class File {

	private String path; 
	private String name;
	
	/**
	 * Construct a new file from a path
	 * @param completePath
	 */
	public File(Path completePath) {
		this.setPath(completePath.getParent().toString());
		this.setName(completePath.getFileName().toString());
	}

	
	public String getName() {
		return name;
	}


	/**
	 * This one is special, as it renames the actual file and not just the variable.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
		// TODO: rename le file
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}
	
}
