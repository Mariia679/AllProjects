package PrincipleOOP;

import java.util.Scanner;

public class Human {

	public static void main(String[] args) {

		// �������� �������� ������ Refrigerator
		// �������� ������������
		Refrigerator open = new Refrigerator();
		Refrigerator open1 = new Refrigerator();
		Refrigerator open2 = new Refrigerator();

		Scanner in = new Scanner(System.in);
		/*
		 * �������� ���������� � ����� ������ �� �������� ��� ��� ���
		 * ��������������� ������� ���������� ����� ��������� ������ ������
		 * ������ ����������� �� ������ ��� ������ (�� ���� ����� ��� ������)
		 */
		System.out.println(open.getChiken());
		System.out.println(open.getEggs());
		System.out.println(open.getMilk());
		open.spoiledMilk();
		System.out.println(open.getMilk());

		// ��� �� ����� �������� � �����������
		open.setChiken(1);
		open.setMilk(1);

		// ���������
		System.out.println(open.getChiken());
		System.out.println(open.getMilk());
		
		open.countOfOpens();

	}

}
