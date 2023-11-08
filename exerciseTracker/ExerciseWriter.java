package exerciseTracker;

import java.util.ArrayList;

public class ExerciseWriter {
	public static void printExercisesToScreen(ArrayList<Exercise> exerciseList) {
	    for (Exercise exercise : exerciseList) {
	    	System.out.println(exercise.toString());
	    }
	}
}