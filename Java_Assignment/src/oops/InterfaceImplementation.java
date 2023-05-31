// Program to create an interface and implement the interface in a class.
package oops;

interface Interface {
    void messageDisplay();
}

class NewClass implements Interface {
    public void messageDisplay() {
        System.out.println("Implementation of the messageDisplay method.");
    }
}

public class InterfaceImplementation {
    public static void main(String[] args) {
        NewClass object = new NewClass();
        object.messageDisplay();
    }
}
