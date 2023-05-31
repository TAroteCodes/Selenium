// Program to create a class with a constructor and two methods. Create another class with the main method.
// Create an object for the first class in the main method and call the two methods created.
package oops;

class MyClass{                                      //first class 
	public MyClass(String str) {                    // constructor
		System.out.println("My name is "+ str);
	}
	public void firstMethod() {                     //method 1
		System.out.println("you are inside first Method.");
	}
	public void secondMethod() {                    //method 2
		System.out.println("You are inside second method.");
	}
}
public class ConstructersMethodsObjectCreation {       //Second class

	public static void main(String[] args) {
		MyClass Object = new MyClass("Tushar");        //object creation
		Object.firstMethod();                          //calling first method
		Object.secondMethod();                         //calling second method
		
	}

}
