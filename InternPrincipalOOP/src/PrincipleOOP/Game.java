package PrincipleOOP;

public class Game {

	private String userName;

	private int age;

	private String name;

	private static int count;

	public Game(String userName, int age, String name) {
		this();
		this.userName = userName;
		this.age = age;
		this.name = name;
	}

	public Game() {
		count++;
	}

	public void countOfUsers() {
		System.out.println(count);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Game [userName=" + userName + ", age=" + age + ", name=" + name
				+ "]";
	}

}
