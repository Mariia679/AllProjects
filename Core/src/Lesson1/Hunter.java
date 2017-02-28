package Lesson1;

public class Hunter extends Human {

	private int killedMamonts;

	//  онструктор обращаетс€ к конструктору родител€
	public Hunter(int age, String name) {
		super(age, name);
	}

	public void eat(String meat) {
		System.out.println(getName() + ": mmm nyam-nyam-nyam " + meat);
	}

	public void eat() {
		run();
		killedMamonts++;
		System.out.println(getName() + ": I killed " + killedMamonts
				+ " mommonts");
		eat("mammont meat");
	}

	// ѕереопределение метода run() из класса родител€ Human
	@Override
	public void run() {
		System.out.println(getName() + ": faster go-go-go");
	}

	public String toString() {
		return "Hunter [age=" + getAge() + ",name=" + getName()
				+ ",killedMamonts=" + killedMamonts + "]";
	}
}
