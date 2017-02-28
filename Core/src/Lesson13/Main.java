package Lesson13;

import java.util.Scanner;

import Lesson6.Gender;
import Lesson6.Person;

public class Main {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		Controller controller = new Controller();
		while (true) {
			System.out.println("Enter 1 to add person");
			System.out.println("Enter 2 to show all persons");
			System.out.println("Enter 3 to save to text file");
			System.out.println("Enter 4 to restore from text file");
			switch (in.next()) {
			case "1":
				System.out.println("Enter name");
				String name = in.next();
				System.out.println("Enter age");
				int age = in.nextInt();
				System.out.println("Enter gender");
				Gender gender = Gender.valueOf(in.next().toUpperCase());
				controller.add(new Person(name, age, gender));
				break;
			case "2":
				controller.print();
				break;
			case "3":
				System.out.println("Enter file name");
				controller.write(in.next());
			case "4":
				System.out.println("Enter file name");
				controller.restore(in.next());
				break;

			default:
				in.close();
				return;
			}

		}
	}
}
