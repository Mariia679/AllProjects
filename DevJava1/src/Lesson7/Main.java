package Lesson7;

public class Main {

	public static void main(String[] args) {
		Person p=new Person(18,"Иван");
//		p.age=18;
//		p.name="Иван";
		System.out.println(p.age);
		System.out.println(p.name);
		Person p1=new Person(25,"Vasya");
//		p1.age=25;
//		p1.name="Vasya";
		System.out.println(p1.age);
		System.out.println(p1.name);
		p.run();
		p1.run();
		
		
	}

}
