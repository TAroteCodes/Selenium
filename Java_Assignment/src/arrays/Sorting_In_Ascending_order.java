// Sort the array in ascending order
package arrays;

import java.util.Arrays;

public class Sorting_In_Ascending_order {

	public static void main(String[] args) {
		int[] arr = {5,8,100,4,6,9,10,15,22,2,34,3};        //integer type array
		System.out.println("Original Array: " + Arrays.toString(arr));
		Arrays.sort(arr);                                 //Sorting the given Array
		System.out.println("Array After Sorting:" + Arrays.toString(arr));

	}

}
