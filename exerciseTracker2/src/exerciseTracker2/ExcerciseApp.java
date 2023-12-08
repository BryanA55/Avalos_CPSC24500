/* Bryan Avalos, CPSC 24500
 * Exercise tracker assignment V2.0
 * The purpose of this program is to input exercises to be kept track of in a graphical user interface
 */
package exerciseTracker2;

import java.util.ArrayList;

public class ExcerciseApp {
	/**
	 * Allows that graphical user interface to be visible on screen and initializes the runwalks array list
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
	ArrayList<RunWalk> runwalks = new ArrayList<RunWalk>();
	MainFrame frame = new MainFrame(runwalks);
	frame.setVisible(true);
	}	
}

