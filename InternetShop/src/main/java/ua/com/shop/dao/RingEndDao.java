package ua.com.shop.dao;

import java.util.List;

import javax.persistence.EntityManager;

import ua.com.shop.entity.RingEnd;

public class RingEndDao implements ShopDao<RingEnd> {

	final EntityManager manager;

	public RingEndDao(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void save(RingEnd t) {
		manager.getTransaction().begin();
		manager.persist(t);
		manager.getTransaction().commit();

	}

	@Override
	public List<RingEnd> findAll() {
		List<RingEnd> ringEnds = manager.createQuery("from RingEnd")
				.getResultList();
		return ringEnds;
	}

	@Override
	public RingEnd findOne(String title) {
		RingEnd ringEnd = (RingEnd) manager
				.createQuery("select d from RingEnd d where d.name =:param")
				.setParameter("param", title).getSingleResult();
		return ringEnd;
	}

	@Override
	public void delete(String title) {
		manager.getTransaction().commit();
		manager.remove(findOne(title));
		manager.getTransaction().commit();
	}

}
