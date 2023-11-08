package exerciseTracker;

public class RunWalk extends Exercise {
	private double distance; 
	private String name;
	
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public RunWalk() {
		super();
	}
	public RunWalk(String name, String date, int duration, double distance, String comment) {
		super(name, date, duration, comment);
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public double getCaloriesBurned() {
		caloriesBurned = (distance / getDuration()) * 9000;
		return caloriesBurned;
	}
	@Override
	public double calculateCalories() {
		return getCaloriesBurned();
	}
}
