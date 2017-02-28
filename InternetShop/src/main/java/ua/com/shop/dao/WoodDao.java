package ua.com.shop.dao;

import java.util.List;

import javax.persistence.EntityManager;

import ua.com.shop.entity.Wood;

public class WoodDao implements ShopDao<Wood> {

	final EntityManager manager;

	public WoodDao(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void save(Wood t) {
		manager.getTransaction().begin();
		manager.persist(t);
		manager.getTransaction().commit();

	}

	@Override
	public List<Wood> findAll() {
		List<Wood> woods = manager.createQuery("from Wood").getResultList();
		return woods;
	}

	@Override
	public Wood findOne(String title) {
		Wood wood = (Wood) manager
				.createQuery("select d from Wood d where d.name =:param")
				.setParameter("param", title).getSingleResult();
		return wood;
	}

	@Override
	public void delete(String title) {
		manager.getTransaction().commit();
		manager.remove(findOne(title));
		manager.getTransaction().commit();

	}

}
