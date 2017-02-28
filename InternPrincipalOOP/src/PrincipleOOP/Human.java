package PrincipleOOP;

import java.util.Scanner;

public class Human {

	public static void main(String[] args) {

		// Создание объектов класса Refrigerator
		// Открытие холодильника
		Refrigerator open = new Refrigerator();
		Refrigerator open1 = new Refrigerator();
		Refrigerator open2 = new Refrigerator();

		Scanner in = new Scanner(System.in);
		/*
		 * Напрямую обратиться к полям класса не возможно так как они
		 * инкапсулированы Поэтому обращаемся через доступные методы Только
		 * открыв холодильник мы узнаем что внутри (то есть через его объект)
		 */
		System.out.println(open.getChiken());
		System.out.println(open.getEggs());
		System.out.println(open.getMilk());
		open.spoiledMilk();
		System.out.println(open.getMilk());

		// Так же можно положить в холодильник
		open.setChiken(1);
		open.setMilk(1);

		// Проверяем
		System.out.println(open.getChiken());
		System.out.println(open.getMilk());
		
		open.countOfOpens();

	}

}
