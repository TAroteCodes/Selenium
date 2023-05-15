// Find the fibonacci series up to a given number
package numbers;

import java.util.Scanner;

public class Fibonacci_Series {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
	    System.out.print("Enter a number: ");
	    int n = scanner.nextInt();                                  //input Number
		int firstTerm = 0;                                          //Initializing first term
		int secondTerm = 1;                                         //initializing second term
	    System.out.println("Fibonacci Series till given number:");
	   
	    for (int i = 1; i <= n; ++i) {
	      System.out.print(firstTerm + ", ");

	      
	      int nextTerm = firstTerm + secondTerm;                   // addition of first and second term
	      firstTerm = secondTerm;                                  //update first term
	      
	      
	      if (secondTerm > n)                                      
	      {
	          break;                                               // break the loop when series reached till given no.
	      }
	      else 
	      {
	    	  secondTerm = nextTerm;                               // update second term
	      } 
	    }

	}

}
