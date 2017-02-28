package DzAbstract;

public class Main {

	public static void main(String[] args) {
		Pet cow = new Cow();
		cow.voice();
		Pet cat = new Cat();
		cat.voice();
		Pet dog = new Dog();
		dog.voice();
	}

}
