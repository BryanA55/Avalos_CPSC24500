//Bryan Avalos, CPSC 24500
//September 15, 2023
//Determine the amount of paint and primer needed as well as the total cost

public class ApartmentPainter {
	
//Declare variables	
	public static void main(String[] args) {
		double lengthToCeiling = 10.0;
		double longWall = 32.75;
		double narrowWall = 25.62;
		double windowWidth = 14.4;
		double windowHeight = 5.5;
		double doorWidth = 3.25;
		double doorHeight = 8.0;
		double paintCoverage = 400.0;
		double paintCost = 34.99;
		double primerCoverage = 300;
		double primerCost = 24.49;
		double apartmentUnits = 8.0;
		
//Calculation of area needed to be primed and painted
		double ceilingAreaPerUnit = longWall * narrowWall;
		double windowSize = windowWidth * windowHeight;
		double doorSize = doorHeight * doorWidth;
		double longWallsArea = (longWall * lengthToCeiling) * 2;
		double narrowWallsArea = (narrowWall * lengthToCeiling) * 2;
		double wallAreaPerUnit = (longWallsArea + narrowWallsArea) - windowSize - doorSize;
		double totalArea = (ceilingAreaPerUnit + wallAreaPerUnit) * apartmentUnits;
		
//Calculation of gallons needed and cost
		double gallonsOfPaint = Math.ceil(totalArea / paintCoverage);
		double gallonsOfPrimer = Math.ceil(totalArea / primerCoverage);
		double totalCostOfPaint = (paintCost * gallonsOfPaint);
		double totalCostOfPrimer = (primerCost * gallonsOfPrimer);
		double totalCost = totalCostOfPaint + totalCostOfPrimer;

//Output results
		System.out.println("**********************************************************");
		System.out.printf("%-40s%10.2f\n","Wall area per unit",wallAreaPerUnit);
		System.out.printf("%-40s%10.2f\n","Ceiling area per unit",ceilingAreaPerUnit);
		System.out.printf("%-40s%10.2f\n","Total area to paint and prime",totalArea);
		System.out.println();
		System.out.printf("You must purchase %.0f gallons of paint for $%.2f.",gallonsOfPaint,totalCostOfPaint);
		System.out.println();
		System.out.printf("You must purchase %.0f gallons of primer for $%.2f.",gallonsOfPrimer,totalCostOfPrimer);
		System.out.println();
		System.out.println();
		System.out.printf("Your total cost to paint and prime all units is $%.2f.",totalCost);
		System.out.println();
		System.out.println("**********************************************************");
		
	}
	
}