package MyException;

public class MyException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	@Override
	public void printStackTrace() {
		System.err.println("Произошло что-то непонятное!!!");
	}
	
	

}
