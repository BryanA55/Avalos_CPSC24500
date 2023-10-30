package emailerAssignment;

import java.util.ArrayList;
import java.io.*;

public class EmailPrinter {
	public static void printEmailsToScreen(ArrayList<Email> emails) {
		for (Email email : emails) {
			System.out.println(email.toString());
		}
	}
	public static boolean writeEmailToFile(ArrayList<Email> emails, String fname) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(fname))));
			for(Email email : emails) {
				pw.println(email);
			}
			pw.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
}