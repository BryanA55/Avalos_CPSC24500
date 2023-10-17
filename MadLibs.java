/* Bryan Avalos, CPSC 24500
 * Madlibs assignment
 * The purpose of this program is a madlib game
 */

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.io.File;

public class MadLibs {
	private static ArrayList<String> singNouns, pluNouns, singVerbs, pluVerbs, adjs, advs, pastVerbs;
	private Random rnd;
	
	public static void createWordLists(String folder) {
		singNouns = new ArrayList<String>();
		pluNouns = new ArrayList<String>();
		singVerbs = new ArrayList<String>();
		pluVerbs = new ArrayList<String>();
		adjs = new ArrayList<String>();
		pastVerbs = new ArrayList<String>();
	}
	public static boolean loadWordLists(String folder) {
		String line;
		try {
			Scanner fsc;
			fsc = new Scanner(new File(folder,"singnoun.txt"));
			while(fsc.hasNextLine()) {
				line = fsc.nextLine();	}
			
			return true;
		} catch (Exception ex) {
				return false;
			}
		}
	public static void printWelcome() {
	/**
	* Prints the welcome banner for the game
	*/
		System.out.println("*****************************************************************");
		System.out.println("*                        Welcome to Madlibs V1.0                *");
		System.out.println("*****************************************************************");
		System.out.println();
		System.out.println("This program generates random stories using wordlists you supply.");
		System.out.println();
	}
		
		
		
		
		
		
		
		
		
		
		
public static void main(String[] args) {
	
	Scanner scan = new Scanner(System.in);
	printWelcome();
	System.out.println("Enter the name of the folder where the stories and wordlists are.");
	System.out.print("Or just press Enter to accept the default location: ");
	
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
