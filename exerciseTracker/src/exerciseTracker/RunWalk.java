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
	// Defining what a run/walk is
	public RunWalk() {
		super();
	}
	public RunWalk(String type, String name, String date, int duration, double distance, String comment) {
		super(name, date, duration, comment);
		setDistance(distance);
		setDuration(duration);
	}
	@Override
	public String getType() {
		return "runwalk";
	}
	public String getName() {
		return name;
	}
	@Override
	public double getCaloriesBurned() {
		return (distance / getDuration()) * 9000;
	}
	@Override // Compare to sort by date
	public int compareTo(Exercise otherExercise) {
		return this.getDate().compareTo(otherExercise.getDate());
	}
}
