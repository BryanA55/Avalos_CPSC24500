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
	// Defining what rock climbing is
	public RockClimbing() {
		super();
	}
	public RockClimbing(String type, String name, String date, int duration, double wallHeight, double timesClimbed, String comment) {
		super(name, date, duration, comment);
		setTimesClimbed(timesClimbed);
		setDuration(duration);
		setWallHeight(wallHeight);
	}
	@Override
	public String getType() {
		return "rock climbing";
	}
	public String getName() {
		return name;
	}
	@Override
	public double getCaloriesBurned() {
		return ((wallHeight * timesClimbed) / getDuration()) * 100;
	}
	@Override // Compare dates for sorting
	public int compareTo(Exercise otherExercise) {
		return this.getDate().compareTo(otherExercise.getDate());
	}
}
