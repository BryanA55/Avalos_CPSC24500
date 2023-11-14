package exerciseTracker;

import java.util.Comparator;

public class ExerciseCompareByCalories implements Comparator<Exercise>{
	// Compare to sort by calories burned
	@Override
	public int compare(Exercise exercise1,Exercise exercise2) {
		return Double.compare(exercise1.getCaloriesBurned(), exercise2.getCaloriesBurned());
	}	
}
