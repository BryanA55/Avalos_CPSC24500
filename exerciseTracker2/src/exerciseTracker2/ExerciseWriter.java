package exerciseTracker2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
// Saves exercises to a file
public class ExerciseWriter {
	public static boolean writeToFile(File f, ArrayList<RunWalk> runwalk) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
			for(RunWalk runwalks : runwalk) {
				pw.println(runwalks);
			}
			pw.close();
			return true;
		} catch (Exception ex) {	
			return false;
		}
	}
}
