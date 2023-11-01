/* Bryan Avalos, CPSC 24500
 * Emailer assignment
 * The purpose of this program is a simple emailer application
 */

package emailerAssignment;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmailApp {
	/**
	 * Prints welcome banner for program
	 */
	public static void printWelcome() {
		// Welcome banner
		
		System.out.println("*".repeat(78));
		System.out.println("                            Emailer Version 1.0              ");
		System.out.println("*".repeat(78));
		System.out.println();
	}
	/**
	 * Prints menu options for user
	 */
	public static void printMenu() {
		// Prints menu options
		
		System.out.println("Here are your choices:");
		System.out.println("1. Write email");
		System.out.println("2. List emails");
		System.out.println("3. Send emails");
		System.out.println("4. Save emails to file");
		System.out.println("5. Exit");
		System.out.print("Enter the number of your choice: ");
	}	
	/**
	 * Simple email application that writes, lists, sends, and saves emails.
	 * @param args
	 */
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		printWelcome();
		int menuChoice = 0;
		String fileName;
		ArrayList<Email> emailList = new ArrayList<>(); 
		do {
			try {
				printMenu();
				menuChoice = sc.nextInt();
			
				if (menuChoice == 1) { // User chooses to write new email
					System.out.print("Enter recipients' email: ");
					sc.nextLine();
					String recipients = sc.nextLine().replaceAll(" ", ",");
					String[] recipientArray = recipients.split(",");
					
					System.out.print("Enter subject: ");
					String subject = sc.nextLine();
					
					System.out.print("Enter body: ");
					String body = sc.nextLine();
					System.out.println();
					
					Email email = new Email(recipientArray,subject,body);
					emailList.add(email);
				
				} else if (menuChoice == 2) { // User chooses to list emails
					System.out.println("Here are your emails:");
					System.out.println();
					EmailPrinter.printEmailsToScreen(emailList);
				
				} else if (menuChoice == 3) { // User chooses to send emails
					Email.send();
					System.out.println("All emails have been sent.");
					System.out.println();
				
				} else if (menuChoice == 4) { // User chooses to save emails to a file
					System.out.print("Enter the name of the file to save: ");
					sc.nextLine();
					fileName = sc.nextLine();		
					try{ 
						EmailPrinter.writeEmailToFile(emailList, fileName);
						System.out.println("Emails were saved successfully.");
						System.out.println();
					} catch (Exception ex ) { // Handles exceptions when saving the emails
						System.out.println("There was an error saving the emails.");
					}
				
				} else if (menuChoice == 5) {
					
				} else { // User chooses an incorrect number
					System.out.println();
					System.out.println("Please enter a valid choice (1 through 5). Choose again.");
				}
			} catch (InputMismatchException ex) { // User inputs a string rather than a number
				System.out.println();
				System.out.println("Please enter a valid choice (1 through 5). Choose again.");
				System.out.println();
				sc.nextLine();
				menuChoice = 0;
			}
			
			} while (menuChoice != 5); // User chooses to quite program
				System.out.println();
				System.out.println("Thank you for using this program.");
				sc.close();
	}
}
