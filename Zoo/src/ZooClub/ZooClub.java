package ZooClub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class ZooClub {

	private Map<Person, List<Pet>> zooClub = restore();

	private Set<Entry<Person, List<Pet>>> entrySet = zooClub.entrySet();

	public Scanner in = new Scanner(System.in);

	@SuppressWarnings("unchecked")
	private Map<Person, List<Pet>> restore() {
		File file = new File("save.bf");
		if (file.exists()) {
			try (ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream(file))) {
				return ((Map<Person, List<Pet>>) ois.readObject());
			} catch (IOException | ClassNotFoundException e) {
			}
		}
		return new HashMap<>();
	}

	private void save() {
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("save.bf"))) {
			oos.writeObject(zooClub);
			oos.flush();
		} catch (IOException e) {
		}
	}

	public void write(String fileName) {
		try (PrintWriter pw = new PrintWriter(new BufferedWriter(
				new FileWriter(fileName + ".txt")))) {
			for (Entry<Person, List<Pet>> iter : entrySet) {
				Person key = iter.getKey();
				List<Pet> pet = iter.getValue();
				Iterator<Pet> iterPet = pet.iterator();
				pw.print(key.getName() + " " + key.getAge() + " "
						+ key.getGender() + " :");
				while (iterPet.hasNext()) {
					Pet pet1 = iterPet.next();
					pw.print(pet1.getAge() + "-" + pet1.getAnimal() + "-");

				}
				pw.println();
			}

			pw.flush();
		} catch (IOException e) {
		}
	}

	public void restore(String fileName) {
		File file = new File(fileName + ".txt");
		if (file.exists()) {
			try (BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(file)))) {
				Map<Person, List<Pet>> list = new HashMap<>();
				while (br.ready()) {
					String line = br.readLine();
					if (!line.isEmpty()) {
						String[] array = line.split("\\:");
						String s1 = array[0];
						System.out.println(s1);
						String[] array1 = s1.split("\\ ");
						Person p = new Person(array1[0],
								Integer.valueOf(array1[1]),
								Gender.valueOf(array1[2]));
						list.put(p, new ArrayList<>());
						String s2 = array[1];
						System.out.println(s2);
						String[] array2 = s2.split("-");
						for (int i = 0; i < array2.length - 1; i += 2) {
							list.get(p).add(
									new Pet(Integer.valueOf(array2[i]),
											array2[i + 1]));
						}
					}
				}
				zooClub = list;
				save();
				br.close();
			} catch (IOException e) {

			}
			
		}
	}

	public Map<Person, List<Pet>> getZooClub() {
		return zooClub;
	}

	public void setZooClub(Map<Person, List<Pet>> zooClub) {
		this.zooClub = zooClub;
	}

	public void addMember() {
		System.out.println("Enter name");
		String name = in.next();
		System.out.println("Enter age");
		int age = in.nextInt();
		System.out.println("Enter male");
		String male = in.next();
		Gender gender = Gender.valueOf(male.toUpperCase());
		zooClub.put(new Person(name, age, gender), new ArrayList<>());
		save();
	}

	public void addAnimalForMember() {
		String name;
		int age;
		String animal;
		System.out.println("Enter person name");
		name = in.next();
		for (Entry<Person, List<Pet>> iter : entrySet) {
			Person key = iter.getKey();
			if (key.getName().equals(name)) {
				System.out.println("Enter pet age");
				age = in.nextInt();
				System.out.println("Enter what kind of animal do you want");
				animal = in.next();
				zooClub.get(key).add(new Pet(age, animal));
				save();
			}
		}
	}

	public void deleteMember() {
		String name;
		System.out.println("Enter person name");
		name = in.next();
		Iterator<Person> keys = zooClub.keySet().iterator();
		while (keys.hasNext()) {
			Person person1 = keys.next();
			if (person1.getName().equals(name)) {
				keys.remove();
				save();
			}
		}
	}

	public void deletePetFromAllMembers() {
		String name;
		System.out.println("Enter pet name ");
		name = in.next();
		for (Entry<Person, List<Pet>> iter : entrySet) {
			List<Pet> pet = iter.getValue();
			Iterator<Pet> iterPet = pet.iterator();
			for (; iterPet.hasNext();) {
				Pet pet1 = iterPet.next();
				if (pet1.getAnimal().equals(name)) {
					iterPet.remove();
					save();
				}
			}
		}
	}

	public void deletePetFromMember() {
		System.out.println("Enter name ");
		String name = in.next();
		System.out.println("Enter what kind of animal");
		String namePet = in.next();
		for (Entry<Person, List<Pet>> iter : entrySet) {
			Person key = iter.getKey();
			List<Pet> pet = iter.getValue();
			Iterator<Pet> iterPet = pet.iterator();
			for (; iterPet.hasNext();) {
				Pet pet1 = iterPet.next();
				if (pet1.getAnimal().equals(namePet)
						&& key.getName().equals(name)) {
					iterPet.remove();
					save();
				}
			}
		}
	}

	public void showZooClub() {
		for (Entry<Person, List<Pet>> entry : entrySet) {
			Person key = entry.getKey();
			System.out.print(key);
			for (Pet pet : entry.getValue()) {
				System.out.print(" -> " + pet);
			}
			System.out.println();
		}
	}

	/*
	 * @Override public int hashCode() { final int prime = 31; int result = 1;
	 * result = prime * result + ((entrySet == null) ? 0 : entrySet.hashCode());
	 * result = prime * result + ((zooClub == null) ? 0 : zooClub.hashCode());
	 * return result; }
	 * 
	 * @Override public boolean equals(Object obj) { if (this == obj) return
	 * true; if (obj == null) return false; if (getClass() != obj.getClass())
	 * return false; ZooClub other = (ZooClub) obj; if (entrySet == null) { if
	 * (other.entrySet != null) return false; } else if
	 * (!entrySet.equals(other.entrySet)) return false; if (zooClub == null) {
	 * if (other.zooClub != null) return false; } else if
	 * (!zooClub.equals(other.zooClub)) return false; return true; }
	 */

	@Override
	public String toString() {
		return "ZooClub [zooClub=" + zooClub + ", entrySet=" + entrySet + "]";
	}

}
