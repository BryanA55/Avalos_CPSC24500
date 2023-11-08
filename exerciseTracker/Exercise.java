package exerciseTracker;

public abstract class Exercise {
	private String name;
	private String comment;
	private int duration; 
	private String date;
	protected double caloriesBurned;
	
	public Exercise() {
		this("Name", "Date" , 0 ,"Comment");
	}
	public Exercise(String na, String da, int du, String co) {
		setName(na);
		setDate(da);
		setDuration(du);
		setComment(co);
	}
	public abstract String getType();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment){
		this.comment = comment;
	}
		
	public abstract double getCaloriesBurned();

	public abstract double calculateCalories();
	
	public String toString() {
		return String.format(name + " " + comment + " " + duration + " " + date + " " + getCaloriesBurned());
	}		
}
