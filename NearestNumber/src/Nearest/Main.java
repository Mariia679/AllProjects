package Nearest;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		double ch = 25;
		double num = 54;
		if (num > ch)
			System.out.println("First number is nearest to 10 then second");
		else
			System.out.println("Second number nearest to 10 then first");
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number ONE");
		ch = in.nextDouble();
		System.out.println("Enter the number TWO");
		num = in.nextDouble();
		num-=10;
		ch-=10;
		if (num < 0)
			num *= -1;
		if (ch < 0)
			ch *= -1;
		if (num > ch)
			System.out.println("First number is nearest to 10 then second");
		else if (num == ch)
			System.out.println("Both of numbers are at the same distance");
		else
			System.out.println("Second number nearest to 10 then first");
	}

}
