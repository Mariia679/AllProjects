package PrincipleOOP;

import java.util.Scanner;

public class User {

	public static void main(String[] args) {
		
		//�������� �������� ������ Game
		Game user = new Game();
		Game user1=new Game();
		Game user2=new Game();
		
		Scanner in = new Scanner(System.in);
		
		//�������� ���������� � ����� ������ �� �������� ��� ��� ��� ��������������� 
		//������� ���������� ����� ��������� ������ 
		System.out.println("Enter age");
		user.setAge(in.nextInt());
		System.out.println("Enter user name");
		user.setUserName(in.next());
		System.out.println("Enter your name");
		user.setName(in.next());
		System.out.println(user);
		
		//����� ���������� ������� �������� ������ Game �������
		user2.countOfUsers();
	}

}
