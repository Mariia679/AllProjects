package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "id_joint")
public class Joint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_carving_joint")
	private CarvingJoint carvingJoint;

	@ManyToOne
	@JoinColumn(name = "id_material_joint")
	private MaterialJoint materialJoint;

	@OneToMany(mappedBy = "joint")
	private List<Main> main;

	public Joint() {

	}

	public Joint(CarvingJoint carvingJoint, MaterialJoint materialJoint) {
		this.carvingJoint = carvingJoint;
		this.materialJoint = materialJoint;
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

	public CarvingJoint getCarvingJoint() {
		return carvingJoint;
	}

	public void setCarvingJoint(CarvingJoint carvingJoint) {
		this.carvingJoint = carvingJoint;
	}

	public MaterialJoint getMaterialJoint() {
		return materialJoint;
	}

	public void setMaterialJoint(MaterialJoint materialJoint) {
		this.materialJoint = materialJoint;
	}

	@Override
	public String toString() {
		return "Joint [id=" + id + ", carvingJoint=" + carvingJoint
				+ ", materialJoint=" + materialJoint + "]";
	}

}
