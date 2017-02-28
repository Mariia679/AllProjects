package Kii;

import java.util.Scanner;

public class MainKii {

	public static void main(String[] args) {

		Title[] title = Title.values();
		// ПОКАЗЫВАЕТ НАЗВАНИЕ ПРОДУКЦИИ
		for (int i = 0; i < title.length; i++) {
			System.out.println(title[i]);
		}

		System.out.println();

		Purpose[] purpose = Purpose.values();
		// ПОКАЗЫВАЕТ НАЗНАЧЕНИЕ КИЕВ
		for (int i = 0; i < purpose.length; i++) {
			System.out.println(purpose[i]);
		}

		System.out.println();

		Material[] material = Material.values();
		// ПОКАЗЫВАЕТ МАТЕРИАЛ
		for (int i = 0; i < material.length; i++) {
			System.out.println(material[i]);
		}

		System.out.println();

		// ПОКАЗАТЬ КИИ ЦЕНОЙ МЕНЬШЕ 1500ГРН

		for (int i = 0; i < title.length; i++) {
			if (title[i].getPrice() < 1500) {
				System.out.println(title[i]);
			}
		}

		System.out.println();

		// СМЕНИТЬ ЦЕНУ ВСЕХ КИЕВ ИЗ ВЕНГЕ

		for (int i = 0; i < title.length; i++) {
			if (title[i].getMaterial() == Material.VENGE) {
				title[i].setPrice(2000);
				System.out.print(title[i] + " ");
				System.out.println(title[i].getPrice());
			}
		}

		System.out.println();

		// ПОВЫСИТЬ ЦЕНУ ВСЕХ ЭЛИТНЫХ КИЕВ

		for (int i = 0; i < title.length; i++) {

		}

		// ПОКАЗАТЬ ЭЛИТНЫЕ КИИ

		for (int i = 0; i < title.length; i++) {
			if (title[i].getPurpose() == Purpose.ELITE) {
				System.out.println(title[i]);
			}
		}
		// ПОКАЗАТТЬ ВСЕ КИИ ИЗ ПАЛИСАНДРА
		for (int i = 0; i < title.length; i++) {

		}
		Scanner in = new Scanner(System.in);
		int answer = 1;
		int price;
		String materials;
		String materials1;
		while (answer > 0) {
			System.out.println();
			System.out.println("Введите 0 если хотите выйти из меню");
			System.out
					.println("Введите 1 если хотите посмотреть НАЗВАНИЕ ПРОДУКЦИИ");
			System.out
					.println("Введите 2 если хотите посмотреть НАЗНАЧЕНИЕ КИЕВ");
			System.out.println("Введите 3 если хотите посмотреть МАТЕРИАЛ");
			System.out
					.println("Введите 4 если хотите посмотреть КИИ ЦЕНОЙ МЕНЬШЕ введенной");
			System.out
					.println("Введите 5 если хотите СМЕНИТЬ ЦЕНУ ВСЕХ КИЕВ ИЗ введенного материала");
			System.out
					.println("Введите 6 если хотите СМЕНИТЬ МАТЕРИАЛ ВСЕХ КИЕВ ИЗ введенного материала на введенный");
			answer = in.nextInt();
			switch (answer) {
			case 0:
				System.out.println("Пока");
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
						.println("Введите цену меньше которой хотите посмотреть");
				price = in.nextInt();
				for (int i = 0; i < title.length; i++) {
					if (title[i].getPrice() < price) {
						System.out.println(title[i]);
					}
				}
				break;
			case 5:
				System.out
						.println("Введите материал которого хотите посмотреть");
				materials = in.next();
				System.out
						.println("Введите цену меньше на которую хотите поменять");
				price = in.nextInt();
				Material mat = Material.valueOf(materials.toUpperCase());
				for (int i = 0; i < title.length; i++) {
					if (title[i].getMaterial() == mat) {
						title[i].setPrice(price);
						System.out.print(title[i] + " ");
						System.out.println(title[i].getPrice() + " грн");
					}
				}
				break;
			case 6:
				System.out
						.println("Введите материал которого хатите посмотреть");
				materials = in.next();
				System.out
						.println("Введите материал на который хатите поменять");
				price = in.nextInt();
				Material mat1 = Material.valueOf(materials.toUpperCase());
				for (int i = 0; i < title.length; i++) {
					if (title[i].getMaterial() == mat1) {
						title[i].setPrice(price);
						System.out.print(title[i] + " ");
						System.out.println(title[i].getPrice() + " грн");
					}
				}
				break;
			default:
				System.out.println("Введите другое число");
				break;
			}
		}

	}

}
