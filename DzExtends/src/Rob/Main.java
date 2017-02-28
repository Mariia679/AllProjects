package Rob;

public class Main {

	public static void main(String[] args) {
		Robot ñoffeeRobot = new CoffeeRobot(3, "Ãðîã001", "Green");
		ñoffeeRobot.work();
		Robot robotDancer = new RobotDancer(2, "Ãðîã002", "Red");
		robotDancer.work();
		RobotCoocker robotCoocker = new RobotCoocker(1, "Ãðîã003", "Blue");
		robotCoocker.work();
		Robot robot = new Robot(1, "Ãðîã004", "Pink");
		robot.work();
	}

}
