package ua.com.shop.dao;

import java.util.List;

import javax.persistence.EntityManager;

import ua.com.shop.entity.Butt;
import ua.com.shop.entity.Damper;
import ua.com.shop.entity.Gash;
import ua.com.shop.entity.Main;
import ua.com.shop.entity.Shaft;

public class DamperDao implements ShopDao<Damper> {
	final EntityManager manager;

	public DamperDao(EntityManager manager) {
		this.manager = manager;
	}

	public void save(Damper damper) {
		manager.getTransaction().begin();
		manager.persist(damper);
		manager.getTransaction().commit();
	}

	public List<Damper> findAll() {
		List<Damper> dampers = manager.createQuery("from Damper")
				.getResultList();
		return dampers;
	}

	public Damper findOne(String title) {
		Damper damper = (Damper) manager
				.createQuery("select d from Damper d where d.name =:param")
				.setParameter("param", title).getSingleResult();
		return damper;
	}

	public void delete(String title) {
		manager.getTransaction().commit();
		manager.remove(findOne(title));
		manager.getTransaction().commit();
	}

	public void deleteDamper(String damperName) {
		manager.getTransaction().begin();

		Damper damper = (Damper) manager
				.createQuery("select d from Damper d where d.name =:param")
				.setParameter("param", damperName).getSingleResult();
		for (Main main : damper.getMain()) {
			main.setDamper(null);
			manager.merge(main);
		}
		manager.remove(damper);
		manager.getTransaction().commit();

	}

}
