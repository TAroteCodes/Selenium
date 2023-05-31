// Program to create a super class and two child classes. Use Inheritance.
package oops;
class Vehicle{                             //parent class
	public void type(String type) {
		System.out.println("Type of vehicle is " + type);
	}
}
class Bike extends Vehicle{                //child class
	public void price(int price) {
		System.out.println("price of Vehicle is " + price + " Rs.");
	}
}
class Car extends Bike{                     // child class
	public void sittingCapacity(String capacity) {
		System.out.println("Sitting capacity of the given vehicle is " + capacity);
	}
}
public class Inheritance {

	public static void main(String[] args) {
		Car vehicle = new Car();             //object creation
		vehicle.type("Hatchback");
		vehicle.price(700000);
		vehicle.sittingCapacity("Five");
		

	}

}
