// Program to sort an ArrayList in descending order
package collections;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayList_Sorting {

	public static void main(String[] args) {
		ArrayList<String> arr= new ArrayList<String>();                                 // creating arreayList
		arr.add("s");arr.add("f");arr.add("e");arr.add("g");arr.add("x");arr.add("k");  // adding element into arrayList
		System.out.println("ArrayList before sorting: " + arr);
		Collections.sort(arr,Collections.reverseOrder());                               //sorting arrayList in in descending order 
		System.out.println("ArrayList after sorting in decending order :" + arr);

	}

}
