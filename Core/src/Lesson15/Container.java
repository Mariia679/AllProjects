package Lesson15;

import java.io.Serializable;
import java.util.List;

public class Container<T extends Serializable> implements Serializable {

	private static final long serialVersionUID = 2742528282915290617L;

	private T element;

	private List<T> list;

	public Container(T element) {
		this.element = element;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
