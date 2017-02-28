package Lesson5a;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int[][] array = new int[3][3];
		Scanner in = new Scanner(System.in);
		long l=0;
		String s=new String();
		s=Long.toString(l);
		System.out.println(s);
		while (true) {
			user(array, in);
			print(array);
			if (whoWins(array, 1)) {
				System.out.println("User win");
				break;
			}
			if (isDraw(array)) {
				System.out.println("Draw");
				break;
			}

			System.out.println();
			comp(array);
			print(array);
			if (whoWins(array, 2)) {
				System.out.println("User CPU");
				break;
			}
		}

	}

	static boolean isDraw(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i][j] == 0)
					return false;
			}
		}
		return true;
	}

	static boolean whoWins(int[][] array, int n) {
		if (array[0][0] == n && array[0][1] == n && array[0][2] == n)
			return true;
		if (array[1][0] == n && array[1][1] == n && array[1][2] == n)
			return true;
		if (array[2][0] == n && array[2][1] == n && array[2][2] == n)
			return true;
		if (array[0][0] == n && array[1][0] == n && array[2][0] == n)
			return true;
		if (array[0][1] == n && array[1][1] == n && array[2][1] == n)
			return true;
		if (array[0][2] == n && array[2][1] == n && array[2][2] == n)
			return true;
		if (array[0][0] == n && array[1][1] == n && array[2][2] == n)
			return true;
		if (array[2][0] == n && array[1][1] == n && array[2][0] == n)
			return true;
		return false;
	}

	static void comp(int[][] array) {
		int x = random(0, 2);
		int y = random(0, 2);
		if (array[y][x] == 0)
			array[y][x] = 2;
		else
			comp(array);

	}

	static void user(int[][] array, Scanner in) {
		System.out.println("Enter x 1-3:");
		int x = in.nextInt() - 1;
		System.out.println("Enter y 1-3:");
		int y = in.nextInt() - 1;
		array[y][x] = 1;
	}

	static void print(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] == 0)
					System.out.print(" - ");
				if (array[i][j] == 1)
					System.out.print(" X ");
				if (array[i][j] == 2)
					System.out.print(" 0 ");

			}
			System.out.println();
		}
	}

	static int random(int min, int max) {
		return (int) Math.round(Math.random() * (max - min) + min);
	}
}
