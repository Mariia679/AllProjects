package ua.com.shop.dao;

import java.util.List;

import javax.persistence.EntityManager;

import ua.com.shop.entity.Ferula;

public class FerulaDao implements ShopDao<Ferula> {

	final EntityManager manager;

	public FerulaDao(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void save(Ferula t) {
		manager.getTransaction().begin();
		manager.persist(t);
		manager.getTransaction().commit();

	}

	@Override
	public List<Ferula> findAll() {
		List<Ferula> feruls = manager.createQuery("from Ferula")
				.getResultList();
		return feruls;
	}

	@Override
	public Ferula findOne(String title) {
		Ferula ferula = (Ferula) manager
				.createQuery("select d from Ferula d where d.name =:param")
				.setParameter("param", title).getSingleResult();
		return ferula;
	}

	@Override
	public void delete(String title) {
		manager.getTransaction().commit();
		manager.remove(findOne(title));
		manager.getTransaction().commit();

	}
	

}
