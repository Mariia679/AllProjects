package TestSoftServe;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

	}

	public class EmptyNameException extends RuntimeException {

		private static final long serialVersionUID = 2474363014006922771L;

	}

	public abstract class Person {

		private String name;

		public Person(String name) {
			if (!(name == null || name.isEmpty())) {
				this.name = name;
			} else {
				throw new EmptyNameException();
			}
		}

		public Person() {
		}

		public abstract void showData();

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

	public class Student extends Person {

		public Student(String name, String education) {
			super(name);
			this.education = education;
		}

		private String education;

		@Override
		public void showData() {
			System.out.println(getName() + " " + getEducation());
		}

		public String getEducation() {
			return education;
		}

		public void setEducation(String education) {
			this.education = education;
		}

	}

	public class Worker extends Person {

		public Worker(String name, String workPlace) {
			super(name);
			this.workPlace = workPlace;
		}

		private String workPlace;

		@Override
		public void showData() {
			System.out.println(getName() + " " + getWorkPlace());
		}

		public String getWorkPlace() {
			return workPlace;
		}

		public void setWorkPlace(String workPlace) {
			this.workPlace = workPlace;
		}

	}

	public class Academy {

		private final List<Person> persons = new ArrayList<>();

		public void addPerson(Person person) {
			persons.add(person);
		}

		public void showAll() {
			// ref call method from person
			persons.forEach(Person::showData);
		}

	}
}
