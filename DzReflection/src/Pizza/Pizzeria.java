package Pizza;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Pizzeria {

	public static void main(String[] args) throws ReflectiveOperationException {

		// BACON

		Class<?> pizzeriaClassBacon = Class.forName("Pizza.PizzaBacon");
		for (Field field : pizzeriaClassBacon.getDeclaredFields()) {
			System.out.println(field.getName());
			System.out.println(field.getAnnotatedType());
			System.out.println(field.getModifiers());
			System.out.println(field.getClass());
			System.out.println(field.getType());
		}

		System.out.println();
		Pizza pizzaBacon = new PizzaBacon();
		System.out.println(pizzaBacon);

		Field priceBaconField = pizzeriaClassBacon
				.getDeclaredField("priceBacon");
		priceBaconField.setAccessible(true);

		Object priceBacon = priceBaconField.get(pizzaBacon);
		System.out.println(priceBacon);
		System.out.println();

		Object pizzaBacon1 = pizzeriaClassBacon.newInstance();
		System.out.println(pizzaBacon1);

		priceBaconField.set(pizzaBacon1, priceBacon);
		System.out.println(pizzaBacon1);

		Method getPriceBacon = pizzeriaClassBacon.getMethod("getPriceBacon");

		priceBacon = getPriceBacon.invoke(pizzaBacon);
		System.out.println(priceBacon);

		Method setPriceBacon = pizzeriaClassBacon.getMethod("setPriceBacon",
				int.class);

		Object pizzaBacon2 = pizzeriaClassBacon.newInstance();
		setPriceBacon.invoke(pizzaBacon2, 23);
		System.out.println(pizzaBacon2);
		System.out.println(pizzeriaClassBacon);
		pizzaBacon.cut();

		// MUSHROOMS

		System.out.println();
		Class<?> pizzeriaClassMushrooms = Class.forName("Pizza.PizzaMushrooms");
		for (Field field : pizzeriaClassMushrooms.getDeclaredFields()) {
			System.out.println(field.getName());
			System.out.println(field.getAnnotatedType());
		}

		System.out.println();
		Pizza pizzaMushrooms = new PizzaMushrooms.Builder().priceMushrooms(20)
				.build();
		System.out.println(pizzaMushrooms);

		Field priceMushroomsField = pizzeriaClassMushrooms
				.getDeclaredField("priceMushrooms");
		priceMushroomsField.setAccessible(true);

		Object priceMushrooms = priceMushroomsField.get(pizzaMushrooms);
		System.out.println(priceMushrooms);
		System.out.println();

		Object pizzaMushrooms1 = pizzeriaClassMushrooms.newInstance();
		System.out.println(pizzaMushrooms1);

		priceMushroomsField.set(pizzaMushrooms1, priceMushrooms);
		System.out.println(pizzaMushrooms1);

		Method getPriceMushrooms = pizzeriaClassMushrooms
				.getMethod("getPriceMushrooms");

		priceMushrooms = getPriceMushrooms.invoke(pizzaMushrooms);
		System.out.println(priceMushrooms);

		Method setPriceMushrooms = pizzeriaClassMushrooms.getMethod(
				"setPriceMushrooms", int.class);

		Object pizzaMushrooms2 = pizzeriaClassMushrooms.newInstance();
		setPriceMushrooms.invoke(pizzaMushrooms2, 14);
		System.out.println(pizzaMushrooms2);

	}

}
