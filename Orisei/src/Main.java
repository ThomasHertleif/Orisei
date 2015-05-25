import View.*;
import Model.*;

public class Main {

	static MainView			MainView;
	static Prefix			Prefix;
	static Suffix			Suffix;
	static SearchAndReplace	SearchAndReplace;

	public static void main(String[] args) {

		MainView = new MainView();
		Prefix = new Prefix();
		Suffix = new Suffix();
		SearchAndReplace = new SearchAndReplace();

	}

}
