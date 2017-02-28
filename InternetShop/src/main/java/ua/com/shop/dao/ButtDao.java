package ua.com.shop.dao;

import java.util.List;

import javax.persistence.EntityManager;

import ua.com.shop.entity.Butt;

public class ButtDao implements ShopDao<Butt> {

	final EntityManager manager;

	public ButtDao(EntityManager manager) {
		this.manager = manager;
	}

	public void save(Butt butt) {
		manager.getTransaction().begin();
		manager.persist(butt);
		manager.getTransaction().commit();
	}

	public List<Butt> findAll() {
		List<Butt> cities = manager.createQuery("from Butt").getResultList();
		return cities;
	}

	public Butt findOne(String title) {
		Butt butt = (Butt) manager
				.createQuery("select b from Butt b where b.name =:param")
				.setParameter("param", title).getSingleResult();
		return butt;
	}

	public void delete(String title) {
		manager.getTransaction().commit();
		manager.remove(findOne(title));
		manager.getTransaction().commit();
	}

}
