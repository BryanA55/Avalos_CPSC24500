package emailerAssignment;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmailApp {
	public static void printWelcome() {
		System.out.println("*".repeat(78));
		System.out.println("                            Emailer Version 1.0              ");
		System.out.println("*".repeat(78));
		System.out.println();
	}
	public static void printMenu() {
		System.out.println("Here are your choices:");
		System.out.println("1. Write email");
		System.out.println("2. List emails");
		System.out.println("3. Send emails");
		System.out.println("4. Save emails to file");
		System.out.println("5. Exit");
		System.out.print("Enter the number of your choice: ");
	}	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		printWelcome();
		int menuChoice = 0;
		ArrayList<Email> emailList = new ArrayList<>(); 
		do {
			try {
				printMenu();
				menuChoice = sc.nextInt();
			
				if (menuChoice == 1) {
					System.out.print("Enter recipients' email: ");
					sc.nextLine();
					String recipients = sc.nextLine();
					String[] recipientArray = recipients.split(",");
					
					System.out.print("Enter subject: ");
					String subject = sc.nextLine();
					
					System.out.print("Enter body: ");
					String body = sc.nextLine();
					System.out.println();
					
					Email email = new Email(recipientArray,subject,body);
					emailList.add(email);
				
				} else if (menuChoice == 2) {
					System.out.println("Here are your emails:");
					System.out.println();
					EmailPrinter.printEmailsToScreen(emailList);
				
				} else if (menuChoice == 3) {
					Email.send();
					System.out.println("All emails have been sent.");
					System.out.println();
				
				} else if (menuChoice == 4) {
					// Save emails to file
				
				} else if (menuChoice == 5) {
					//nothing
				} else {
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
				System.out.println();
				System.out.println("Thank you for using this program.");
				sc.close();
	}
}
