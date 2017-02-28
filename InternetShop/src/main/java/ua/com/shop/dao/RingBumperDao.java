package ua.com.shop.dao;

import java.util.List;

import javax.persistence.EntityManager;

import ua.com.shop.entity.RingBumper;

public class RingBumperDao implements ShopDao<RingBumper> {

	final EntityManager manager;

	public RingBumperDao(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void save(RingBumper t) {
		manager.getTransaction().begin();
		manager.persist(t);
		manager.getTransaction().commit();

	}

	@Override
	public List<RingBumper> findAll() {
		List<RingBumper> ringBumpers = manager.createQuery("from RingBumper")
				.getResultList();
		return ringBumpers;
	}

	@Override
	public RingBumper findOne(String title) {
		RingBumper ringBumper = (RingBumper) manager
				.createQuery("select d from RingBumper d where d.name =:param")
				.setParameter("param", title).getSingleResult();
		return ringBumper;
	}

	@Override
	public void delete(String title) {
		manager.getTransaction().commit();
		manager.remove(findOne(title));
		manager.getTransaction().commit();
	}

}
