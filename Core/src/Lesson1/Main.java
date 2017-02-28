package Lesson1;

public class Main {

	public static void main(String[] args) {
		//Создание объекта класса Hunter, который наследуется от Human
		Hunter hunter = new Hunter(4, "Ivan");
		hunter.eat("bird meat");
		hunter.eat();
		
		//human принадлежит к интерфейсу Homosapiens
		Homosapiens human = new Human(20, "Petro");
		System.out.println(human);
		System.out.println(hunter);
		//Создание объекта класса Collactor, который наследуется от Human
		Collactor collactor=new Collactor(4,"Mariia");
		collactor.gather();
		collactor.gather();
		collactor.eat("Bla Bla");
		collactor.run();
		collactor.sleep("Don't touch my la-la-la");
		Human.countOfpeople();
		
	}

}
