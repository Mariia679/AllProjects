package ua.com.shop.dao;

import java.util.List;

import javax.persistence.EntityManager;

import ua.com.shop.entity.Shaft;

public class ShaftDao implements ShopDao<Shaft> {
	final EntityManager manager;

	public ShaftDao(EntityManager manager) {
		this.manager = manager;
	}

	public void save(Shaft shaft) {
		manager.getTransaction().begin();
		manager.persist(shaft);
		manager.getTransaction().commit();
	}

	public List<Shaft> findAll() {
		List<Shaft> cities = manager.createQuery("from Shaft").getResultList();
		return cities;
	}

	public Shaft findOne(String title) {
		Shaft shaft = (Shaft) manager
				.createQuery("select d from Shaft d where d.name =:param")
				.setParameter("param", title).getSingleResult();
		return shaft;
	}

	public void delete(String title) {
		manager.getTransaction().begin();
		manager.remove(findOne(title));
		manager.getTransaction().commit();
	}
}
