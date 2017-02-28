package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "material_joint")
public class MaterialJoint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@OneToMany(mappedBy = "materialJoint")
	private List<Joint> joint;

	public MaterialJoint() {

	}

	public MaterialJoint(String name) {
		this.name = name;
	}

	public List<Joint> getJoint() {
		return joint;
	}

	public void setJoint(List<Joint> joint) {
		this.joint = joint;
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
		return "MaterialJoint [id=" + id + ", name=" + name + "]";
	}
}
