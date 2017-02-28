package Constructor;

public class Rectangle {
	double width;
	double length;

	Rectangle() {
		width = 5.3;
		length = 6.4;
	}

	Rectangle(double width, double length) {
		this.width = width;
		this.length = length;
	}
	
	double area(double width, double length){
		double area=0;
		area=width*length;
		return area;
	}
	double perimeter(double width, double length){
		double perimeter=0;
		perimeter=(width+length)*2;
		return perimeter;
	}
}
