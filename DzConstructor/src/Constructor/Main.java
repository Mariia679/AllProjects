package Constructor;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Rectangle rectangle = new Rectangle();
		System.out.println("������� ������ � ������ ��������������");
		Rectangle rectangle1 = new Rectangle(in.nextDouble(), in.nextDouble());
		System.out.println("����� ������������ � ��������� �����������(������ "+rectangle.width+" ������ "+rectangle.length+" ) = "+rectangle.area(rectangle.width, rectangle.length));
		System.out.println("����� ������������ � ��������� �����������(������ "+rectangle1.width+" ������ "+rectangle1.length+" ) = "+rectangle1.area(rectangle1.width, rectangle1.length));
		System.out.println("�������� ������������ � ��������� �����������(������ "+rectangle.width+" ������ "+rectangle.length+" ) = "+rectangle.perimeter(rectangle.width, rectangle.length));
		System.out.println("�������� ������������ � ��������� �����������(������ "+rectangle1.width+" ������ "+rectangle1.length+" ) = "+rectangle1.perimeter(rectangle1.width, rectangle1.length));
	}
}
