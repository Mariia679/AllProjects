package Lesson6;

import java.util.Scanner;
import static Lesson6.Season.*;

public class Main {

	public static void main(String[] args) {
		Person person = new Person("Ivan", 18, Gender.MALE);
		Gender gender = Gender.MALE;

		System.out.println(Gender.MALE == Gender.MALE);
		System.out.println(Gender.MALE == gender);
		System.out.println(Gender.MALE == person.getGender());

		Month[] months = Month.values();
		for (int i = 0; i < months.length; i++) {
			System.out.println(months[i]);
		}

		String monthName = "may";
		Month month = Month.valueOf(monthName.toUpperCase());
		System.out.println(month);

		System.out.println(month.compareTo(Month.APRIL));
		System.out.println(month.ordinal());
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("Enter 1 to show month by season");
			System.out.println("Enter 2 to show month by count of days");
			switch (in.next()) {
			case "1":
				System.out.println("Enter season");
				String season = in.next();
				Season season1 = Season.valueOf(season.toUpperCase());
				for (int i = 0; i < months.length; i++) {
					if (months[i].getSeason() == season1) {
						System.out.println(months[i]);
					}
				}
				break;
			case "2":
				System.out.println("Enter count of day");
				int countDay = in.nextInt();
				for (int i = 0; i < months.length; i++) {
					if (months[i].getDays() == countDay) {
						System.out.println(months[i]);
					}
				}
				break;
			default:
				break;
			}
		}
	}

	public void months(Season[] season, String season1) {
		for (int i = 0; i < season.length; i++) {
			System.out.println(season[i]);
		}
	}

}
