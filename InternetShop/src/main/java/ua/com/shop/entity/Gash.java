package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "gash")
public class Gash {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_shaft")
	private Shaft shaft;

	@ManyToOne
	@JoinColumn(name = "id_butt")
	private Butt butt;

	@OneToMany(mappedBy = "gash")
	private List<Main> main;

	public Gash() {

	}

	public Gash(Shaft shaft, Butt butt) {
		this.shaft = shaft;
		this.butt = butt;
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

	public Shaft getShaft() {
		return shaft;
	}

	public void setShaft(Shaft shaft) {
		this.shaft = shaft;
	}

	public Butt getButt() {
		return butt;
	}

	public void setButt(Butt butt) {
		this.butt = butt;
	}

	@Override
	public String toString() {
		return "Gash [id=" + id + ", main=" + main + "]";
	}

}
