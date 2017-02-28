package ua.com.shop.dao;

import java.util.List;

import javax.persistence.EntityManager;

import ua.com.shop.entity.Sticker;

public class StickerDao implements ShopDao<Sticker> {

	final EntityManager manager;

	public StickerDao(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void save(Sticker t) {
		manager.getTransaction().begin();
		manager.persist(t);
		manager.getTransaction().commit();

	}

	@Override
	public List<Sticker> findAll() {
		List<Sticker> stickers = manager.createQuery("from Sticker")
				.getResultList();
		return stickers;
	}

	@Override
	public Sticker findOne(String title) {
		Sticker sticker = (Sticker) manager
				.createQuery("select d from Sticker d where d.name =:param")
				.setParameter("param", title).getSingleResult();
		return sticker;
	}

	@Override
	public void delete(String title) {
		manager.getTransaction().commit();
		manager.remove(findOne(title));
		manager.getTransaction().commit();
	}

}
