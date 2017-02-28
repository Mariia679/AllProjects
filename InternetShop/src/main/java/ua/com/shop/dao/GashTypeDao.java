package ua.com.shop.dao;

import java.util.List;

import javax.persistence.EntityManager;

import ua.com.shop.entity.GashType;

public class GashTypeDao implements ShopDao<GashType> {

	final EntityManager manager;

	public GashTypeDao(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void save(GashType t) {
		manager.getTransaction().begin();
		manager.persist(t);
		manager.getTransaction().commit();
	}

	@Override
	public List<GashType> findAll() {
		List<GashType> t = manager.createQuery("from GashType").getResultList();
		return t;
	}

	@Override
	public GashType findOne(String title) {
		GashType t = (GashType) manager
				.createQuery("select d from GashType d where d.name =:param")
				.setParameter("param", title).getSingleResult();
		return t;
	}

	@Override
	public void delete(String title) {
		manager.getTransaction().commit();
		manager.remove(findOne(title));
		manager.getTransaction().commit();
	}

}
