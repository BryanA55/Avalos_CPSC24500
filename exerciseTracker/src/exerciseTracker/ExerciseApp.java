/* Bryan Avalos, CPSC 24500
 * Exercise tracker assignment
 * The purpose of this program is to input exercises to be kept track of
 */

package exerciseTracker;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.text.ParseException;

public class ExerciseApp {
	/**
	 * Prints the welcome banner
	 */
	public static void printWelcome() {
		System.out.println("*".repeat(79));
		System.out.println("                              EXERCISE TRACKER V1.0               ");
		System.out.println("*".repeat(79));
	}
	/**
	 * Repeatedly shows the menu options until user decides to quit
	 */
	public static void printMenu() {
		System.out.println();
		System.out.println("These are your choices:");
		System.out.println("1. Add an exercise");
		System.out.println("2. Print exercises to file");
		System.out.println("3. List sorted by date");
		System.out.println("4. List sorted by calories burned");
		System.out.println("5. Exit");
		System.out.print("Enter the number of your choice: ");
	}
	/**
	 * Exercise application that stores different kinds of exercises and sorts them based on date or calories burned
	 * @param args The command line arguments
	 */
	public static void main(String[] args) {
		// Declare necessary variables
		Scanner sc = new Scanner(System.in);
		int menuChoice = 0;
		String type, fname, comment;
		Date date;
		ArrayList<Exercise> exerciseList = new ArrayList<>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		printWelcome();
		
		do {
			try {
				printMenu();
				menuChoice = sc.nextInt();
				
				// If else for the menu options
				if (menuChoice == 1) {
					while (true) { // Ask for the type of workout
					System.out.println("Describe your workout:");
					System.out.print("Enter R for run/walk, W for weightlifting, or C for rock climbing: ");
					type = sc.next().trim().toUpperCase();
					
						// Handles if the type is input incorrectly
						if (type.equals("R") || (type.equals("W") || (type.equals("C")))) {
							break;
						} else {
								System.out.println("Please enter a valid workout");
								sc.nextLine();
						}
					}		
					
					System.out.print("Enter a name for the workout: "); // Ask for name of workout
					sc.nextLine();
					String name = sc.nextLine();
					
					while (true) { // Ask for date of workout
					System.out.print("Enter date of workout: ");
					String dateInput = sc.nextLine().trim();
								
						try {
							date = dateFormat.parse(dateInput);
							break;
							} catch (ParseException ex) { // Handles exception if date is input incorrectly
								System.out.println("Please enter the date correctly, in MM/dd/yyyy format.");
							}
					}
					String dateAsString = dateFormat.format(date);
					
					System.out.print("How long did you work out in minutes?: "); // Ask for duration of workout	
					int duration = sc.nextInt();
					
					// If else for the type of workout
					if (type.equals("R")) { // adds a run/walk workout
						
						System.out.print("Enter distance you ran or walked in miles: ");
						double distance = sc.nextDouble();
						System.out.print("Enter a comment about the workout: ");
						sc.nextLine();
						comment = sc.nextLine();
						RunWalk runWalk = new RunWalk(type, name, dateAsString, duration, distance, comment);
						exerciseList.add(runWalk);
						
					} else if (type.equals("W")) { // Adds a weight lifting workout
						
						System.out.print("Enter total weight lifted in pounds: ");
						double weightLifted = sc.nextDouble();
						System.out.print("Enter a comment about the workout: ");
						sc.nextLine();
						comment = sc.nextLine();
						WeightLifting weightLifting = new WeightLifting(type, name, dateAsString, duration, weightLifted, comment);
						exerciseList.add(weightLifting);
						
					} else if (type.equals("C")) { // Adds a rock climbing workout
						
						System.out.print("Enter the height of the wall in feet: ");
						double wallHeight = sc.nextDouble();
						System.out.print("Enter number of times you climbed it: ");
						double timesClimbed = sc.nextDouble();
						System.out.print("Enter a comment about the workout: ");
						sc.nextLine();
						comment = sc.nextLine();
						RockClimbing rockClimbing = new RockClimbing(type, name, dateAsString, duration, wallHeight, timesClimbed, comment);
						exerciseList.add(rockClimbing);
						
					}		
				} else if (menuChoice == 2) { // Writes the workout list to a text file
					
					System.out.print("Enter the name of the file to save: ");
					sc.nextLine();
					fname = sc.nextLine();			
						try {
							ExerciseWriter.writeExercisesToFile(exerciseList, fname);
							System.out.println("Your exercises were written to a file.");
							} catch (Exception ex) {
								System.out.println("There was an error saving the exercises");
							}
						
				} else if (menuChoice == 3) { // Sorts the workout list by date
					
				Collections.sort(exerciseList);
				ExerciseWriter.tabulateSummary(exerciseList);
				
				} else if (menuChoice == 4) { // Sorts the workout list by calories burned
					
				ExerciseCompareByCalories caloriesComparator = new ExerciseCompareByCalories();
				Collections.sort(exerciseList, caloriesComparator);
				ExerciseWriter.tabulateSummary(exerciseList);
				
				} else if (menuChoice == 5) {
				} else { // Handles incorrectly entered number
				}
					// Handles when an integer is not entered for menu options
					} catch (InputMismatchException ex) { 
						System.out.println("You need to enter an integer. Try again.");
						sc.nextLine();
						menuChoice = 0;
					}			
				} while (menuChoice != 5); // Program is terminated
					System.out.println("Congratulations on staying in shape!");
					sc.close();		
	}
}