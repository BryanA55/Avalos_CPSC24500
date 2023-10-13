
import java.util.Scanner;
import java.io.*;
public class TextAnalyzer {
public static void printWelcome() {
	/**
	 * Prints welcome banner 
	 */
	System.out.println("*******************************************************************************");
	System.out.printf("%50s\n","Welcome to TextAnalyzer V1.0");
	System.out.println("*******************************************************************************");
	System.out.println();
	System.out.print("What text file would you like to analyze? ");
}
public static void printMenu() {
	/**
	 * Prints menu options
	 */
	System.out.println();
	System.out.println("Here are your options:");
	System.out.println("1. Count the number of vowels.");
	System.out.println("2. Count the number of consonants.");
	System.out.println("3. Count the number of words.");
	System.out.println("4. Print a summary to a file.");
	System.out.println("5. Quit");
	System.out.print("Enter the number of your choice: ");
}
public static double countVowels (String fileToAnalyze) {
	/**
	 * Computes the amount of vowels
	 * @param fileToAnalyze This is the file that needs to analyzed
	 * @param vowels Contains the string that is to be analyzed
	 * @return count The total amount of vowels in the string
	 */
	String vowels = fileToAnalyze;
	vowels = vowels.toLowerCase();
	int count = 0;
	for(int i=0; i<vowels.length(); i++) {
		if (vowels.charAt(i) == 'a' || vowels.charAt(i) == 'e'
              || vowels.charAt(i) == 'i'
              || vowels.charAt(i) == 'o'
              || vowels.charAt(i) == 'u') {
				count++;
			}		
	}	
	return count;
}
public static double countConsonants (String fileToAnalyze) {
	/**
	 * Computes the number of consonants
	 * @param fileToAnalyze The file that needs to be analyzed
	 * @param consonants Contains the string from the file needing to be analyzed
	 * @return count The total number of consonants in the string
	 */
	String consonants = fileToAnalyze;
	consonants = consonants.toLowerCase();
	int count = 0;
	for(int i=0; i<consonants.length(); i++) {
		char character = consonants.charAt(i);
		if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u') {
			System.out.print("");
		}else if (character  != ' ') {
			count ++;
		}
	}
	return count;
}
public static double countWords (String fileToAnalyze) {
	/**
	 * Computes the amount of words
	 * @param fileToAnalyze The file converted to a string to be analyzed
	 * @param words Contains the string that is going to be analyzed
	 * @return count The total amount of words in the string.
	 */
	String words = fileToAnalyze;
	words = words.toLowerCase();
	int count = words.split("\\s").length;
	return count;
}
public static void writeSummaryToFile (String fileToAnalyze, String nameOfSummaryFile) {
	/**
	 * 
	 */
	String line;
	try {
		Scanner fsc = new Scanner(new File(nameOfSummaryFile));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(nameOfSummaryFile))));
		while(fsc.hasNextLine()){
			line = fsc.nextLine();
			pw.println("This is the text:");
			pw.println(line);
			pw.println();
			pw.printf("There are %.0f vowels, %.0f consonants, and %.0f words.", countVowels(fileToAnalyze), countConsonants(fileToAnalyze), countWords(fileToAnalyze));
		}
		fsc.close();
		pw.close();
		System.out.println("The summary was written to a file");
	}catch (Exception ex) {
		System.out.println("A file error as occurred.");
	}
}
public static String readFile(String fileName) {
	/**
	 * Reads the text file and returns it as a string
	 * @param line Scans to see if there is another line of text available to read
	 * @return allTogether String that contains the text from the file
	 */
	try {
		String allTogether = "";
		Scanner fileScan = new Scanner(new File(fileName));
		String line;
		while(fileScan.hasNextLine()) {
			line = fileScan.nextLine();
			allTogether = allTogether + line + " ";
		}
		return allTogether;
	} catch (Exception ex) {
		return null;
	}
}
public static void main (String[] args) {
	Scanner scan = new Scanner(System.in);
	String fileChoice, nameOfSummaryFile;
	printWelcome();
	fileChoice = scan.nextLine();
	String fileToAnalyze = readFile(fileChoice);
	int optionChoice = 0;
	double vowelCount, consonantCount, wordCount;
	boolean proceed;
	do {
		proceed = true;
		printMenu();
		try {
			optionChoice = scan.nextInt();
		} catch (Exception ex) {
			System.out.print("You have to enter the number of your choice. You didn't type a number.");
			scan.nextLine();
			proceed = false;
		}
	if (optionChoice == 1) {
		vowelCount = countVowels(fileToAnalyze);
		System.out.printf("There are %.0f vowels.", vowelCount);
		}
	if (optionChoice == 2) {
		consonantCount = countConsonants(fileToAnalyze);
		System.out.printf("There are $.0f consonants.", consonantCount);
		}
	if (optionChoice == 3) {
		wordCount = countWords(fileToAnalyze);
		System.out.printf("There are %.0f words.", wordCount);
		}
	if (optionChoice == 4) {
		System.out.print("Enter the name of the file to write the summary: ");
		nameOfSummaryFile = scan.nextLine();
		writeSummaryToFile(fileToAnalyze, nameOfSummaryFile);
		}
	if (optionChoice > 5) {
		System.out.println("That is not a valid choice.");
		}
		} while (optionChoice != 5);
			System.out.println();
			System.out.println("Thank you for using this program.");
	}
}
