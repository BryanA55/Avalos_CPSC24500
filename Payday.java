//Bryan Avalos, CPSC 24500
//September 22, 2023
//The purpose of this program is to calculate and print a user's paycheck.

import java.util.Scanner;
import java.util.Random;
public class Payday {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
// Implement incident pay
		double minIncident = -200;
		double maxIncident = 200;
		double random = new Random().nextDouble();
		double incidentPay = minIncident + (random *(maxIncident - minIncident));
		
// Welcome Banner and setup of union variables		
		System.out.println("**************************************************");
		System.out.printf("%30s\n","Payday V1.0");
		System.out.println("**************************************************");
		double union = 0.05;
		double unionDues;
		
// Request user input to calculate paycheck
		System.out.println();
		System.out.print("Enter name: ");
		String fullName = scan.nextLine();
		System.out.print("Enter hours worked: ");
		double hoursWorked = scan.nextDouble();
		System.out.print("Enter hourly pay rate: ");
		double payRate = scan.nextDouble();
		double grossPay = hoursWorked * payRate;
		System.out.print("Are you a union member (y or n)?" );
		String unionMember = scan.next().trim().toLowerCase();
		if (unionMember.equals("y")) {
			unionDues = grossPay * union;
		} else unionDues = 0;
		System.out.print("What percentage do you want to withould for your medical savings account?");
		double medSavingsPercent = scan.nextDouble();
		double medDeduction = (grossPay * (medSavingsPercent/100));
		
// Calculate taxes and net pay
		double taxes = 0;
		double incidentPayForTax = Math.abs(incidentPay);
		double grossBeforeTaxes = grossPay - unionDues - medDeduction - incidentPayForTax;
		if (grossBeforeTaxes >= 2500) { 
			taxes = 0.25;
		} else if (grossBeforeTaxes >= 1500) {
			taxes = 0.15;
		} else if (grossBeforeTaxes >= 500) {
			taxes = 0.10;
		} else if (grossBeforeTaxes < 500) {
			taxes = 0.05;
		}
		
		double taxAmount = (grossPay - medDeduction - unionDues - incidentPayForTax) * taxes;
		double netPay = grossBeforeTaxes - taxAmount;
		
// Print results		
		System.out.println();
		System.out.println("---------PAYCHECK---------");
		System.out.printf("%-15s%s%8.2f\n","Gross Pay","$",grossPay);
		System.out.printf("%-15s%s%8.2f\n","Union Dues","$",unionDues);
		System.out.printf("%-15s%s%8.2f\n","Med Deduction","$",medDeduction);
		System.out.printf("%-15s%s%8.2f\n","Incident Pay","$",incidentPay);
		System.out.printf("%-15s%s%8.2f\n","Taxes","$",taxAmount);
		System.out.printf("%-15s%s%8.2f\n","Net Pay","$",netPay);
		System.out.println("---------------------------");
		System.out.println("Prepared for " + fullName);
		System.out.println();
		System.out.println();
		System.out.println("Thank you for using this program.");
		scan.close();
	}
}
