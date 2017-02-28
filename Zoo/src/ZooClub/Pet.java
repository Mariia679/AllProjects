package ZooClub;

import java.io.Serializable;

public class Pet implements Serializable {

	private static final long serialVersionUID = -970740165704022826L;

	private String animal;

	private int age;

	public Pet(int age, String animal) {
		this.age = age;
		this.animal = animal;
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((animal == null) ? 0 : animal.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pet other = (Pet) obj;
		if (age != other.age)
			return false;
		if (animal == null) {
			if (other.animal != null)
				return false;
		} else if (!animal.equals(other.animal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pet [animal=" + animal + ", age=" + age + "]";
	}

}
