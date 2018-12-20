package GUI;

import java.util.*;

import restaurantSimulator.*;

public class GUIProgress {
	private Progress progress;
	//미구현
	public GUIProgress(Option option) {
		progress = Progress.getInstance();
		progress.init(option);
	}
}
