package ZooClub;

import java.util.Scanner;

public class Main {

	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		
		ZooClub zooClub=new ZooClub();

		while (true) {
			System.out.println("Enter 1 to add member of club");
			System.out.println("Enter 2 to add animal for club members");
			System.out.println("Enter 3 to delete animal for club members");
			System.out.println("Enter 4 to delete member of club");
			System.out
					.println("Enter 5 to delete certain animal from all club members");
			System.out.println("Enter 6 to show zooclub");
			System.out.println("Enter 7 to save to notepad");
			System.out.println("Enter 8 to restore from text file");
			System.out.println("Enter 0 to exit the program");
			switch (in.next()) {
			case "1":
				zooClub.addMember();
				break;
			case "2":
				zooClub.addAnimalForMember();
				break;
			case "3":
				zooClub.deletePetFromMember();
				break;
			case "4":
				zooClub.deleteMember();
				break;
			case "5":
				zooClub.deletePetFromAllMembers();
				break;
			case "6":
				zooClub.showZooClub();
				break;
			case "7":
				System.out.println("Enter file name");
				zooClub.write(in.next());
				break;
			case "8":
				System.out.println("Enter file name");
				zooClub.restore(in.next());
				break;
			default:
				System.out.println("Bye");
				in.close();
				return;
			}
		}
	}

	
}
