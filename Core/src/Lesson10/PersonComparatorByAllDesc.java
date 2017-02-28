package Lesson10;

import java.util.Comparator;

import Lesson6.Person;

public class PersonComparatorByAllDesc implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		int res=o2.getName().compareTo(o1.getName());
		if(res!=0)return res;
		//res=
		return 0;
	}

}
