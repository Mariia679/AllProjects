package Lesson9;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import Lesson6.Gender;
import Lesson6.Person;

public class Main {

	public static void main(String[] args) {
		Set<Person> set = new LinkedHashSet<>();
		set.add(new Person("Mariia", 21, Gender.FEMALE));
		set.add(new Person("Ivan", 23, Gender.MALE));
		set.add(new Person("Petro", 24, Gender.MALE));
		set.add(new Person("Petro", 24, Gender.MALE));
		set.add(new Person("Kolia", 18, Gender.MALE));
		System.out.println(set);
		System.out.println(set.add(new Person("Mariia", 24, Gender.MALE)));
		System.out.println(set);
		
		Set<String> tree=new TreeSet<>();
		tree.add("Mariia");
		tree.add("Ivan");
		tree.add("Petro");
		tree.add("Kolia");
		System.out.println(tree);
		
		
		
	}

}
