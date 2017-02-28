package Lesson10;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import Lesson6.Gender;
import Lesson6.Person;

public class Main {

	private static final List<Person> list = new ArrayList<>();
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		list.add(new Person("Mariia", 21, Gender.FEMALE));
		list.add(new Person("Ivan", 23, Gender.MALE));
		list.add(new Person("Petro", 24, Gender.MALE));
		list.add(new Person("Kolia", 18, Gender.MALE));
		list.add(new Person("Oleg", 17, Gender.MALE));
		list.add(new Person("Olya", 25, Gender.FEMALE));
		list.add(new Person("Ira", 19, Gender.FEMALE));
		list.add(new Person("Sergiy", 30, Gender.MALE));

		while (true) {
			System.out.println("Enter 1 to sort by name asc");
			System.out.println("Enter 2 to sort by name desc");
			System.out.println("Enter 3 to sort by age asc");
			System.out.println("Enter 4 to sort by age desc");
			switch (sc.next()) {
			case "1":
				sortByNameAsc().forEach(System.out::println);
				break;
			case "2":
				sortByNameDesc().forEach(System.out::println);
				break;
			case "3":
				sortByAgeAsc().forEach(System.out::println);
				break;
			case "4":
				sortByAgeDesc().forEach(System.out::println);
				break;
			default:
				sc.close();
				return;
			}

		}

	}

	static Stream<Person> sortByNameAsc() {
		// List<Person> persons=new ArrayList<Person>(list);
		// persons.sort(null);
		// return persons;
		return list.stream().sorted();
	}

	static Stream<Person> sortByNameDesc() {
		// List<Person> persons=new ArrayList<Person>(list);
		// persons.sort(new PersonComparatorByNameDesc());
		// return persons;
		return list.stream().sorted(
				(o1, o2) -> o2.getName().compareTo(o1.getName()));
	}

	static Stream<Person> sortByAgeAsc() {
		return list.stream().sorted(comparingInt(Person::getAge));
	}

	static Stream<Person> sortByAgeDesc() {
		return list.stream().sorted(comparingInt(Person::getAge).reversed());
	}

	static Stream<Person> sortByAllDesc() {
		return list
				.stream()
				.sorted(comparing(Person::getName).reversed()
						.thenComparing(comparingInt(Person::getAge)).reversed()
						.thenComparing(comparing(Person::getGender).reversed()));
	}

}
