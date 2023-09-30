/* Bryan Avalos, CPSC 24500
 * October 2, 2023
 * The purpose of this program is to determine the area and perimeter of different shapes.
 */

import java.util.Scanner;
public class ShapeCalculator2 {
//Welcome banner
	public static void printWelcome() {
		System.out.println("*****************************************************************");
		System.out.printf("%39s\n","SHAPE CALCULATOR");
		System.out.println("*****************************************************************");
		System.out.println();
		}
//Functions for calculating area and perimeter of shapes
	
		public static double getAreaOfCricle(double radius) {
			double areaOfCircle = Math.PI * radius * radius;
			return areaOfCircle;
		}
		public static double getCircumference(double radius) {
			double circumference = Math.PI*2*radius;
			return circumference;
		}
		public static double getAreaOfRectangle(double length, double width) {
			double areaOfRectangle = length * width;
			return areaOfRectangle;
		}
		public static double getPerimeterOfRectangle(double length, double width) {
			double perimeterOfRectangle = (length * 2) + (width * 2);
			return perimeterOfRectangle;
		}
		public static double getPerimeterOfTriangle(double length1, double length2, double length3) {
			double perimeterOfTriangle = length1 + length2 + length3;
			return perimeterOfTriangle;
		}
		public static double getAreaOfTriangle(double length1, double length2, double length3) {
			double semiP = getPerimeterOfTriangle(length1,  length2, length3) / 2;
			double areaOfTriangle = Math.sqrt(semiP * (semiP - length1) * (semiP - length2) * (semiP - length3));
			return areaOfTriangle;
		}
//Determine user input, calculate shapes, and if program ends.
		
	public static void main(String[] args) {
		printWelcome();
		Scanner scan = new Scanner(System.in);
		String shape;
		do {
			System.out.print("Enter C for circle, R for rectangle, or T for triangle: ");
			shape = scan.next().trim().toUpperCase();
		if (shape.equals("C")) {
			System.out.print("Enter the radius: ");
			double circleRadius = scan.nextDouble();
			double circleArea = getAreaOfCricle(circleRadius);
			double circleCircumference = getCircumference(circleRadius);
			System.out.printf("The area of the circle is %.2f, and the circumference is %.2f. \n",circleArea,circleCircumference);
		} else if (shape.equals("R")) {
			System.out.print("Enter the length and width: ");
			double lengthRectangle = scan.nextDouble();
			double widthRectangle = scan.nextDouble();
			double rectangleArea = getAreaOfRectangle(lengthRectangle, widthRectangle);
			double rectanglePerimeter = getPerimeterOfRectangle(lengthRectangle, widthRectangle);
			System.out.printf("The area of the rectangle is %.2f, and the perimeter is %.2f. \n",rectangleArea,rectanglePerimeter);
		} else if (shape.equals("T")) {
			System.out.print("Enter the lengths of the three sides: ");
			double lengthT1 = scan.nextDouble();
			double lengthT2 = scan.nextDouble();
			double lengthT3 = scan.nextDouble();
			double triangleArea = getAreaOfTriangle(lengthT1, lengthT2, lengthT3);
			double trianglePerimeter = getPerimeterOfTriangle(lengthT1, lengthT2, lengthT3);
			System.out.printf("The area of the triangle is %.2f, and the perimeter is %.2f. \n",triangleArea,trianglePerimeter);
		} else if (shape.equals("Q")) {
		} else if ((!shape.equals("C")) || (!shape.equals("R")) || (!shape.equals("T")) || (!shape.equals("Q"))) {
			System.out.println("That is not a recognized shape.");
		}
	} while (!shape.equals("Q"));
		System.out.println("Thank you for using Shape Calculator!"); 
		scan.close();
	}
}

