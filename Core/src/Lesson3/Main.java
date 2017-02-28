package Lesson3;

public class Main {

	public static void main(String[] args) {
		Robot robot = new RobotDancer();
		robot.work();
		Balada balada = new SimpeBalada();
		Bard bard = new Bard("Lutik");
		bard.sing(balada);
		Balada balada2=new HeroBalada();
		bard.sing(balada2);
	}

}
