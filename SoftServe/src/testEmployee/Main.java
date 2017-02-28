package testEmployee;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		Comparator<Employee> EComparator = new Comparator<Employee>() {
			@Override
			public int compare(Employee leftE, Employee rightE) {
				int deltaAverageMonthlySalary = -Double.compare(
						leftE.GetAverageMonthlySalary(),
						rightE.GetAverageMonthlySalary());

				return deltaAverageMonthlySalary == 0 ? rightE.getName()
						.compareTo(leftE.getName()) : deltaAverageMonthlySalary;
			}
		};

		List<Employee> list = new ArrayList<Employee>();
		list.add(new FixedPaymentEmployee("One", 9910));
		list.add(new FixedPaymentEmployee("Two", 7010));
		list.add(new FixedPaymentEmployee("Three", 3010));
		list.add(new FixedPaymentEmployee("Four", 3328));
		list.add(new FixedPaymentEmployee("Five", 2100));
		list.add(new HourlyEmployee(10, "Six"));
		list.add(new HourlyEmployee(20, "Seven"));
		list.add(new HourlyEmployee(15, "Eight"));
		list.add(new HourlyEmployee(10, "Nine"));
		Collections.sort(list, EComparator);
		// a)
		// Writing Collection
		System.out.println("________(a)__________\nCollection of employees");
		System.out.println(list);
		System.out.println();

		// b)
		// Writing Information about first five Employees in Collection
		System.out
				.println("________(b)__________\nInformation about first five employees in Collection");
		for (Employee employee : list.subList(0, 4)) {
			System.out.print(employee.getId() + " ");
			System.out.print(employee.getName() + " ");
			System.out.println(employee.GetAverageMonthlySalary());
		}
		System.out.println();

		// c)
		// Writing ID of three last employees in collection
		System.out
				.println("________(c)__________\nID of three last employees in collection");
		for (Employee employee : list.subList(list.size() - 3, list.size())) {
			System.out.print(employee.getId() + " ");
		}
		System.out.println();
		System.out.println();

		// d)
		// Writing collection of employees into file
		System.out
				.println("________(d)__________\nWriting and reading collection of employees (from) file");
		File file = new File("Employees.txt");
		try (OutputStream os = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(os)) {
			oos.writeObject(list);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Reading collection of employees from file
		List<Employee> list2 = new ArrayList<Employee>();
		if (file.exists()) {
			// e)
			try (InputStream is = new FileInputStream(file);
					ObjectInputStream ois = new ObjectInputStream(is)) {
				Object obj = ois.readObject();
				if (obj instanceof List) {
					list2 = (ArrayList<Employee>) obj;
					System.out.println(list2);
					for (Employee employee : list2) {
						System.out.print(employee.getId() + " ");
						System.out.print(employee.getName() + " ");
						System.out.println(employee.GetAverageMonthlySalary()
								+ " ");
					}

				}
			}
			// e
			catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

	}
}

interface Employee {

	public int getId();

	public String getName();

	public double GetAverageMonthlySalary();
}

abstract class EmployeeAbstract {
	protected static int ID = 0;
}

class HourlyEmployee extends EmployeeAbstract implements Employee, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3256582781939039305L;
	private int id;
	private String name;
	private int hourlyRate;

	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HourlyEmployee(int hourlyRate, String name) {
		super();
		this.hourlyRate = hourlyRate;
		this.id = ++EmployeeAbstract.ID;
		this.name = name;
	}

	public int getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(int hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	@Override
	public double GetAverageMonthlySalary() {
		return 20.8 * 8 * hourlyRate;
	}

	@Override
	public String toString() {
		return "HourlyEmployee [id=" + id + ", name=" + name + ", hourlyRate="
				+ hourlyRate + "]";
	}

}

class FixedPaymentEmployee extends EmployeeAbstract implements Employee,
		Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2320800491384748921L;
	private int id;
	private String name;
	private int FixedMonthlyPayment;

	public FixedPaymentEmployee(String name, int fixedMonthlyPayment) {
		super();
		this.name = name;
		FixedMonthlyPayment = fixedMonthlyPayment;
		this.id = ++EmployeeAbstract.ID;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFixedMonthlyPayment() {
		return FixedMonthlyPayment;
	}

	public void setFixedMonthlyPayment(int fixedMonthlyPayment) {
		FixedMonthlyPayment = fixedMonthlyPayment;
	}

	@Override
	public double GetAverageMonthlySalary() {
		return FixedMonthlyPayment;
	}

	@Override
	public String toString() {
		return "FixedPaymentEmployee [id=" + id + ", name=" + name
				+ ", FixedMonthlyPayment=" + FixedMonthlyPayment + "]";
	}

}