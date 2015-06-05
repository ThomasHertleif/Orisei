package Model;

public class Count implements RenameOperation {

	private int			start;
	private int			counter;
	private Position	position;
	private String		seperator;

	public Count(int counter) {
		this.start = counter;
		this.counter = counter;
		this.seperator = "";
		this.position = Position.Before;
	}

	public Count(int counter, Position position) {
		this.start = counter;
		this.counter = counter;
		this.seperator = "";
		this.position = position;
	}
	
	public Count(int counter, String seperator) {
		this.start = counter;
		this.counter = counter;
		this.position = Position.Before;
		this.seperator = seperator.length() > 0 ? seperator : "";
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	public void resetCounter() {
		this.counter = this.start;
	}

	@Override
	public String makeNewName(String oldName) {
		String newName = "";

		switch (this.position) {
			case Before:
				newName = this.counter + seperator + oldName;
				break;
			case After:
				newName = oldName + this.counter;
				break;
			default:
				break;
		}

		this.counter += 1;
		return newName;
	}

}
