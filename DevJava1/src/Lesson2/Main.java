package Lesson2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int i = 0;
		switch (i) {
		case 0:
			System.out.println("Zero");
			break;
		case 1:
			System.out.println("One");
			break;
		case 2:
			System.out.println("Two");
			break;
		default:
			break;
		}
		while (i < 10) {
			System.out.println(i++);
		}
		do {
			System.out.println(++i);
		} while (i < 10);

		for (int j = 0; j < 10; j++) {
			System.out.println(j);
		}
		hello();
		int s = increment(i);
		System.out.println(s);
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number");
		double b = in.nextDouble();
		System.out.println("Enter the number");
		double c = in.nextDouble();
		double add = add(b, c);
		System.out.println(add);
		System.out.println("Enter what you want to do");
		System.out.println("0-exit,1-add,2-susbstraction,3-mnozhennya,4-dilennya,5-pomodylu");
		int f = in.nextInt();
		double g=calculate(b,c,f);
		System.out.println(g);
		System.out.println("+-add,- -susbstraction,*-mnozhennya,/-dilennya,%-pomodylu");
		g=calculat(b,c,'+');
		System.out.println(g);
		g=calculat(b,c,'-');
		System.out.println(g);
		g=calculat(b,c,'*');
		System.out.println(g);
		g=calculat(b,c,'/');
		System.out.println(g);
		g=calculat(b,c,'%');
		System.out.println(g);
	}

	
	static void hello() {
		System.out.println("Hello!");
	}

	static int increment(int i) {
		i++;
		return i;
	}

	static double add(double b, double c) {
		return b + c;
	}

	static double del(double b, double c) {
		return b / c;
	}

	static double vid(double b, double c) {
		return b - c;
	}

	static double mnozh(double b, double c) {
		return b * c;
	}

	static double pomod(double b, double c) {
		return b % c;
	}
	static double calculate(double b, double c,int i){
		double add=0;
		switch (i) {
		case 0:
			System.out.println("Bye!");
			return 0;
		case 1:
			add = add(b, c);
			return add;
		case 2:
			add =  vid(b, c);
			return add;
		case 3:
			add =mnozh(b, c);
			return add;
		case 4:
			add = del(b, c);
			return add;
		case 5:
			add = pomod(b, c);
			return add;
		default:
			calculate(b,c,i);
			return 0;
		}
	}
	static double calculat(double b, double c,char i){
		double add=0;
		switch (i) {
		case '+':
			add = add(b, c);
			return add;
		case '-':
			add =  vid(b, c);
			return add;
		case '*':
			add =mnozh(b, c);
			return add;
		case '/':
			add = del(b, c);
			return add;
		case '%':
			add = pomod(b, c);
			return add;
		default:
			calculat(b,c,i);
			return 0;
		}
	}
}
