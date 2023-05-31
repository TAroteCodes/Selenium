package string_Handling;

import java.util.HashSet;
import java.util.Scanner;

public class RepeatedCharacter {
	public static char findFirstRepeatedCharacter(String str) {
        HashSet<Character> set = new HashSet<>();

        for (char ch : str.toCharArray()) {
            if (set.contains(ch)) {
                return ch;
            }
            set.add(ch);
        }

        return '\0';                             // Return null character if no repeated character is found
	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();      //input string
        char firstRepeatedChar = findFirstRepeatedCharacter(str);

        if (firstRepeatedChar != '\0') {
            System.out.println("First repeated character: " + firstRepeatedChar);
        } else {
            System.out.println("No repeated character found.");
        }
		

	}

}
