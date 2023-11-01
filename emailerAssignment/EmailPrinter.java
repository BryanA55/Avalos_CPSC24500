package emailerAssignment;

import java.util.ArrayList;
import java.io.*;

public class EmailPrinter {
	/**
	 * Prints the emails to the screen in a formatted way when called
	 * @param emails
	 */
	public static void printEmailsToScreen(ArrayList<Email> emails) {
		for (Email email : emails) {
			System.out.println(email.toString());
		}
	}
	/**
	 * Writes the emails to a file when called
	 * @param emails the emails to be saved to a file
	 * @param fname the file name the emails are saved to
	 * @return true if successful, false if failure to save emails
	 */
	public static boolean writeEmailToFile(ArrayList<Email> emails, String fname) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(fname))));
			for(Email email : emails) {
				pw.println(email.fileFriendlyEmail());
			}
			pw.close();
			return true;
		} catch (Exception ex) { // Handles exceptions if saving emails fails
			return false;
		}
	}
}