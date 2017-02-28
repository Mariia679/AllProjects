package Dz;

import java.util.Scanner;

public class Method {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out
				.println("Enter the number what would you like to calculate the amount of numbers");
		System.out.println(sum(in.nextInt()));
		System.out
				.println("Enter the range of numbers from and to the amount that you want to count");
		System.out.println(sum(in.nextInt(), in.nextInt()));
		System.out.println("Enter the number you want to check the parity");
		even(in.nextInt());
		System.out.println("Enter the two numbers between 1 to 10");
		loop(in.nextInt(), in.nextInt(), '*');
		array();
		fib();
		triangle();
		System.out.println();
		triangle1();
		System.out.println("Enter two number to check what number larger");
		ternary(in.nextInt(), in.nextInt());
		System.out.println("Enter a number of elements in the array");
		int c = in.nextInt();
		int a = arraysum(c);
		System.out.println("");
		System.out.println("The sum of the elements in the array " + a + ";");
		System.out.println("The arithmetic mean of the array " + average(a, c)
				+ ";");
		System.out.println("Enter the number, the symbol will return");
		System.out.println(revers(in.nextInt()));
		System.out.println(fact(5));

	}

	static int fact(int a) {
		if (a == 1)
			return 1;
		System.out.println(a);
		return a * fact(a - 1);
	}

	static int sum(int a) {
		int sum = 0;
		for (; a > 0; a /= 10)
			sum += a % 10;
		return sum;
	}

	static int sum(int a, int b) {
		int sum1 = 0;
		for (int i = a; i <= b; i++)
			sum1 += i;
		return sum1;
	}

	static void even(int a) {
		if (evenbool(a))
			System.out.println("Even number");
		else
			System.out.println("Odd number");
	}

	static boolean evenbool(int a) {
		if (a % 2 == 0)
			return true;
		else
			return false;
	}

	static void loop(int a, int c, char b) {
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(b);
			}
			System.out.println("");
		}
	}

	static void array() {
		for (int i = 0; i < 4; i++) {
			System.out.print(i + 1);
			for (int j = 0; j < 3; j++) {
				System.out.printf("%4d", (j * 4 + i + 5));
			}
			System.out.println("");
		}
	}

	static int fib(int x) {
		if (x < 2)
			return 1;
		else
			return fib(x - 1) + fib(x - 2);
	}

	static void fib() {
		for (int i = 0; i < 11; i++) {
			System.out.printf("%3d", fib(i));
		}
		for (int i = 11; i < 20; i++) {
			System.out.printf("%5d", fib(i));
		}
		for (int i = 20; i < 30; i++) {
			System.out.printf("%7d", fib(i));
		}
		for (int i = 30; i < 40; i++) {
			System.out.printf("%10d", fib(i));
		}
	}

	static void triangle() {
		for (int i = 0; i < 8; i++) {
			for (int j = i; j >= 0; j--) {
				System.out.print(j + 1);
			}
			System.out.println("");
		}
	}

	static void triangle1() {
		for (int i = 0; i < 8; i++) {
			for (int j = 8; j > i; j--) {
				System.out.print(j);
			}
			System.out.println("");
		}
	}

	static void ternary(int a, int b) {
		System.out.println((a == b) ? "First equal to the second"
				: (a > b) ? "The first larger than second"
						: "Second larger than first");
	}

	static int arraysum(int a) {
		int[] array = new int[a];
		int sum = 0;
		for (int i = 0; i < array.length; i++)
			array[i] = (int) Math.round((Math.random() * 30) - 5);

		for (int i = 0; i < array.length; i++)
			System.out.printf("%5d", array[i]);
		for (int i = 0; i < array.length; i++)
			sum += array[i];
		System.out.println("");
		System.out.println("Minimal element of array "
				+ min(array, array.length));
		System.out.print("Max element of array " + max(array, array.length));
		return sum;
	}

	static int average(int sum, int c) {
		return sum / c;
	}

	static int min(int[] array, int c) {
		int min = 20;
		for (int i = 0; i < c; i++) {
			if (min > array[i])
				min = array[i];
		}
		return min;
	}

	static int max(int[] array, int c) {
		int max = -20;
		for (int i = 0; i < c; i++) {
			if (max < array[i])
				max = array[i];
		}
		return max;
	}

	static char revers(int a) {
		char b = (char) a;
		return b;
	}
}
