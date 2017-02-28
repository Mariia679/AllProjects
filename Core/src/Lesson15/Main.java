package Lesson15;

import java.util.ArrayList;
import java.util.List;

import Lesson3.Circle;
import Lesson3.Geometric;
import Lesson3.Rectangle;

public class Main {

	public static void main(String[] args) {

		// Дженереки принимает любой тип данных <T>

		Container<String> container = new Container<>("Ivan");
		// System.out.println(((String)container.getElement()).);
		System.out.println(container.getElement());

		// Дженерик по классу Geometric
		List<Geometric> list = new ArrayList<>();
		// Можно и так и так будет работать
		// List<Rectangle> list = new ArrayList<>();
		list.add(new Rectangle(4, 3));
		add(list, new Circle(5));
		print(list);

	}

	// Метод продюсер
	static void add(List<? super Geometric> list, Geometric geometric) {
		list.add(geometric);
	}

	// Метод консъюмер
	static void print(List<? extends Geometric> list) {
		for (Geometric geometric : list) {
			geometric.print();
		}
	}

}
