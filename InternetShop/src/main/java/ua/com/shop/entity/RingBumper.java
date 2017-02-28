package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ring_bumper")
public class RingBumper {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@OneToMany(mappedBy = "ringBumper")
	private List<Main> main;

	public RingBumper(String name) {
		this.name = name;
	}

	public RingBumper() {
	}

	public List<Main> getMain() {
		return main;
	}

	public void setMain(List<Main> main) {
		this.main = main;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "RingBumper [id=" + id + ", name=" + name + ", main=" + main
				+ "]";
	}
}
