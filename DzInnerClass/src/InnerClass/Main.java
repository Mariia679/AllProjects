package InnerClass;

import InnerClass.Collection.EvenToOdd;
import InnerClass.Collection.FirstInner;
import InnerClass.Collection.SecondInner;

public class Main {

	public static void main(String[] args) {
		
		// First method of Inner Class
		
		Collection collection = new Collection();
		collection.setVaueLenght(10);
		Object[] array = new Object[collection.getVaueLenght()];
		System.out.println("First method of Inner Class");
		for (int i = 0; i < array.length; i++)
			array[i] = random(10, 20);
		collection.setValue(array);
		FirstInner firstInner = collection.new FirstInner();
		firstInner.hasNext();
		firstInner.next();
		firstInner.hasNext();
		
		// Second method of Inner Class
		
		Collection collection1=new Collection();
		collection1.setVaueLenght(10);
		Object[] array1=new Object[collection1.getVaueLenght()];
		System.out.println("Second method of Inner Class");
		for (int i = 0; i < array1.length; i++){
			array1[i] = random(10, 20);
			System.out.print(array1[i]+" ");
		}
		System.out.println();
		collection1.setValue(array1);
		SecondInner secondInner=collection1.new SecondInner();
		secondInner.hasNext();
		System.out.println("Anonymous class");
		secondInner.second.hasNext();
		System.out.println();
		
		//Static class
		
		System.out.println("Static class");
		Collection.EvenToOdd evenToOdd=new Collection.EvenToOdd();
		evenToOdd.even();
		System.out.println();
		
		//Local class
		System.out.println("Local class");
		Collection collection2 = new Collection();
		collection2.setVaueLenght(20);
		Object[] array2 = new Object[collection2.getVaueLenght()];
		for (int i = 0; i < array2.length; i++){
			array2[i] = random(0, 20);
			System.out.print(array2[i]+" ");
		}
		collection2.setValue(array2);
		System.out.println();
		collection2.odd();
		
	}

	static int random(int min, int max) {
		return (int) Math.round(Math.random() * (max - min) + min);
	}

}
