package DzInterface;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		FirstEmployee firstEmployee = new FirstEmployee();
		System.out.println("Please enter your wage-rate:");
		firstEmployee.setWageRate(in.nextDouble());
		System.out.println("Please enter how many hours you have worked:");
		firstEmployee.setHour(in.nextInt());
		System.out.print("First ");
		firstEmployee.print();
		Salary secondEmployee = new SecondEmployee();
		System.out.print("Second ");
		secondEmployee.print();
	
		
		
	}

}
