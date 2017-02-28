package PrincipleOOP;

import java.util.Scanner;

public class User {

	public static void main(String[] args) {
		
		//Создание объектов класса Game
		Game user = new Game();
		Game user1=new Game();
		Game user2=new Game();
		
		Scanner in = new Scanner(System.in);
		
		//Напрямую обратиться к полям класса не возможно так как они инкапсулированы 
		//Поэтому обращаемся через доступные методы 
		System.out.println("Enter age");
		user.setAge(in.nextInt());
		System.out.println("Enter user name");
		user.setUserName(in.next());
		System.out.println("Enter your name");
		user.setName(in.next());
		System.out.println(user);
		
		//Метод показывает сколько объектов класса Game создано
		user2.countOfUsers();
	}

}
