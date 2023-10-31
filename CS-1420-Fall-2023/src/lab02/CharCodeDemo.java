package lab02;

import java.util.Scanner;

/**
 * For exploring the char type.
 * @author Jorden Dickerson
 * @version Aug 29, 2023
 */
public class CharCodeDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Type something and press enter.");
        
        String line = input.nextLine();
        char firstLetter = line.charAt(0);
      
        System.out.println(firstLetter + " has code " + (int)firstLetter);
        
        char[] lineChars = line.toCharArray();
        
        //Initialise shift value
        int shift = 2;
        
        for (int i = 0; i < lineChars.length; i++)
        {
        	//shift character
        	lineChars[i] = (char)(lineChars[i] + shift);
        	
        	//if character is out of range, loop back to 32
        	if (lineChars[i] > 126) {
        		lineChars[i] = (char)(31 + (lineChars[i] - 126));
        	}
        }
        
        
        for (int i = 0; i < 50; i++) {
        	int X = i;
            int Y = (X % 22) + 10;
            
            System.out.println(Y);
        }
        System.out.println(String.valueOf(lineChars));
    }
}