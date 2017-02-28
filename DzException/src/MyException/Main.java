package MyException;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IllegalAccessException {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter first number");
		int first = in.nextInt();
		System.out.println("Enter second number");
		int second = in.nextInt();
		Methods methods = new Methods(first, second);
		try {
			ifValueLessNull(first, second);
			System.out.println(	methods.division());
			System.out.println(methods.multiplication());
			System.out.println(methods.substraction());
			System.out.println(methods.sum());
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

	}

	static void ifValueLessNull(int first, int second)
			throws IllegalAccessException {
		if (first < 0 && second < 0)
			throw new IllegalArgumentException();
		if (first == 0 && second != 0)
			throw new ArithmeticException();
		if (first != 0 && second == 0)
			throw new ArithmeticException();
		if (first == 0 && second == 0)
			throw new IllegalAccessException();
		if (first > 0 && second > 0)
			throw new MyException();

	}

}
