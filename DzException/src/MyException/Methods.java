package MyException;

public class Methods {

	private int first;

	private int second;

	public Methods(int first, int second) {
		this.first = first;
		this.second = second;
	}
	
	public int multiplication(){
		return first*second;
	}
	public int sum(){
		return first+second;
	}
	public int division(){
		return first/second;
	}
	public int substraction(){
		return first-second;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

}
