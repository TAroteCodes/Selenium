// Find whether a string is palindrome or not.

package string_Handling;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();      //input string
        String Rev_str = "";                  // empty string initialize
        for (int i = str.length()-1;i>=0;i--) // For loop starting from end
        {
        	Rev_str = Rev_str + str.charAt(i);         // appending characters to reverse string one by one
        }

        System.out.println("\n"+Rev_str);          // printing reverse string for reference
        if (str.equalsIgnoreCase(Rev_str))    // Comparing Actual string with reverse string 
        {
        	System.out.println("\nGiven String is Palindrome.");
        }
        else 
        {
        	System.out.println("\nGiven String is not Palindrome.");
        }
	}

}
