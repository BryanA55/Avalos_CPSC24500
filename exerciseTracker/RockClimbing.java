package exerciseTracker;

public class RockClimbing extends Exercise {
	private double wallHeight;
	private double timesClimbed;
	private String name;
	
	public double getWallHeight() {
		return wallHeight;
	}
	public void setWallHeight(double wallHeight) {
		this.wallHeight = wallHeight;
	}
	public double getTimesClimbed() {
		return timesClimbed;
	}
	public void setTimesClimbed(double timesClimbed) {
		this.timesClimbed = timesClimbed;
	}
	public RockClimbing() {
		super();
	}
	public RockClimbing(String name, String date, int duration, double wallHeight, double timesClimbed, String comment) {
		super(name, date, duration, comment);
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public double getCaloriesBurned() {
		caloriesBurned = ((wallHeight * timesClimbed) / getDuration()) * 100;
		return caloriesBurned;
	}
	@Override
	public double calculateCalories() {
		return getCaloriesBurned();
	}
}
