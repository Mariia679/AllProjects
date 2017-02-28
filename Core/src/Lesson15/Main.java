package Lesson15;

import java.util.ArrayList;
import java.util.List;

import Lesson3.Circle;
import Lesson3.Geometric;
import Lesson3.Rectangle;

public class Main {

	public static void main(String[] args) {

		// ��������� ��������� ����� ��� ������ <T>

		Container<String> container = new Container<>("Ivan");
		// System.out.println(((String)container.getElement()).);
		System.out.println(container.getElement());

		// �������� �� ������ Geometric
		List<Geometric> list = new ArrayList<>();
		// ����� � ��� � ��� ����� ��������
		// List<Rectangle> list = new ArrayList<>();
		list.add(new Rectangle(4, 3));
		add(list, new Circle(5));
		print(list);

	}

	// ����� ��������
	static void add(List<? super Geometric> list, Geometric geometric) {
		list.add(geometric);
	}

	// ����� ���������
	static void print(List<? extends Geometric> list) {
		for (Geometric geometric : list) {
			geometric.print();
		}
	}

}
