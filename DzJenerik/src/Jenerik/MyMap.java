package Jenerik;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MyMap<K, V> {

	private Set<MyEntry<K, V>> set = new HashSet<>();

	public Set<MyEntry<K, V>> getSet() {
		return set;
	}

	public void setSet(Set<MyEntry<K, V>> set) {
		this.set = set;
	}

	public void put(K key, V value) {
		set.add(new MyEntry<>(key, value));

	}

	public void deleteKey(K key) {
		Iterator<MyEntry<K, V>> all = set.iterator();
		while (all.hasNext()) {
			MyEntry<K, V> keys=all.next();
			K key1=keys.getKey();
			if (key1.equals(key)) {
				all.remove();
			}
		}
	}
	public void deleteValue(V value) {
		Iterator<MyEntry<K, V>> all = set.iterator();
		while (all.hasNext()) {
			MyEntry<K, V> values=all.next();
			V value1=values.getValue();
			if (value1.equals(value)) {
				values.setValue(null);
			}
		}
	}
	public void showKey(){
		Iterator<MyEntry<K, V>> all = set.iterator();
		while (all.hasNext()) {
			MyEntry<K, V> values=all.next();
			System.out.print(values.getKey()+" ");
		}
	}
	public void showValue(){
		Iterator<MyEntry<K, V>> all = set.iterator();
		while (all.hasNext()) {
			MyEntry<K, V> values=all.next();
			System.out.print(values.getValue()+" ");
		}
	}
	public void showAll(){
		Iterator<MyEntry<K, V>> all = set.iterator();
		while (all.hasNext()) {
			MyEntry<K, V> values=all.next();
			System.out.println(values);
		}
	}

	@Override
	public String toString() {
		return "MyMap [set=" + set + "]";
	}
	

}
