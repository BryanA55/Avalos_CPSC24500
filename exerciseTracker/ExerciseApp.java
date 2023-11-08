package exerciseTracker;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;

public class ExerciseApp {
	public static void printWelcome() {
		System.out.println("*".repeat(79));
		System.out.println("                          EXERCISE TRACKER V1.0               ");
		System.out.println("*".repeat(79));
		System.out.println();
	}
	public static void printMenu() {
		System.out.println("These are your choices:");
		System.out.println("1. Add an exercise");
		System.out.println("2. Print exercises to file.");
		System.out.println("3. List sorted by date");
		System.out.println("4. List sorted by calories burned");
		System.out.println("5. Exit");
		System.out.print("Enter the number of your choice: ");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int menuChoice = 0;
		String workoutDesc;
		String comment = null;
		ArrayList<Exercise> exerciseList = new ArrayList<>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		printWelcome();
		
		do {
			try {
				printMenu();
				menuChoice = sc.nextInt();
				
			if (menuChoice == 1) {
				System.out.println("Describe your workout:");
				System.out.print("Enter R for run/walk, W for weightlifting, or C for rock climbing: ");
					workoutDesc = sc.next().trim().toUpperCase();					
					System.out.print("Enter a name for the workout: ");
					sc.nextLine();
					String name = sc.nextLine();
					System.out.print("Enter date of workout: ");
					String dateInput = sc.nextLine().trim();
					
					Date date = null;
					try {
						date = dateFormat.parse(dateInput);
					} catch (ParseException ex) {
						System.out.println("Please enter the date correctly, in MM/dd/yyyy format.");
						continue;
					}
					String dateAsString = dateFormat.format(date);
					
					System.out.print("How long did you work out in minutes?: ");	
					int duration = sc.nextInt();
					
					if (workoutDesc.equals("R")) {
						System.out.print("Enter distance you ran or walked in miles: ");
						double distance = sc.nextDouble();
						RunWalk runWalk = new RunWalk(name, dateAsString, duration, distance, comment);
						exerciseList.add(runWalk);
					} else if (workoutDesc.equals("W")) {
						System.out.print("Enter total weight lifted in pounds: ");
						double weightLifted = sc.nextDouble();
						WeightLifting weightLifting = new WeightLifting(name, dateAsString, duration, weightLifted, comment);
						exerciseList.add(weightLifting);
					} else if (workoutDesc.equals("C")) {
						System.out.print("Enter the height of the wall in feet: ");
						double wallHeight = sc.nextDouble();
						System.out.print("Enter number of times you climbed it: ");
						double timesClimbed = sc.nextDouble();
						RockClimbing rockClimbing = new RockClimbing(name, dateAsString, duration, wallHeight, timesClimbed, comment);
						exerciseList.add(rockClimbing);
					}

					System.out.print("Enter a comment about the workout: ");
					sc.nextLine();
					comment = sc.nextLine();
					
				
			} else if (menuChoice == 2) {
				// print to file
			    ExerciseWriter.printExercisesToScreen(exerciseList);
			} else if (menuChoice == 3) {
				// sort by date
			} else if (menuChoice == 4) {
				// sort by calories burned
			} else if (menuChoice == 5) {
				// nothing
			} else { // incorect number
				System.out.println();
				System.out.println("Please enter a valid choice (1 through 5). Choose again.");
			}
			
				

				
			} catch (InputMismatchException ex) {
				System.out.println();
				System.out.println("Please enter a valid choice (1 through 5). Choose again.");
				System.out.println();
				sc.nextLine();
				menuChoice = 0;
			}
			
			} while (menuChoice != 5);
				System.out.println("Thank you for using this program.");
	}		
}
