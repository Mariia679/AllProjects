package Lesson10;

import java.util.Comparator;

import Lesson6.Person;

public class PersonComparatorByNameDesc implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		return o2.getName().compareTo(o1.getName());
	}

}
