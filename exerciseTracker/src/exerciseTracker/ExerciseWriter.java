package exerciseTracker;

import java.util.ArrayList;
import java.io.*;

public class ExerciseWriter { 
	// Write the exercise list to a file
	/**
	 * Writes the exercises to a file 
	 * @param exerciseList the exercise list that is to be saved
	 * @param fname the name of the folder the exercises are saved to
	 * @return the exercises written to a file 
	 */
	public static boolean writeExercisesToFile(ArrayList<Exercise> exerciseList, String fname) {
			try {
				PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(fname))));
				for(Exercise exercise : exerciseList) {
					pw.println(exercise.fileFriendlyExerciseList());
				}
				pw.close();
				return true;
			} catch (Exception ex) {
				return false;
			}
	    }
	// Print the exercise list to the screen
	/**
	 * Tabulates the exercises into a table to print to the screen
	 * @param exerciseList the exercises stored as a list
	 */
	public static void tabulateSummary(ArrayList<Exercise> exerciseList) {
	    for (Exercise exercise : exerciseList) {
	    	System.out.println(exercise.toString());
	    }
	}
}