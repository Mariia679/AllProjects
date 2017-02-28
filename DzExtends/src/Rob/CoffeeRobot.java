package Rob;

public class CoffeeRobot extends Robot {
	
	CoffeeRobot(int age,String name,String color) {
		super(age,name,color);
	}
	@Override
	void work() {
		System.out.println("Меня зовут "+name+" и мне "+age+" года. Я робот-я Варю кофе");
	}
}
