package DzLoop;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		loop1();
		loop2();
		System.out.println(" ");
		loop3();
		System.out.println(" ");
		loop4();
		System.out.println(" ");
		loop5();
		System.out.println(" ");
		loop6();
		System.out.println(" ");
		System.out.println("Enter the number ");
		Scanner in = new Scanner(System.in);
		double b = in.nextDouble();
		double factorial = factorial(b);
		System.out.println(factorial);
		System.out.println("Enter the number ");
		int ch = in.nextInt();
		div(ch);

	}

	static void loop1() {
		for (int i = 1000; i < 10000; i += 3)
			System.out.println(i);
	}

	static void loop2() {
		for (int i = 1; i < 55 * 2; i += 2)
			System.out.print(i + " ");
	}

	static void loop3() {
		for (int i = 90; i > -1; i -= 5)
			System.out.print(i + " ");
	}

	static void loop4() {
		int count = 20;
		for (int i = 2; count > 0; i *= 2, count--)
			System.out.print(i + " ");
	}

	static void loop5() {
		for (int i = 2; i < 10000; i = 2 * i - 1)
			System.out.print(i + " ");
	}

	static void loop6() {
		for (int i = -166; i < 100; i = 2 * i + 200) {
			if (i > -100)
				System.out.print(i + " ");
		}
	}

	static double factorial(double b) {
		if (b == 1)
			return 1;
		return b * (factorial(b - 1));
	}

	static void div(int ch) {
		int dil;
		for (int i = ch; i > 0; i--) {
			dil = ch % i;
			if (dil == 0)
				System.out.println(i);
		}
	}

}
