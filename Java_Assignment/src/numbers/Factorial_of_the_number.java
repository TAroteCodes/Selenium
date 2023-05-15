// Find the factorial of a number

package numbers;

import java.util.Scanner;

public class Factorial_of_the_number {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();      //input Number
        int fact = 1;                     //Initializing new variable with 1 
        for (int i=1;i<=num;i++)          //starting loop from 1 till number entered
        {
        	fact = fact*i;                //multiplying i with fact in every iteration
        }
            System.out.println(num + "! = " + fact);
	}

}
