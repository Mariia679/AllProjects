package Lesson8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

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
			System.out.println("Enter 1 to find by age");
			System.out.println("Enter 2 to find by name");
			System.out.println("Enter 3 to delete by first letter");
			System.out.println("Enter 4 to find indexes by letter");
			switch (sc.next()) {
			case "1":
				findByAge();
				break;
			case "2":
				findByName();
				break;
			case "3":
				deleteByFirstLetter();
				break;
			case "4":
				findIndexes();
				break;
			default:
				sc.close();
				return;
			}

		}
	}

	static void findByAge() {
		System.out.println("Enter min age");
		int min = sc.nextInt();
		System.out.println("Enter max age");
		int max = sc.nextInt();
		for (Person person : list) {
			if (person.getAge() > min && person.getAge() < max)
				System.out.println(person);
		}
	}
	static void findByName(){
		System.out.println("Enter name");
		String name=sc.next();
		for (Person person : list) {
			if(person.getName().equals(name))
				System.out.println(person);
		}
	}
	static void deleteByFirstLetter(){
		System.out.println("Enter first letter");
		String letter=sc.next();
		Iterator<Person> iter=list.iterator();
		while(iter.hasNext()) {
			Person person=iter.next();
			if(person.getName().startsWith(letter))
				iter.remove();
		}
		list.forEach(System.out::println);
	}
	static void findIndexes(){
		System.out.println("Enter first letter");
		String letter=sc.next();
		ListIterator<Person> iter=list.listIterator();
		List<Integer> list=new ArrayList<>();
		while(iter.hasNext()){
			Person person=iter.next();
			if(person.getName().contains(letter)){
				list.add(iter.nextIndex()-1);
			}
		}
		System.out.println(list);;
	}
}
