// Find whether a number is prime or not

package numbers;

import java.util.Scanner;

public class Prime_no {

	public static void main(String[] args) {
		   int a,b;
		   @SuppressWarnings("resource")
		   Scanner scanner = new Scanner(System.in);
	       System.out.print("Enter a number: ");
	       a = scanner.nextInt();      //input Number
			
	        boolean P = true;          // p variable with true 

	        for (b = 2; b <= Math.sqrt(a); b++) {     //starting loop from 2 goes till square root of the given no.
	            if (a % b == 0) {                     //checking modulus is equal to 0 or not.
	                P = false;                        // in any case modulus is equal to 0. then p will be false 
	                break;                            // for breaking (stopping the loop)
	            }
	        }

	        if (P) {                                  
	            System.out.println(a + " is a prime number.");       // if p is true.
	        } else { 
	            System.out.println(a + " is not a prime number.");   // if p is false.
	        }
	    }

	}
