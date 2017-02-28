package Lesson3;

public class Bard {
	private String name;

	public Bard(String name) {
		this.name = name;
	}

	public void sing(Balada balada) {
		System.out.print(name + ": ");
		balada.song();
	}

}
