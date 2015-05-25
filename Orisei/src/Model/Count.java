package Model;

public class Count implements RenameOperation {

	private int			counter;
	private Position	position;

	public Count(int counter) {
		this.counter = counter;
		this.position = Position.Before;
	}

	public Count(int counter, Position position) {
		this.counter = counter;
		this.position = position;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	@Override
	public String makeNewName(String oldName) {
		String newName = "";

		switch (this.position) {
			case Before:
				newName = this.counter + oldName;
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
