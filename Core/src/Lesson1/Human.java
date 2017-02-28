package Lesson1;

/*
 * Данный класс родитель использует принцип ООП - инкапсуляцию
 * Принадлеж
 * */

public class Human implements Homosapiens {

	private int age;

	private String name;

	private static int count;

	public Human(int age, String name) {
		this(age);
		setName(name);
	}

	public Human(int age) {
		this();
		this.age = age;
	}

	public Human() {
		count++;
		System.out.println("I was born");
	}

	public static void countOfpeople() {
		System.out.println("Count of people = " + count);
	}

	public void run() {
		System.out.println(name + ": go-go-go");
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "Human [age=" + age + ",name=" + name + "]";
	}
}
