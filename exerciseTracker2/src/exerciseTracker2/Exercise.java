package exerciseTracker2;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Exercise implements Comparable<Exercise> {
	// Declare necessary variables
	private String name;
	private String comment;
	private int duration; 
	private Date date;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	
	// Defining what an exercise is
	public Exercise() {
		this("Name", new Date(), 0 , "Comment");
	}
	public Exercise(String na, Date da, int du, String co) {
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getFormattedDate() {
		return dateFormat.format(date);
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
	
	/**
	 * Compares the exercises so they can be sorted by date
	 * @param otherExercise the exercises
	 * @return the exercise list sorted by date
	 */
	public int compare(Exercise otherExercise) { 
		return this.date.compareTo(otherExercise.date);
	}
	/**
	 * Formats the exercise list as a table by the type, name, date, and calories burned
	 * @return String.format the formatted exercise list as a table
	 */
	public String toString() { // String for printing exercises
		return String.format("%-15s%-25s%-20s%-15.2f",name,getType(),getFormattedDate(),getCaloriesBurned());
	}
	/**
	 * Formats that exercise list into a tab-deliminted string for a text file
	 * @return String.format the formatted exercise list
	 */
	public String fileFriendlyExerciseList() { // tab-delimited string for files
		return String.format("%s\t%s\t%s\t%.2f",name,getType(),getFormattedDate(),getCaloriesBurned());
	}
}
