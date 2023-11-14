package exerciseTracker;

public class WeightLifting extends Exercise {
	private double weightLifted;
	private String name;
	
	public double getWeightLifted() {
		return weightLifted;
	}
	public void setWeightLifted(double weightLifted) {
		this.weightLifted = weightLifted;
	}
	// Defining what weight lifting is
	public WeightLifting() {
		super();
	}
	public WeightLifting(String type, String name, String date, int duration, double weightLifted, String comment) {
		super(name, date, duration, comment);
		setWeightLifted(weightLifted);
		setDuration(duration);
	}
	@Override
	public String getType() {
		 return "weightlifting";
	}
	public String getName() {
		return name;
	}
	@Override
	public double getCaloriesBurned() {
		return (weightLifted / getDuration()) * 50;
	}
	@Override // Compare dates for sorting
	public int compareTo(Exercise otherExercise) {
		return this.getDate().compareTo(otherExercise.getDate());
	}
}
