// Find the duplicate characters in a string using a Set
package collections;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FindDuplicatesUsingSets {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();                                 //input string
        Set<Character> duplicateCharacters = new HashSet<>();           // Create a Set to store duplicate characters
        Set<Character> singleCharacters = new HashSet<>();             // Create a Set to store single characters
        for (char c : str.toCharArray()) {                            // Iterate through each character in the string
            if (singleCharacters.contains(c))                        // If the character is already in the seenCharacters set,it is a duplicate and we add it to the duplicateCharacters set
            { 
                duplicateCharacters.add(c);
            } 
            else 
            {
                singleCharacters.add(c);                       // Otherwise, add the character to the seenCharacters set
            }
        }
        System.out.println("Duplicate characters in the string:");     
        for (char c : duplicateCharacters)                 // Print the duplicate characters
        {
            System.out.print(c + " ");
        }
	}
}
