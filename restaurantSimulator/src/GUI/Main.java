package GUI;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		GUIMain mainGUI = new GUIMain();
		List<Integer> sort = new ArrayList<Integer>();
		sort.add(5);
		sort.add(7);
		sort.add(1);
		sort.add(3);
		sort.add(10);
		sort.add(6);
		sort.sort(null);
	}
}
