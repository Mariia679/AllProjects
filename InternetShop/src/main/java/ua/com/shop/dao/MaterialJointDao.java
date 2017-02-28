package ua.com.shop.dao;

import java.util.List;

import javax.persistence.EntityManager;

import ua.com.shop.entity.MaterialJoint;

public class MaterialJointDao implements ShopDao<MaterialJoint> {

	final EntityManager manager;

	public MaterialJointDao(EntityManager manager) {
		this.manager = manager;
	}

	public void save(MaterialJoint t) {
		manager.getTransaction().begin();
		manager.persist(t);
		manager.getTransaction().commit();
	}

	public List<MaterialJoint> findAll() {
		List<MaterialJoint> cities = manager.createQuery("from MaterialJoint")
				.getResultList();
		return cities;
	}

	public MaterialJoint findOne(String title) {
		MaterialJoint carvingJoint = (MaterialJoint) manager
				.createQuery(
						"select c from MaterialJoint c where c.name =:param")
				.setParameter("param", title).getSingleResult();
		return carvingJoint;
	}

	public void delete(String title) {
		manager.getTransaction().commit();
		manager.remove(findOne(title));
		manager.getTransaction().commit();
	}

}
