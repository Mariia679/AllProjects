package Rob;

public class Main {

	public static void main(String[] args) {
		Robot �offeeRobot = new CoffeeRobot(3, "����001", "Green");
		�offeeRobot.work();
		Robot robotDancer = new RobotDancer(2, "����002", "Red");
		robotDancer.work();
		RobotCoocker robotCoocker = new RobotCoocker(1, "����003", "Blue");
		robotCoocker.work();
		Robot robot = new Robot(1, "����004", "Pink");
		robot.work();
	}

}
