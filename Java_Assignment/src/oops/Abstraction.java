package oops;

abstract class AbstractClass {                                      // Abstract class
    public abstract void messageDisplay();                          // Abstract method
    
    public void print() {
        System.out.println("Message from abstract class.");
    }
}


class ConcreteClass extends AbstractClass {                          // Concrete class extending the abstract class
    public void messageDisplay() {
        System.out.println("Message from concrete class by implimenting abstract method");
    }
}
public class Abstraction {

	public static void main(String[] args) {
		ConcreteClass object = new ConcreteClass();                  //object creation of concrete class
		object.messageDisplay();                                     //calling the abstract method implemented in concrete class
		object.print();                                              // calling method from abstract class

	}

}
