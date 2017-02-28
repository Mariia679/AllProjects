package Rob;

public class Robot {
	int age;
	String name;
	String color;
	
	Robot(int age,String name,String color){
		this.age=age;
		this.name=name;
		this.color=color;
	}
	void work(){
		System.out.println("Я робот-я просто работаю");
	}
}
