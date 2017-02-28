package Lesson12;

public class MyException extends RuntimeException {

	private static final long serialVersionUID = -3271577205100231705L;

	@Override
	public void printStackTrace() {
		System.err.println("Сам догадайся что случилось и где ошибка");
	}

	
}
