package string_Handling;

import java.util.Arrays;
import java.util.Scanner;

public class Anagam {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a first string: ");
        String str1 = scanner.nextLine();      //input string 1
	    System.out.print("Enter a second string: ");
        String str2 = scanner.nextLine();      //input string 2
	    str1 = str1.toLowerCase();             //converting strings to lower case
	    str2 = str2.toLowerCase();

	    if(str1.length() == str2.length())     //Comparing length  of the both strings. if length are same .
	    {

	      char[] charArray1 = str1.toCharArray(); // converting string into array
	      char[] charArray2 = str2.toCharArray();

	      Arrays.sort(charArray1);                // sorting the array
	      Arrays.sort(charArray2);

	      boolean Array_Comp = Arrays.equals(charArray1, charArray2);  // Comparing both the arrays

	      if(Array_Comp) {                                             // if arrays are equal 
	        System.out.println("First and second stings are anagram.");
	      }
	      else {                                                       // if arrays are not equal 
	        System.out.println("First and second stings are not anagram.");
	      }
	    }
	    else {                                                         // if length of strings are not same 
	      System.out.println("First and second stings are not anagram.");
	    }
	  }
	
	}


