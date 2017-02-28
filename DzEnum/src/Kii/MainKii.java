package Kii;

import java.util.Scanner;

public class MainKii {

	public static void main(String[] args) {

		Title[] title = Title.values();
		// ���������� �������� ���������
		for (int i = 0; i < title.length; i++) {
			System.out.println(title[i]);
		}

		System.out.println();

		Purpose[] purpose = Purpose.values();
		// ���������� ���������� ����
		for (int i = 0; i < purpose.length; i++) {
			System.out.println(purpose[i]);
		}

		System.out.println();

		Material[] material = Material.values();
		// ���������� ��������
		for (int i = 0; i < material.length; i++) {
			System.out.println(material[i]);
		}

		System.out.println();

		// �������� ��� ����� ������ 1500���

		for (int i = 0; i < title.length; i++) {
			if (title[i].getPrice() < 1500) {
				System.out.println(title[i]);
			}
		}

		System.out.println();

		// ������� ���� ���� ���� �� �����

		for (int i = 0; i < title.length; i++) {
			if (title[i].getMaterial() == Material.VENGE) {
				title[i].setPrice(2000);
				System.out.print(title[i] + " ");
				System.out.println(title[i].getPrice());
			}
		}

		System.out.println();

		// �������� ���� ���� ������� ����

		for (int i = 0; i < title.length; i++) {

		}

		// �������� ������� ���

		for (int i = 0; i < title.length; i++) {
			if (title[i].getPurpose() == Purpose.ELITE) {
				System.out.println(title[i]);
			}
		}
		// ��������� ��� ��� �� ����������
		for (int i = 0; i < title.length; i++) {

		}
		Scanner in = new Scanner(System.in);
		int answer = 1;
		int price;
		String materials;
		String materials1;
		while (answer > 0) {
			System.out.println();
			System.out.println("������� 0 ���� ������ ����� �� ����");
			System.out
					.println("������� 1 ���� ������ ���������� �������� ���������");
			System.out
					.println("������� 2 ���� ������ ���������� ���������� ����");
			System.out.println("������� 3 ���� ������ ���������� ��������");
			System.out
					.println("������� 4 ���� ������ ���������� ��� ����� ������ ���������");
			System.out
					.println("������� 5 ���� ������ ������� ���� ���� ���� �� ���������� ���������");
			System.out
					.println("������� 6 ���� ������ ������� �������� ���� ���� �� ���������� ��������� �� ���������");
			answer = in.nextInt();
			switch (answer) {
			case 0:
				System.out.println("����");
				break;
			case 1:
				for (int i = 0; i < title.length; i++) {
					System.out.println(title[i]);
				}
				break;
			case 2:
				for (int i = 0; i < purpose.length; i++) {
					System.out.println(purpose[i]);
				}
				break;
			case 3:
				for (int i = 0; i < material.length; i++) {
					System.out.println(material[i]);
				}
				break;
			case 4:
				System.out
						.println("������� ���� ������ ������� ������ ����������");
				price = in.nextInt();
				for (int i = 0; i < title.length; i++) {
					if (title[i].getPrice() < price) {
						System.out.println(title[i]);
					}
				}
				break;
			case 5:
				System.out
						.println("������� �������� �������� ������ ����������");
				materials = in.next();
				System.out
						.println("������� ���� ������ �� ������� ������ ��������");
				price = in.nextInt();
				Material mat = Material.valueOf(materials.toUpperCase());
				for (int i = 0; i < title.length; i++) {
					if (title[i].getMaterial() == mat) {
						title[i].setPrice(price);
						System.out.print(title[i] + " ");
						System.out.println(title[i].getPrice() + " ���");
					}
				}
				break;
			case 6:
				System.out
						.println("������� �������� �������� ������ ����������");
				materials = in.next();
				System.out
						.println("������� �������� �� ������� ������ ��������");
				price = in.nextInt();
				Material mat1 = Material.valueOf(materials.toUpperCase());
				for (int i = 0; i < title.length; i++) {
					if (title[i].getMaterial() == mat1) {
						title[i].setPrice(price);
						System.out.print(title[i] + " ");
						System.out.println(title[i].getPrice() + " ���");
					}
				}
				break;
			default:
				System.out.println("������� ������ �����");
				break;
			}
		}

	}

}
