/* Bryan Avalos, CPSC 24500
 * Madlibs assignment
 * The purpose of this program is a randomly generated madlib game based on word lists supplied
 */

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.io.File;

public class MadLibs {
	private static ArrayList<String> singNouns, pluNouns, singVerbs, pluVerbs, adjs, advs, pastVerbs, story1, story2;
	private static Random rnd;	
	/**
	 * Creates the arrays for the word lists
	 * @param folder
	 */
	public static void createWordLists(String folder) {
		// Creates new array lists for each text file		
		
		singNouns = new ArrayList<String>(); 
		pluNouns = new ArrayList<String>();
		singVerbs = new ArrayList<String>();
		pluVerbs = new ArrayList<String>();
		adjs = new ArrayList<String>();
		advs = new ArrayList<String>();
		pastVerbs = new ArrayList<String>();
		story1 = new ArrayList<String>();
		story2 = new ArrayList<String>();
	}
	/**
	 * Loads the word lists so they are available
	 * @param folder
	 * @return true if the word lists were successfully loaded
	 */
	public static boolean loadWordLists(String folder) {
		// Each word list from the text file is loaded here, converting them into strings
		
		String line;
		try {
			Scanner fsc;
			fsc = new Scanner(new File(folder,"singnoun.txt"));
			while(fsc.hasNextLine()) {
				line = fsc.nextLine();	
				singNouns.add(line);
			}
			fsc.close();
			fsc = new Scanner(new File(folder,"plunoun.txt"));
			while(fsc.hasNextLine()) {
				line = fsc.nextLine();
				pluNouns.add(line);
			}
			fsc.close();
			fsc = new Scanner(new File(folder,"singverb.txt"));
			while(fsc.hasNextLine()) {
				line = fsc.nextLine();
				singVerbs.add(line);
			}
			fsc.close();
			fsc = new Scanner(new File(folder,"pluverb.txt"));
			while(fsc.hasNextLine()) {
				line = fsc.nextLine();
				pluVerbs.add(line);
			}
			fsc.close();
			fsc = new Scanner(new File(folder,"adj.txt"));
			while(fsc.hasNextLine()) {
				line = fsc.nextLine();
				adjs.add(line);
			}
			fsc.close();
			fsc = new Scanner(new File(folder,"pastverb.txt"));
			while(fsc.hasNextLine()) {
				line = fsc.nextLine();
				pastVerbs.add(line);
			}
			fsc.close();
			fsc = new Scanner(new File(folder,"adv.txt"));
			while(fsc.hasNextLine()) {
				line = fsc.nextLine();	
				advs.add(line);
			}
			fsc.close();
			return true;
		} catch (Exception ex) { // Handles exceptions if the word lists could not be loaded
				return false;
			}
		}
	/**
	 * Converts the story into a string
	 * @param folder
	 * @param storyNum
	 * @return result if the story has been successfully read
	 */
	public static ArrayList<String> readStory(String folder, String storyNum){
		// Loads the stories and converts them into strings
		
		ArrayList<String> result = new ArrayList<String>();
		try {
			Scanner fsc = new Scanner(new File(folder, "story" + storyNum + ".txt"));
			while(fsc.hasNextLine()) {
			String line = fsc.nextLine();
			result.add(line);
			}
			fsc.close();
			return result;		
		} catch (Exception ex) { // Handles exceptions if the story could not be read
			return null; 
		}
	}
		/**
		 * Replaces the place holders of the story with randomly generated words from the word lists
		 * @param story
		 */	
		public static void tellStory(ArrayList<String> story) {
		    // Each while loop replaces the place holders with a randomly generated word from their respective word list
			
			ArrayList<String> words = new ArrayList<String>();

		    for (String line : story) {
		        String[] parts = line.split(" ");
		        for (String part : parts) {
		        	String wordsReplaced = part;
		        	while (wordsReplaced.indexOf("<singnoun>") >= 0) {
		                words.add(singNouns.get(rnd.nextInt(singNouns.size())));
		                wordsReplaced = wordsReplaced.replaceFirst("<singnoun>", singNouns.get(rnd.nextInt(singNouns.size())));
		        	}
		        	while (wordsReplaced.indexOf("<plunoun>") >= 0) {
		                words.add(pluNouns.get(rnd.nextInt(pluNouns.size())));
		                wordsReplaced = wordsReplaced.replaceFirst("<plunoun>", pluNouns.get(rnd.nextInt(pluNouns.size())));
		        	}
		        	while (wordsReplaced.indexOf("<singverb>") >= 0) {
		                words.add(singVerbs.get(rnd.nextInt(singVerbs.size())));
		                wordsReplaced = wordsReplaced.replaceFirst("<singverb>", singVerbs.get(rnd.nextInt(singVerbs.size())));
		        	}
		        	while (wordsReplaced.indexOf("<pluverb>") >= 0) {
		                words.add(pluVerbs.get(rnd.nextInt(pluVerbs.size())));
		                wordsReplaced = wordsReplaced.replaceFirst("<pluverb>", pluVerbs.get(rnd.nextInt(pluVerbs.size())));
		        	}
		        	while (wordsReplaced.indexOf("<adj>") >= 0) {
		                words.add(adjs.get(rnd.nextInt(adjs.size())));
		                wordsReplaced = wordsReplaced.replaceFirst("<adj>", adjs.get(rnd.nextInt(adjs.size())));
		        	}
		        	while (wordsReplaced.indexOf("<adv>") >= 0) {
		                words.add(advs.get(rnd.nextInt(advs.size())));
		                wordsReplaced = wordsReplaced.replaceFirst("<adv>", advs.get(rnd.nextInt(advs.size())));
		        	}
		        	while (wordsReplaced.indexOf("<pastverb>") >= 0) {
		                words.add(pastVerbs.get(rnd.nextInt(pastVerbs.size())));
		                wordsReplaced = wordsReplaced.replaceFirst("<pastverb>", pastVerbs.get(rnd.nextInt(pastVerbs.size())));
		        	}
		            System.out.print(wordsReplaced + " "); 
		        }
		        System.out.println();
		    }		    
		}
	/**
	 * Prints the welcome banner for the madlib game
	 */
	public static void printWelcome() {
		System.out.println("*****************************************************************");
		System.out.println("*                      Welcome to Madlibs V1.0                  *");
		System.out.println("*****************************************************************");
		System.out.println();
		System.out.println("This program generates random stories using wordlists you supply.");
		System.out.println();
	}
	/**
	 * Creates a madlib game using word lists that are chosen by the user.
	 * @param args
	 */
	public static void main(String[] args) {
		String wordList = ""; // Declare necessary variables
		String folderChoice;
		String storyNum = "";
		rnd = new Random();
		
		Scanner scan = new Scanner(System.in); // Create scanner and and request what folder user would like to use
		printWelcome();
		System.out.println("Enter the name of the folder where the stories and wordlists are.");
		System.out.print("Or just press Enter to accept the default location: ");
		folderChoice = scan.nextLine();
		
		createWordLists(wordList);
		if (!loadWordLists(folderChoice)) {
			System.out.println("There was an error."); // Displays error if the word lists are not within the folder chosen
		} else {		
		do {
			System.out.println();
			System.out.print("Enter a story number or q to quit: ");
			storyNum = scan.nextLine();
			ArrayList<String> story = readStory(folderChoice, storyNum);
		
			if (storyNum.equals("1")) { // User chooses story1
				story = readStory(folderChoice, storyNum);
				System.out.println();
				System.out.println("Here is your madlib:");
				System.out.println();
				tellStory(story);
			
			} else if (storyNum.equals("2")) { // User chooses story2
				story = readStory(folderChoice, storyNum);
				System.out.println();
				System.out.println("Here is your madlib:");
				System.out.println();
				tellStory(story);
			} else if (storyNum.toLowerCase().equals("q")) {
			
			} else { // Handles when the user chooses an incorrect story number
				System.out.println();
				System.out.println("That story does not exist. Choose again.");
			}
		} while (!storyNum.toLowerCase().equals("q")); // Quits the program
			System.out.println();
			System.out.println("Thank you for using this program.");
			scan.close();
		}
	}
}
