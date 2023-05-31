// Remove duplicates from an ArrayList
package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class RemovingDuplicatesFromArrayList {

	public static void main(String[] args) {
		ArrayList<Integer> num = new ArrayList<Integer>(Arrays.asList(1,2,3,5,7,4,1,3,8,4,7,6,5,5,8,7)); //defining arrayList
		System.out.println("ArrayList before removing duplicates:" + num);
		HashSet<Integer> unique_Num = new HashSet<Integer>(num);                          //Create and add elements in hashsets
		num.clear();                                                                      // clearing all elements from arrayList
		num.addAll(unique_Num);                                                           // importing elements back from hash set
		System.out.println("ArrayList after removing duplicates: " + num);
	}

}
