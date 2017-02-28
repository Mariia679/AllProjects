package ua.com.shop.dao;

import java.util.List;

import javax.persistence.EntityManager;

import ua.com.shop.entity.CarvingJoint;

public class CarvingJointDao implements ShopDao<CarvingJoint> {

	final EntityManager manager;

	public CarvingJointDao(EntityManager manager) {
		this.manager = manager;
	}

	public void save(CarvingJoint carvingJoint) {
		manager.getTransaction().begin();
		manager.persist(carvingJoint);
		manager.getTransaction().commit();
	}

	public List<CarvingJoint> findAll() {
		List<CarvingJoint> cities = manager.createQuery("from CarvingJoint")
				.getResultList();
		return cities;
	}

	public CarvingJoint findOne(String title) {
		CarvingJoint carvingJoint = (CarvingJoint) manager
				.createQuery(
						"select c from CarvingJoint c where c.name =:param")
				.setParameter("param", title).getSingleResult();
		return carvingJoint;
	}

	public void delete(String title) {
		manager.getTransaction().commit();
		manager.remove(findOne(title));
		manager.getTransaction().commit();
	}
}
