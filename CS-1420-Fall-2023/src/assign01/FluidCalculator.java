//CS1420 Assignment 1 Fluid Calculator by Jorden Dickerson 08-25-2023

package assign01;

public class FluidCalculator {

	public static void main(String[] args) {
		//initiate uid and ounces
		int uid = 1485188;
		int oz = uid;
		//find the amount of gallons, multiply that number by 128 to find the ounces, and subtract the ounces from the uid to find the starting point for the next equaiton.
		int gallon = uid / 128;
		oz = gallon * 128;
		oz = uid - oz;
		//same process as gallons
		int quart = oz / 32;
		int quartoz = quart * 32;
		oz -= quartoz;
		//same process as quarts
		int cup = oz / 8;
		int cupoz = cup * 8;
		oz -= cupoz;
		
		
		//print out final answer
		System.out.println(uid + " fluid ounces is equivalent to " + gallon + " gallon(s), " + quart + " quart(s), " + cup + " cup(s), and " + oz + " ounce(s).");

	}

}
