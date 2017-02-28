package DzInterface;

public interface Salary {
	double salary();
	public default void print(){
		System.out.println("employee earned = "+this.salary());
	}
}
