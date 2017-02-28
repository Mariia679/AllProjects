package Lesson11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import Lesson6.Gender;
import Lesson6.Month;
import Lesson6.Person;

public class Main {

	public static void main(String[] args) {
		Map<String, List<Person>> map = new HashMap<>();
		/*
		 * map.put("Manager", new Person("Ivan", 23, Gender.MALE));
		 * map.put("Engeneer", new Person("Petro", 25, Gender.MALE));
		 * map.put("Manager", new Person("Mykola", 26, Gender.MALE));
		 * System.out.println(map.get("Manager"));
		 */
		map.put("Manager", new ArrayList<>());
		map.get("Manager").add(new Person("Ivan", 23, Gender.MALE));
		map.get("Manager").add(new Person("Mykola", 26, Gender.MALE));
		map.put("Engineer", new ArrayList<>());
		map.get("Engineer").add(new Person("Petro", 25, Gender.MALE));

		System.out.println(map);

		Set<Entry<String, List<Person>>> entrySet = map.entrySet();
		for (Entry<String, List<Person>> entry : entrySet) {
			String key = entry.getKey();
			for (Person person : entry.getValue()) {
				System.out.println(key + " -> " + person);
			}
		}
		System.out.println();
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			for (Person person : map.get(key)) {
				System.out.println(key + " -> " + person);
			}
		}
		System.out.println();

		map.forEach((key, value) -> value.forEach(person -> System.out
				.println(key + " -> " + person)));

		Scanner in = new Scanner(System.in);

		while (true) {
			System.out.println("Enter 1 to add proffesion");
			System.out.println("Enter 2 to add person");
			System.out.println("Enter 3 to show all person");
			System.out.println("Enter 4 to persons by proffesion");
			switch (in.next()) {
			case "1":
				addWork(map, in);
				System.out.println(map);
				break;
			case "2":
				System.out.println("Enter proffesion");
				String prof = in.next();
				if (map.containsKey(prof)) {
					System.out.println("Enter name");
					String name = in.next();
					System.out.println("Enter age");
					int age = in.nextInt();
					System.out.println("Enter male");
					String male = in.next();
					Gender gender = Gender.valueOf(male.toUpperCase());
					map.get(prof).add(new Person(name, age, gender));
				} else {
					System.out.println("Proffesion doesn't exist");
				}
				break;
			case "3":
				map.forEach((key, value) -> value.forEach(person -> System.out
						.println(key + " -> " + person)));

				break;
			case "4":
				System.out.println("Enter proffesion");
				List<Person> list = map.get(in.next());
				if (list != null) {
					list.forEach(System.out::println);
				}
				break;
			default:
				in.close();
				return;
			}

		}
	}

	static void addWork(Map<String, List<Person>> map, Scanner in) {
		System.out.println("Enter work");
		String work = in.next();
		map.put(work, new ArrayList<>());
	}

	

}
