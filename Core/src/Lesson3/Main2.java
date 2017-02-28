package Lesson3;

public class Main2 {

	public static void main(String[] args) {

		// Отражает связь между интерфейсом Geometric и классом Rectangle
		Geometric rectange = new Rectangle(3, 4);
		rectange.print();
		
		/*
		 * От интерфейса Geometric наследуется интерфейс RoundGeometric а от
		 * него в свою очередь Circle
		 */
		
		Geometric cirle = new Circle(5);
		cirle.print();
	}

}
