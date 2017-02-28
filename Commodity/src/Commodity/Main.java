package Commodity;

import static java.util.Comparator.comparing;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

	private static final List<Commodity> product = new ArrayList<>();
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		product.add(new Commodity("Iphone", "black", 33, 16999));
		product.add(new Commodity("Iphone7", "pink", 35, 27999));
		product.add(new Commodity("MacBook", "grey", 1030, 32699));
		product.add(new Commodity("MacBookAir", "grey", 1300, 27999));
		product.add(new Commodity("Samsung", "white", 54.6, 18555));
		product.add(new Commodity("Ipad", "white", 325.7, 12999));
		product.add(new Commodity("Samsung", "white", 54.6, 18999));
		
		int answer = 1;
		int answer1 = 1;

		while (answer > 0) {
			System.out.println("Enter 1 to add a product");
			System.out.println("Enter 2 to delete product by price");
			System.out.println("Enter 3 to delete product by color");
			System.out.println("Enter 4 to replace product by name");
			System.out.println("Enter 5 to sort product");
			System.out.println("Enter 0 to exit");
			switch (answer = in.nextInt()) {
			case 0:
				System.out.println("See you, bye!!!");
				break;
			case 1:
				addProduct();
				break;
			case 2:
				deleteProductByPrice();
				break;
			case 3:
				deleteProductByColor();
				break;
			case 4:
				replaceProductByName();
				break;
			case 5:
				while (answer1 > 0) {
					System.out.println("Enter 1 to sort by name");
					System.out.println("Enter 2 to sort by color");
					System.out.println("Enter 3 to sort by price");
					System.out.println("Enter 4 to sort by weight");
					System.out.println("Enter 0 to exit");
					switch (answer1 = in.nextInt()) {
					case 0:
						break;
					case 1:
						switch (enterNumber()) {
						case 1:
							sortByNameAsc().forEach(System.out::println);
							break;
						case 2:
							sortByNameDesc().forEach(System.out::println);
							break;
						default:
							break;
						}
						break;
					case 2:
						switch (enterNumber()) {
						case 1:
							sortByColorAsc().forEach(System.out::println);
							break;
						case 2:
							sortByColorDesc().forEach(System.out::println);
							break;
						default:
							break;
						}
						break;
					case 3:
						switch (enterNumber()) {
						case 1:
							sortByPriceAsc().forEach(System.out::println);
							break;
						case 2:
							sortByPriceDesc().forEach(System.out::println);
							break;
						default:
							break;
						}
						break;
					case 4:
						switch (enterNumber()) {
						case 1:
							sortByWeightAsc().forEach(System.out::println);
							break;
						case 2:
							sortByWeightDesc().forEach(System.out::println);
							break;
						default:
							break;
						}
						break;
					default:
						break;
					}
				}
				break;
			default:
				break;
			}
		}

	}

	static int enterNumber() {
		System.out.println("Enter 1 to sort asc");
		System.out.println("Enter 2 to sort desc");
		return in.nextInt();
	}

	static void addProduct() {
		System.out.println("Enter name product");
		String name = in.next();
		System.out.println("Enter color product");
		String color = in.next();
		System.out.println("Enter weight of product");
		double weight = in.nextDouble();
		System.out.println("Enter price of product");
		double price = in.nextDouble();
		product.add(new Commodity(name, color, weight, price));

		product.forEach(System.out::println);
	}

	static void deleteProductByPrice() {
		System.out.println("Enter price");
		double price = in.nextDouble();
		Iterator<Commodity> iter = product.iterator();
		while (iter.hasNext()) {
			Commodity product = iter.next();
			if (product.getPrice() == price) {
				iter.remove();
			}
		}
		product.forEach(System.out::println);
	}

	static void deleteProductByColor() {
		System.out.println("Enter color");
		String color = in.next();
		Iterator<Commodity> iter = product.iterator();
		while (iter.hasNext()) {
			Commodity product = iter.next();
			if (product.getColor().equals(color)) {
				iter.remove();
			}
		}
		product.forEach(System.out::println);
	}

	static void replaceProductByName() {
		System.out.println("Enter name");
		String name = in.next();
		Iterator<Commodity> iter = product.iterator();
		while (iter.hasNext()) {
			Commodity product = iter.next();
			if (product.getName().equals(name)) {
				System.out.println("Enter color");
				product.setColor(in.next());
				System.out.println("Enter name");
				product.setName(in.next());
				System.out.println("Enter weight");
				product.setWeight(in.nextDouble());
				System.out.println("Enter price");
				product.setPrice(in.nextDouble());

			}
		}
		product.forEach(System.out::println);
	}

	static Stream<Commodity> sortByNameAsc() {
		return product.stream().sorted();
	}

	static Stream<Commodity> sortByNameDesc() {
		return product.stream().sorted(
				(o1, o2) -> o2.getName().compareTo(o1.getName()));
	}

	static Stream<Commodity> sortByColorAsc() {
		return product.stream().sorted(comparing(Commodity::getColor));
	}

	static Stream<Commodity> sortByColorDesc() {
		return product.stream().sorted(
				comparing(Commodity::getColor).reversed());
	}

	static Stream<Commodity> sortByWeightAsc() {
		return product.stream().sorted(comparing(Commodity::getWeight));
	}

	static Stream<Commodity> sortByWeightDesc() {
		return product.stream().sorted(
				comparing(Commodity::getWeight).reversed());
	}

	static Stream<Commodity> sortByPriceAsc() {
		return product.stream().sorted(comparing(Commodity::getPrice));
	}

	static Stream<Commodity> sortByPriceDesc() {
		return product.stream().sorted(
				comparing(Commodity::getPrice).reversed());
	}

	static Stream<Commodity> sortByAllAsc() {
		return product.stream().sorted(
				comparing(Commodity::getName)
						.thenComparing(comparing(Commodity::getColor))
						.thenComparing(comparing(Commodity::getWeight))
						.thenComparing(comparing(Commodity::getPrice)));
	}
}
