package ua.com.shop.dao;

import java.util.List;

import javax.persistence.EntityManager;

import ua.com.shop.entity.Butt;
import ua.com.shop.entity.Gash;
import ua.com.shop.entity.Shaft;

public class GashDao {
	final EntityManager manager;

	public GashDao(EntityManager manager) {
		this.manager = manager;
	}

	public void save(Gash gash) {
		manager.getTransaction().begin();
		manager.persist(gash);
		manager.getTransaction().commit();
	}

	public List<Gash> findAll() {
		List<Gash> cities = manager.createQuery("from Gash").getResultList();
		return cities;
	}

	public Gash findOne(String titleButt, String titleShaft) {
		Shaft shaft = (Shaft) manager
				.createQuery("select s from Shaft s where s.name =:param")
				.setParameter("param", titleShaft).getSingleResult();
		Butt butt = (Butt) manager
				.createQuery("select b from Butt b where b.name =:param")
				.setParameter("param", titleButt).getSingleResult();
		int idButt = butt.getId();
		int idShaft = shaft.getId();
		Gash gash = (Gash) manager
				.createQuery(
						"select g from Gash g where g.id_shaft =:paramShaft and g.id_butt =:paramButt ")
				.setParameter("paramShaft", idShaft)
				.setParameter("paramButt", idButt).getSingleResult();
		return gash;
	}

	public void delete(String titleButt, String titleShaft) {
		manager.getTransaction().commit();
		manager.remove(findOne(titleButt, titleShaft));
		manager.getTransaction().commit();
	}

	public void addShaftToButtViaGash(String titleButt, String titleShaft) {
		manager.getTransaction().begin();

		Shaft shaft = (Shaft) manager
				.createQuery("select s from Shaft s where s.name =:param")
				.setParameter("param", titleShaft).getSingleResult();
		Butt butt = (Butt) manager
				.createQuery("select b from Butt b where b.name =:param")
				.setParameter("param", titleButt).getSingleResult();
		int idButt = butt.getId();
		int idShaft = shaft.getId();
		Gash gash = new Gash(shaft, butt);
		manager.persist(gash);
		gash.setButt(butt);
		gash.setShaft(shaft);

		manager.getTransaction().commit();
	}

}
