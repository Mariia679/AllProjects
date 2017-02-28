package Lesson7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		//Добавляет элемент
		
		list.add("Ivan");
		list.add("Petro");
		list.add(1, "Mykola");
		
		System.out.println(list);
		
		//Возврашает true или false усли такой элемент есть
		System.out.println(list.contains("Ivan"));
		
		System.out.println(list.containsAll(list));
		
		//Проходит по всем эелементам и записывает в столбик
		//Передача по ссылки эти :: !!!
		list.forEach(System.out::println);
		
		for (String string : list) {
			System.out.println(string);
			System.out.println(string.substring(0,1));
		}
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		
		//Возвращает индекс нахождения элемента елси не находит то возвращает -1
		System.out.println(list.indexOf("Ivan"));
		
		//Возвращает элемент который выдалил
		list.remove("Ivan");
		System.out.println(list);
		
		//Ставит нужный нам элемент на нужное место удаляя при этом тот который стоит на том месте
		System.out.println(list.set(0, "Ivan"));
		System.out.println(list);
		
		LinkedList<String> list2=new LinkedList<>();
		
	
		
	}

}
