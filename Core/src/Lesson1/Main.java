package Lesson1;

public class Main {

	public static void main(String[] args) {
		//�������� ������� ������ Hunter, ������� ����������� �� Human
		Hunter hunter = new Hunter(4, "Ivan");
		hunter.eat("bird meat");
		hunter.eat();
		
		//human ����������� � ���������� Homosapiens
		Homosapiens human = new Human(20, "Petro");
		System.out.println(human);
		System.out.println(hunter);
		//�������� ������� ������ Collactor, ������� ����������� �� Human
		Collactor collactor=new Collactor(4,"Mariia");
		collactor.gather();
		collactor.gather();
		collactor.eat("Bla Bla");
		collactor.run();
		collactor.sleep("Don't touch my la-la-la");
		Human.countOfpeople();
		
	}

}
