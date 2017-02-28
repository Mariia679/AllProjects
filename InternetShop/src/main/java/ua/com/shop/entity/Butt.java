package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "butt")
public class Butt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@OneToMany(mappedBy = "butt")
	private List<Gash> gash;

	public Butt() {

	}

	public Butt(String name) {
		this.name = name;
	}

	public List<Gash> getGash() {
		return gash;
	}

	public void setGash(List<Gash> gash) {
		this.gash = gash;
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
		return "Butt [id=" + id + ", name=" + name + ", gash=" + gash + "]";
	}
}
