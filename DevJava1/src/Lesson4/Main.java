package Lesson4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int[] array = new int[10];
		print(array);
		// 1
		Scanner in = new Scanner(System.in);
		System.out.println("Enter two number");
		add(array, in.nextInt(), in.nextInt());
		print(array);
		// 2
		System.out.println("Enter two number");
		int[] array1 = zap(15, in.nextInt(), in.nextInt());
		print(array1);
		// 3
		int[] array2 = zap1(array, 3);
		print(array2);

	}
	static int random(int min, int max) {
		return (int) Math.round(Math.random() * (max - min) + min);
	}

	static void print(int[] array) {
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}

	static void add(int[] array, int min, int max) {
		for (int i = 0; i < array.length; i++)
			array[i] = random(min, max);
	}

	static int[] zap(int length, int min, int max) {
		int[] array = new int[length];
		add(array, min, max);
		return array;
	}

	static int[] zap1(int[] array, int c) {
		int[] array1 = new int[array.length + c];
		for (int i = 0; i < array.length; i++) {
			array1[i] = array[i];
		}
		for (int i = array.length; i < array1.length; i++) {
			array1[i] = random(10, 20);
		}
		return array1;
	}

}
