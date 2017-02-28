package Rob;

public class RobotCoocker  extends Robot{
	int biscuit;
	RobotCoocker(int age,String name,String color) {
		super(age,name,color);
	}
	@Override
	void work() {
		System.out.println("Меня зовут "+name+" и мне "+age+" год. Я робот-я повар ");
	}
	
}
