// Find the frequency/number of occurrences of each character in a string using a Map
package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FrequencyOfTheCharacterUsingMap {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();                             //input string
        Map<Character, Integer> charFrequencies = new HashMap<>();  // Create a Map to store character frequencies
        for (char c : str.toCharArray())                           // Iterate through each character in the string
        {                     
            if (charFrequencies.containsKey(c))                  // If the character is already present in the map, increment its count
            {
                charFrequencies.put(c, charFrequencies.get(c) + 1);
            }
            else 
            {
                charFrequencies.put(c, 1);                          // Otherwise, add the character to the map with a count of 1
            }
        }
        for (Map.Entry<Character, Integer> entry : charFrequencies.entrySet()) {
            System.out.println("'" + entry.getKey() + "' occurs " + entry.getValue() + " time(s)");
        }

	}

}
