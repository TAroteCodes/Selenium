// Find the smallest number in an array


package arrays;

import java.util.Arrays;

public class Smallest_number {

	public static void main(String[] args) {
	int[] arr = {5,8,7,4,6,9,10,15,22,2,34,3};        //integer type array
	Arrays.sort(arr);                                 //Sorting the given Array
	System.out.println("Smallest no. in array is: "+ arr[0]); //printing first element of array
	
	}

}
