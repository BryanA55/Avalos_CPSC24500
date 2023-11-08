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
	
	public WeightLifting() {
		super();
	}
	public WeightLifting(String name, String date, int duration, double weightLifted, String comment) {
		super(name, date, duration, comment);
	}
	//@Override
	//public String getType() {
		//return 
	//}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public double getCaloriesBurned() {
		caloriesBurned = (weightLifted / getDuration()) * 50;
		setCaloriesBurned(caloriesBurned);
		return caloriesBurned;
	}
	private void setCaloriesBurned(double caloriesBurned) {
		this.caloriesBurned = caloriesBurned;
	}
	@Override
	public double calculateCalories() {
		return getCaloriesBurned();
	}
}
