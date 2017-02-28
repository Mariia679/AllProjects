package Lesson1;

public class Collactor extends Human {
	
	private int berries;

	// ����������� ���������� � ������������ ��������
	public Collactor(int age, String name) {
		super(age, name);

	}

	public void gather() {
		System.out.println(getName() + ": Gathered " + (berries += 5)
				+ " berries");
	}

	public void eat(String word) {
		System.out.println(getName() + ": Eat " + berries + " berries " + word);
	}

	public void sleep(String word) {
		System.out.println(getName() + ": Goodnight " + word);
	}

	// ��������������� ������ run() �� ������ �������� Human
	@Override
	public void run() {
		System.out.println(getName() + ": I can't run");
	}
}
