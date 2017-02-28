import java.util.Scanner;

public class Parne {
	public static void main(String[] args) {
		int ch = 5;
		if ((ch % 2) == 0)
			System.out.println("This number is even");
		else
			System.out.println("This number is odd");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number to parity check");
		ch = sc.nextInt();
		if ((ch % 2) == 0)
			System.out.println("This number is even");
		else
			System.out.println("This number is odd");
	}
}
