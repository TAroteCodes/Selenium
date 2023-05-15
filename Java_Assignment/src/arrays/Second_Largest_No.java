// Find the second largest number in an array

package arrays;

import java.util.Arrays;

public class Second_Largest_No {

	public static void main(String[] args) {
		int[] arr = {5,8,7,4,6,9,10,15,22,2,34,3};        //integer type array
		Arrays.sort(arr);                                 //Sorting the given Array
		System.out.println("Second Largest No In Array Is: " + arr[arr.length-2]);  //printing second last no. in array

	}

}
