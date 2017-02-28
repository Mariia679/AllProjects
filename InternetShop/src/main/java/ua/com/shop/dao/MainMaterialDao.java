package ua.com.shop.dao;

import java.util.List;

import javax.persistence.EntityManager;

import ua.com.shop.entity.MainMaterial;

public class MainMaterialDao implements ShopDao<MainMaterial> {

	final EntityManager manager;

	public MainMaterialDao(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void save(MainMaterial t) {
		manager.getTransaction().begin();
		manager.persist(t);
		manager.getTransaction().commit();

	}

	@Override
	public List<MainMaterial> findAll() {
		List<MainMaterial> mainMaterials = manager.createQuery(
				"from MainMaterial").getResultList();
		return mainMaterials;
	}

	@Override
	public MainMaterial findOne(String title) {
		MainMaterial mainMaterial = (MainMaterial) manager
				.createQuery(
						"select d from MainMaterial d where d.name =:param")
				.setParameter("param", title).getSingleResult();
		return mainMaterial;
	}

	@Override
	public void delete(String title) {
		manager.getTransaction().commit();
		manager.remove(findOne(title));
		manager.getTransaction().commit();

	}

}
