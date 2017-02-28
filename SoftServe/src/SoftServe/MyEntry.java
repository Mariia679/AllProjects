package SoftServe;

public class MyEntry {
	public static void main(String[] args) {

		Customer customer = new Customer("Ivan", new Rental(6, 7));
		System.out.println(customer.amountFor());
	}
}

class Customer {
	private String name;
	//
	private Rental rental;

	// Other fields, constructors, get, set, etc.
	//
	public Customer(String name, Rental rental) {
		this.name = name;
		this.rental = rental;
	}

	public Rental getRental() {
		return rental;
	}

	public void setRental(Rental rental) {
		this.rental = rental;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//
	public double amountFor() {
		return rental.amountFor();
	}

}

class Rental {
	private int kind;
	private int days;

	// Other fields, constructors, get, set, etc.
	//
	public Rental(int kind, int days) {
		this.kind = kind;
		this.days = days;
	}

	public int getKind() {
		return kind;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public double getBasePrice() {
		return 7;
		// Calculation of Price.
		// Other methods.
	}

	// 
	public double amountFor() {
		double result;
		result = days * getBasePrice();
		if (kind < 7) {
			switch (kind) {
			case 1:
				return result * 1.5;
			case 2:
				return result * 2;
			case 3:
				return result * 2.5;
			}
		} else {
			return result * 3;
		}
		return result;
	}
}
