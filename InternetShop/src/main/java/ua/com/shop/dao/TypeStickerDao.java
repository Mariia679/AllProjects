package ua.com.shop.dao;

import java.util.List;

import javax.persistence.EntityManager;

import ua.com.shop.entity.TypeSticker;

public class TypeStickerDao implements ShopDao<TypeSticker> {

	final EntityManager manager;

	public TypeStickerDao(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void save(TypeSticker t) {
		manager.getTransaction().begin();
		manager.persist(t);
		manager.getTransaction().commit();
	}

	@Override
	public List<TypeSticker> findAll() {
		List<TypeSticker> typeStickers = manager
				.createQuery("from TypeSticker").getResultList();
		return typeStickers;
	}

	@Override
	public TypeSticker findOne(String title) {
		TypeSticker typeSticker = (TypeSticker) manager
				.createQuery("select d from TypeSticker d where d.name =:param")
				.setParameter("param", title).getSingleResult();
		return typeSticker;
	}

	@Override
	public void delete(String title) {
		manager.getTransaction().commit();
		manager.remove(findOne(title));
		manager.getTransaction().commit();
	}

}
