package Jenerik;

public class Main {

	public static void main(String[] args) {
		MyMap<Integer, String> map=new MyMap<>();
		map.put(5, "Ivan");
		map.put(5, "assdf");
		map.put(5, "Ivarhjkjn");
		map.put(6, "Gjbhdf");
		map.put(6, "Ivan");
		map.put(2, "fhdfhf");
		System.out.println(map);
		map.deleteKey(5);
		System.out.println(map);
		map.deleteValue("Ivan");
		System.out.println(map);
		map.showKey();
		System.out.println();
		map.showValue();
		System.out.println();
		map.showAll();

	}

}
