package ua.com.shop.dao;

import java.util.List;

import javax.persistence.EntityManager;

import ua.com.shop.entity.Butt;
import ua.com.shop.entity.Damper;
import ua.com.shop.entity.Ferula;
import ua.com.shop.entity.Gash;
import ua.com.shop.entity.GashType;
import ua.com.shop.entity.Joint;
import ua.com.shop.entity.Main;
import ua.com.shop.entity.MainMaterial;
import ua.com.shop.entity.RingBumper;
import ua.com.shop.entity.RingEnd;
import ua.com.shop.entity.Shaft;
import ua.com.shop.entity.Sticker;
import ua.com.shop.entity.TypeSticker;
import ua.com.shop.entity.Wood;

public class MainDao implements ShopDao<Main> {
	final EntityManager manager;

	public MainDao(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void save(Main t) {
		manager.getTransaction().begin();
		manager.persist(t);
		manager.getTransaction().commit();

	}

	@Override
	public List<Main> findAll() {
		List<Main> mains = manager.createQuery("from Main").getResultList();
		return mains;
	}

	@Override
	public Main findOne(String title) {
		Main main = (Main) manager
				.createQuery("select d from Main d where d.name =:param")
				.setParameter("param", title).getSingleResult();
		return main;
	}

	@Override
	public void delete(String title) {
		manager.getTransaction().commit();
		manager.remove(findOne(title));
		manager.getTransaction().commit();

	}

	public void addDamperToMain(String mainName, String damperName) {
		manager.getTransaction().begin();

		Main main = (Main) manager
				.createQuery("select m from Main m where m.name =:param")
				.setParameter("param", mainName).getSingleResult();
		Damper damper = (Damper) manager
				.createQuery("select d from Damper d where d.name =:param")
				.setParameter("param", damperName).getSingleResult();
		main.setDamper(damper);

		manager.getTransaction().commit();
	}

	public void addFerulaToMain(String mainName, String damperName) {
		manager.getTransaction().begin();

		Main main = (Main) manager
				.createQuery("select m from Main m where m.name =:param")
				.setParameter("param", mainName).getSingleResult();
		Ferula ferula = (Ferula) manager
				.createQuery("select d from Ferula d where d.name =:param")
				.setParameter("param", damperName).getSingleResult();
		main.setFerula(ferula);

		manager.getTransaction().commit();
	}

	public void addGashToMain(String mainName, String titleButt,
			String titleShaft) {
		manager.getTransaction().begin();

		Main main = (Main) manager
				.createQuery("select m from Main m where m.name =:param")
				.setParameter("param", mainName).getSingleResult();
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
						"select g from Gash g where g.id_butt =:paramButt ")

				.setParameter("paramButt", idButt).getSingleResult();
		main.setGash(gash);

		manager.getTransaction().commit();
	}

	public void addGashTypeToMain(String mainName, String damperName) {
		manager.getTransaction().begin();

		Main main = (Main) manager
				.createQuery("select m from Main m where m.name =:param")
				.setParameter("param", mainName).getSingleResult();
		GashType gashType = (GashType) manager
				.createQuery("select d from GashType d where d.name =:param")
				.setParameter("param", damperName).getSingleResult();
		main.setGashType(gashType);

		manager.getTransaction().commit();
	}

	public void addJointToMain(String mainName, String damperName) {
		manager.getTransaction().begin();

		Main main = (Main) manager
				.createQuery("select m from Main m where m.name =:param")
				.setParameter("param", mainName).getSingleResult();
		Joint joint = (Joint) manager
				.createQuery("select d from Joint d where d.name =:param")
				.setParameter("param", damperName).getSingleResult();
		main.setJoint(joint);
		;

		manager.getTransaction().commit();
	}

	public void addMainMaterialToMain(String mainName, String damperName) {
		manager.getTransaction().begin();

		Main main = (Main) manager
				.createQuery("select m from Main m where m.name =:param")
				.setParameter("param", mainName).getSingleResult();
		MainMaterial mainMaterial = (MainMaterial) manager
				.createQuery(
						"select d from MainMaterial d where d.name =:param")
				.setParameter("param", damperName).getSingleResult();
		main.setMainMaterial(mainMaterial);

		manager.getTransaction().commit();
	}

	public void addRingBumperToMain(String mainName, String damperName) {
		manager.getTransaction().begin();

		Main main = (Main) manager
				.createQuery("select m from Main m where m.name =:param")
				.setParameter("param", mainName).getSingleResult();
		RingBumper ringBumper = (RingBumper) manager
				.createQuery("select d from RingBumper d where d.name =:param")
				.setParameter("param", damperName).getSingleResult();
		main.setRingBumper(ringBumper);

		manager.getTransaction().commit();
	}

	public void addRingEndToMain(String mainName, String damperName) {
		manager.getTransaction().begin();

		Main main = (Main) manager
				.createQuery("select m from Main m where m.name =:param")
				.setParameter("param", mainName).getSingleResult();
		RingEnd ringEnd = (RingEnd) manager
				.createQuery("select d from RingEnd d where d.name =:param")
				.setParameter("param", damperName).getSingleResult();
		main.setRingEnd(ringEnd);

		manager.getTransaction().commit();
	}

	public void addStickerToMain(String mainName, String damperName) {
		manager.getTransaction().begin();

		Main main = (Main) manager
				.createQuery("select m from Main m where m.name =:param")
				.setParameter("param", mainName).getSingleResult();
		Sticker sticker = (Sticker) manager
				.createQuery("select d from Sticker d where d.name =:param")
				.setParameter("param", damperName).getSingleResult();
		main.setSticker(sticker);

		manager.getTransaction().commit();
	}

	public void addTypeStickerToMain(String mainName, String damperName) {
		manager.getTransaction().begin();

		Main main = (Main) manager
				.createQuery("select m from Main m where m.name =:param")
				.setParameter("param", mainName).getSingleResult();
		TypeSticker typeSticker = (TypeSticker) manager
				.createQuery("select d from TypeSticker d where d.name =:param")
				.setParameter("param", damperName).getSingleResult();
		main.setTypeSticker(typeSticker);

		manager.getTransaction().commit();
	}

	public void addWoodToMain(String mainName, String damperName) {
		manager.getTransaction().begin();

		Main main = (Main) manager
				.createQuery("select m from Main m where m.name =:param")
				.setParameter("param", mainName).getSingleResult();
		Wood wood = (Wood) manager
				.createQuery("select d from Wood d where d.name =:param")
				.setParameter("param", damperName).getSingleResult();
		main.setWood(wood);

		manager.getTransaction().commit();
	}

	public void deleteDamperFromMain(String mainName, String damperName) {
		manager.getTransaction().begin();

		Main main = (Main) manager
				.createQuery("select m from Main m where m.name =:param")
				.setParameter("param", mainName).getSingleResult();
		main.setDamper(null);

		manager.getTransaction().commit();
	}

	
}
