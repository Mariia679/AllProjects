package Pet;

public class Pet {
	String color;
	double height;
	double weight;
	int age;
	public static void eat(){
		System.out.println("I want to eat");
	}
	public void sleep(){
		System.out.println("Good night");
	}
	public String say(String word){
		String petWord="Hello "+ word;
		return petWord;
	}
}
