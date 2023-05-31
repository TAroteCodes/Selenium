// Program to create a class with method overloading. Create a child class with method overriding.
package oops;

class Parent {
    public void display(int num) 
    {                        // Method with one parameter
    	int squre=num*num;
        System.out.println("Squre of " + num + " is "+ squre);
    }
    public void display(int num, int num2)                // Method with two parameters 
    {
        int addition = num+num2;
            System.out.println("Addition of "+num+" & "+num2+" is "+addition);
    }
  }



class Child extends Parent {                                     // Child class with method overriding
    public void display(int num)                                 // Method overriding  
    {
    	int cube = num*num*num;
        System.out.println("Cube of "+num+" is "+cube);
    }
}



public class MethodOverloadingAndOverriding {

	public static void main(String[] args) {
		
		 Parent parent = new Parent();                       //creating object of parent class
	        // Calling the overloaded methods in the parent class
	        parent.display(5);
	        parent.display(5, 3);
	        Child child = new Child();               //creating object of child class
	        child.display(5);                        // Calling the overridden method in the child class
	        child.display(3, 2);                     // Calling overloaded method in the parent class using child class object

	}

}
