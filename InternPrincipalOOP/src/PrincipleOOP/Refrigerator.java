package PrincipleOOP;

public class Refrigerator {

	private int eggs = 10;

	private int milk = 1;

	private int chiken = 1;

	private static int count;

	public Refrigerator(int eggs, int milk, int chiken) {
		this();
		this.eggs = eggs;
		this.milk = milk;
		this.chiken = chiken;
	}

	public Refrigerator() {
		count++;
	}

	public void countOfOpens() {
		System.out.println("You opened the refrigerator " + count + " times.");
	}

	public void spoiledMilk() {
		System.out.println("Milk spoiled");
		System.out.println("Discard milk");
		this.milk = 0;
	}

	public int getEggs() {
		return eggs;
	}

	public void setEggs(int eggs) {
		this.eggs += eggs;
	}

	public int getMilk() {
		return milk;
	}

	public void setMilk(int milk) {
		this.milk += milk;
	}

	public int getChiken() {
		return chiken;
	}

	public void setChiken(int chiken) {
		this.chiken += chiken;
	}

}
