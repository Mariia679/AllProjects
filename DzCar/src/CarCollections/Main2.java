package CarCollections;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import DzCar.*;

public class Main2 {

	public static final Set<Car> car = new LinkedHashSet<>();

	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		car.add(new Car(100, true, 750, Tire.SUMMER, "Blue", "Truck"));
		car.add(new Car(90, false, 635, Tire.SUMMER, "Red", "Passenger"));
		car.add(new Car(105, false, 805, Tire.SUMMER, "Green", "Truck"));
		car.add(new Car(95, false, 635, Tire.SUMMER, "Red", "Passenger"));
		car.add(new Car(95, true, 640, Tire.SUMMER, "Blue", "Passenger"));
		car.add(new Car(100, false, 540, Tire.SUMMER, "Red", "Cabriolet"));
		car.add(new Car(110, false, 850, Tire.SUMMER, "Red", "Truck"));
		car.add(new Car(95, true, 550, Tire.SUMMER, "Green", "Cabriolet"));
		car.add(new Car(95, false, 740, Tire.SUMMER, "Blue", "Pessenger"));
		car.add(new Car(110, false, 635, Tire.SUMMER, "Red", "Truck"));
		car.add(new Car(100, true, 540, Tire.SUMMER, "Green", "Cabriolet"));
		car.add(new Car(100, false, 740, Tire.SUMMER, "Red", "Pessenger"));

		while (true) {
			System.out
					.println("Enter 1 to replace type of tire by color of body and diametr wheel");
			System.out.println("Enter 2 to delete by diameter of wheel");
			System.out
					.println("Enter 3 to find car by tire and diameter of wheel");
			switch (in.next()) {
			case "1":
				replaceByDiameterOfWheelAndColor();
				break;
			case "2":
				deleteByDiameter();
				break;
			case "3":
				findByTireAndDiameterOfWheel();
				break;
			default:
				in.close();
				return;
			}
		}
	}

	static void replaceByDiameterOfWheelAndColor() {
		System.out.println("Enter body color");
		String color = in.next();
		System.out.println("Enter diameter");
		double diameter = in.nextDouble();
		System.out.println("Enter type of tire");
		String tire = in.next();
		Tire tire1;
		Iterator<Car> iter = car.iterator();
		while (iter.hasNext()) {
			Car car = iter.next();
			if (car.getDiametrWheel() == diameter
					&& car.getColor().equals(color)) {
				tire1 = Tire.valueOf(tire.toUpperCase());
				car.setTire(tire1);
			}
		}
		car.forEach(System.out::println);
	}

	static void deleteByDiameter() {
		System.out.println("Enter min diameter");
		double min = in.nextDouble();
		System.out.println("Enter max diameter");
		double max = in.nextDouble();
		Iterator<Car> iter = car.iterator();
		while (iter.hasNext()) {
			Car car = iter.next();
			if (car.getDiametrWheel() > min && car.getDiametrWheel() < max) {
				iter.remove();
			}
		}
		car.forEach(System.out::println);
	}

	static void findByTireAndDiameterOfWheel() {
		System.out.println("Enter min diameter");
		double min = in.nextDouble();
		System.out.println("Enter max diameter");
		double max = in.nextDouble();
		System.out.println("Enter type of tire");
		String tire = in.next();
		Iterator<Car> iter = car.iterator();
		while (iter.hasNext()) {
			Car car = iter.next();
			if (car.getDiametrWheel() > min && car.getDiametrWheel() < max
					&& car.getTire().equals(Tire.valueOf(tire.toUpperCase()))) {
				System.out.println(car);
			}
		}
	}
}
