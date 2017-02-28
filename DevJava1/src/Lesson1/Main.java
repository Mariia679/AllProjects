package Lesson1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello");
		int integer = 55555;
		boolean bool = false;
		if (integer < 0) {
			System.out.println("true");
		} else if (bool) {
			System.out.println("false");
		} else {
			System.out.println("Second else");
		}
		double a = 2;
		double b = 6;
		double c = 4;
		double D = b * b - 4 * a * c;
		if (D < 0) {
			System.out.println("Нет решений");
		} else if (D > 0) {
			System.out.println("x1 = " + ((-b - Math.sqrt(D)) / (2 * a)));
			System.out.println("x2 = " + ((-b + Math.sqrt(D)) / (2 * a)));
		} else {
			System.out.println((-b / 2 * a));
		}
		Scanner in=new Scanner(System.in);
		System.out.println("Enter number ");
		int result=in.nextInt();
		System.out.println(result);

	}

}
