package ua.com.shop.dao;

import java.util.List;

import javax.persistence.EntityManager;

import ua.com.shop.entity.CarvingJoint;
import ua.com.shop.entity.Joint;
import ua.com.shop.entity.MaterialJoint;

public class JointDao {
	final EntityManager manager;

	public JointDao(EntityManager manager) {
		this.manager = manager;
	}

	public void save(Joint t) {
		manager.getTransaction().begin();
		manager.persist(t);
		manager.getTransaction().commit();
	}

	public List<Joint> findAll() {
		List<Joint> cities = manager.createQuery("from Joint").getResultList();
		return cities;
	}

	public Joint findOne(String titleButt, String titleShaft) {
		MaterialJoint materialJoint = (MaterialJoint) manager
				.createQuery(
						"select s from MaterialJoint s where s.name =:param")
				.setParameter("param", titleShaft).getSingleResult();
		CarvingJoint carvingJoint = (CarvingJoint) manager
				.createQuery(
						"select b from CarvingJoint b where b.name =:param")
				.setParameter("param", titleButt).getSingleResult();
		int idMaterialJoint = materialJoint.getId();
		int idCarvingJoint = carvingJoint.getId();
		Joint joint = (Joint) manager
				.createQuery(
						"select g from Joint g where g.id_material_joint =:paramShaft and g.id_carving_joint =:paramButt ")
				.setParameter("paramShaft", idMaterialJoint)
				.setParameter("paramButt", idCarvingJoint).getSingleResult();
		return joint;
	}

	public void delete(String titleButt, String titleShaft) {
		manager.getTransaction().commit();
		manager.remove(findOne(titleButt, titleShaft));
		manager.getTransaction().commit();
	}

	public void addMaterialToCarvingViaJoint(String titleMaterial,
			String titleCarving) {
		manager.getTransaction().begin();

		MaterialJoint materialJoint = (MaterialJoint) manager
				.createQuery(
						"select s from MaterialJoint s where s.name =:param")
				.setParameter("param", titleMaterial).getSingleResult();
		CarvingJoint carvingJoint = (CarvingJoint) manager
				.createQuery(
						"select b from CarvingJoint b where b.name =:param")
				.setParameter("param", titleCarving).getSingleResult();
		int idMaterialJoint = materialJoint.getId();
		int idCarvingJoint = carvingJoint.getId();
		Joint joint = new Joint(carvingJoint, materialJoint);
		manager.persist(joint);
		joint.setCarvingJoint(carvingJoint);
		joint.setMaterialJoint(materialJoint);

		manager.getTransaction().commit();
	}

}
