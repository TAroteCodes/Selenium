// Reverse a string and print the reversed string in upper case

package string_Handling;
import java.util.Scanner;


class Reverse 
{ 
	public String rev(String str) 
{
		String Rev_str = "";                  // empty string initialize
        for (int i = str.length()-1;i>=0;i--) // For loop starting from end
        {
        	Rev_str = Rev_str + str.charAt(i);         // appending characters to reverse string one by one
        }
        return Rev_str.toUpperCase();
}
	
}
public class String_Reverse {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();      //input strinng
        Reverse s = new Reverse();
        String new_str = s.rev(str);
        System.out.println(new_str);

	}
	
	}

