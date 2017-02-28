package CarCollections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import DzCar.*;

public class Main {

	public static final ArrayList<Car> car = new ArrayList<>();

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
			System.out.println("Enter 0 if you want to exit the menu");
			System.out
					.println("Enter 1 if you want to find a car that have entered diameter wheels");
			System.out
					.println("Enter 2 if you want to find a car that have entered diameter wheels and body color");
			System.out
					.println("Enter 3 if you want to replace cars that have red body color, wheel to another");
			System.out
					.println("Enter 4 if you want to increase the diameter of the wheel twice if the steering wheel has buttons");
			System.out
					.println("Enter 5 if you want to replace all cars that have wheels with a diameter less than the entered value to another cars");
			System.out.println("Enter 6 to find by type of body");
			System.out.println("Enter 7 to delete by color");
			System.out
					.println("Enter 8 to change tires for the winter by diameter wheel");
			System.out
					.println("Enter 9 to delete by type of body and by diameter rudder");
			System.out.println("Enter 10 to find indexes by type of body");

			switch (in.next()) {
			case "0":
				System.out.println("Thank you! Bye!");
				break;
			case "1":
				findCarDiameterWheels();
				break;
			case "2":
				findDiameterWheelsBodyColor();
				break;
			case "3":
				replaceRudderInRedCar();
				break;
			case "4":
				increaseDiamWheelIfRudderHaveButtons();
				break;
			case "5":
				replaceCarIfDiameterWheelLess();
				break;
			case "6":
				findByBody();
				break;
			case "7":
				deleteByColorBody();
				break;
			case "8":
				replaceByDiameterOfWheel();
				break;
			case "9":
				deleteByTypeBodyAndDiameterRudder();
				break;
			case "10":
				findIndexesOfTypeBody();
				break;
			default:
				in.close();
				return;
			}
		}
	}

	public static void printArrayList() {
		for (Car car2 : car) {
			System.out.println(car2);
		}
	}

	public static void findCarDiameterWheels() {
		System.out.println("Enter diameter wheels");
		double diameter = in.nextDouble();
		for (Car car2 : car) {
			if (diameter == car2.getDiametrWheel())
				System.out.println(car2);
		}

	}

	public static void findDiameterWheelsBodyColor() {
		System.out.println("Enter body color");
		String color = in.next();
		System.out.println("Enter diameter wheels");
		double diameter = in.nextDouble();
		for (Car car2 : car) {

			if (car2.getColor().equals(color)
					&& diameter == car2.getDiametrWheel()) {
				System.out.println(car2);

			}
		}
	}

	public static void replaceRudderInRedCar() {
		System.out.println("Enter 0 if you want change rudder with buttons");
		System.out.println("Enter 1 if you want change rudder without buttons");
		int buttons = in.nextInt();
		Rudder rudder;
		System.out.println("Enter the diameter of rudder");
		if (buttons == 0) {
			rudder = new Rudder(in.nextDouble(), true);
		} else
			rudder = new Rudder(in.nextDouble(), false);

		for (Car car2 : car) {
			if (car2.getColor() == "Red") {
				car2.setRudder(rudder);
			}
		}
		printArrayList();

	}

	public static void increaseDiamWheelIfRudderHaveButtons() {
		for (Car car2 : car) {
			if (car2.isButton()) {
				car2.increaseDiametrWheel(2);
			}
		}
		printArrayList();
	}

	public static void replaceCarIfDiameterWheelLess() {
		System.out.println("Enter diameter wheels");
		double diameter = in.nextDouble();
		for (int i = 0; i < car.size(); i++) {
			if (diameter > car.get(i).getDiametrWheel()) {
				car.set(i,
						new Car(100, true, 850, Tire.SUMMER, "Blue", "Truck"));
			}

		}
		printArrayList();
	}

	static void findByBody() {
		System.out.println("Enter type body");
		String body = in.next();
		Iterator<Car> iter = car.iterator();
		while (iter.hasNext()) {
			Car car = iter.next();
			if (car.getSize().equals(body)) {
				System.out.println(car);
			}
		}
	}

	static void deleteByColorBody() {
		System.out.println("Enter body color");
		String color = in.next();
		Iterator<Car> iter = car.iterator();
		while (iter.hasNext()) {
			Car car = iter.next();
			if (car.getColor().equals(color)) {
				iter.remove();
			}
		}
		car.forEach(System.out::println);
	}

	static void replaceByDiameterOfWheel() {
		System.out.println("Enter min diameter");
		double min = in.nextDouble();
		System.out.println("Enter max diameter");
		double max = in.nextDouble();
		Iterator<Car> iter = car.iterator();
		while (iter.hasNext()) {
			Car car = iter.next();
			if (car.getDiametrWheel() > min && car.getDiametrWheel() < max) {
				car.setTire(Tire.WINTER);
			}
		}
		car.forEach(System.out::println);
	}

	static void deleteByTypeBodyAndDiameterRudder() {
		System.out.println("Enter min diameter");
		double min = in.nextDouble();
		System.out.println("Enter max diameter");
		double max = in.nextDouble();
		System.out.println("Enter type body");
		String body = in.next();
		Iterator<Car> iter = car.iterator();
		while (iter.hasNext()) {
			Car car = iter.next();
			if (car.getDiametr() > min && car.getDiametr() < max
					&& car.getSize().equals(body)) {
				iter.remove();
			}
		}
		car.forEach(System.out::println);
	}

	static void findIndexesOfTypeBody() {
		System.out.println("Enter type body");
		String body = in.next();
		ListIterator<Car> iter = car.listIterator();
		List<Integer> list = new ArrayList<>();
		while (iter.hasNext()) {
			Car car = iter.next();
			if (car.getSize().equals(body)) {
				list.add(iter.nextIndex() - 1);
			}
		}
		list.forEach(System.out::println);
	}
}
