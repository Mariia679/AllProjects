package Rob;

public class RobotDancer extends Robot{
	RobotDancer(int age,String name,String color) {
		super(age,name,color);
	}
	@Override
	void work() {
		System.out.println("���� ����� "+name+" � ��� "+age+" ����. � �����-� ������");
	}
}
