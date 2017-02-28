package ua.com.shop.dao;

import java.util.List;

import javax.persistence.EntityManager;

import ua.com.shop.entity.Butt;
import ua.com.shop.entity.Main;
import ua.com.shop.entity.User;

public class UserDao implements ShopDao<User> {

	final EntityManager manager;

	public UserDao(EntityManager manager) {
		this.manager = manager;
	}

	public void deleteMainFromUser(String userName, String mainName) {
		manager.getTransaction().begin();
		User user = (User) manager
				.createQuery("select u from User u where u.name=:param")
				.setParameter("param", userName).getSingleResult();
		Main main = (Main) manager
				.createQuery("select m from Main m where m.name=:param")
				.setParameter("param", mainName).getSingleResult();
		user.getMains().remove(main);
		manager.getTransaction().commit();
	}

	@Override
	public void save(User t) {
		manager.getTransaction().begin();
		manager.persist(t);
		manager.getTransaction().commit();

	}

	@Override
	public List<User> findAll() {
		List<User> users = manager.createQuery("from User").getResultList();
		return users;
	}

	@Override
	public User findOne(String title) {
		User user = (User) manager
				.createQuery("select b from Butt b where b.name =:param")
				.setParameter("param", title).getSingleResult();
		return user;
	}

	@Override
	public void delete(String title) {
		manager.getTransaction().commit();
		manager.remove(findOne(title));
		manager.getTransaction().commit();

	}

}
