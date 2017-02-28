package ua.com.shop.app;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.com.shop.dao.ButtDao;
import ua.com.shop.dao.CarvingJointDao;
import ua.com.shop.dao.DamperDao;
import ua.com.shop.dao.FerulaDao;
import ua.com.shop.dao.GashDao;
import ua.com.shop.dao.GashTypeDao;
import ua.com.shop.dao.JointDao;
import ua.com.shop.dao.MainDao;
import ua.com.shop.dao.MainMaterialDao;
import ua.com.shop.dao.MaterialJointDao;
import ua.com.shop.dao.RingBumperDao;
import ua.com.shop.dao.RingEndDao;
import ua.com.shop.dao.ShaftDao;
import ua.com.shop.dao.StickerDao;
import ua.com.shop.dao.TypeStickerDao;
import ua.com.shop.dao.WoodDao;
import ua.com.shop.entity.Butt;
import ua.com.shop.entity.CarvingJoint;
import ua.com.shop.entity.Damper;
import ua.com.shop.entity.Ferula;
import ua.com.shop.entity.Gash;
import ua.com.shop.entity.GashType;
import ua.com.shop.entity.Joint;
import ua.com.shop.entity.Main;
import ua.com.shop.entity.MainMaterial;
import ua.com.shop.entity.MaterialJoint;
import ua.com.shop.entity.RingBumper;
import ua.com.shop.entity.RingEnd;
import ua.com.shop.entity.Shaft;
import ua.com.shop.entity.Sticker;
import ua.com.shop.entity.TypeSticker;
import ua.com.shop.entity.Wood;

public class RunMain {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("primary");

		EntityManager manager = factory.createEntityManager();

		// manager.getTransaction().begin();
//		while (true) {
//			System.out
//					.println("Введите 1 если хотите добавить значение в базу");
//			System.out
//					.println("Введите 2 если хотите удалить значение из базы");
//			System.out
//					.println("Введите 3 если хотите вывести все данные на консоль");
//			System.out
//					.println("Введите 4 если хотите вывести некоторый данные на консоль");
//			System.out.println("Введите 5 чтобы прописать соединение");
//			System.out.println("Введите 0 для выхода");
//			switch (sc.next()) {
//			case "1":
//				first(manager);
//				break;
//			case "2":
//				break;
//			case "3":
//				ButtDao buttDao = new ButtDao(manager);
//				System.out.println(buttDao.findAll());
//
//				CarvingJointDao carvingJointDao = new CarvingJointDao(manager);
//				System.out.println(carvingJointDao.findAll());
//
//				DamperDao damperDao = new DamperDao(manager);
//				System.out.println(damperDao.findAll());
//
//				FerulaDao ferulaDao = new FerulaDao(manager);
//				System.out.println(ferulaDao.findAll());
//
//				GashTypeDao gashTypeDao = new GashTypeDao(manager);
//				System.out.println(gashTypeDao.findAll());
//
//				MaterialJointDao materialJointDao = new MaterialJointDao(
//						manager);
//				System.out.println(materialJointDao.findAll());
//
//				JointDao jointDao = new JointDao(manager);
//				System.out.println(jointDao.findAll());
//
//				ShaftDao shaftDao = new ShaftDao(manager);
//				System.out.println(shaftDao.findAll());
//
//				GashDao gashDao = new GashDao(manager);
//				System.out.println(gashDao.findAll());
//
//				MainDao mainDao = new MainDao(manager);
//				System.out.println(mainDao.findAll());
//
//				MainMaterialDao mainMaterialDao = new MainMaterialDao(manager);
//				System.out.println(mainMaterialDao.findAll());
//
//				RingBumperDao ringBumperDao = new RingBumperDao(manager);
//				System.out.println(ringBumperDao.findAll());
//
//				RingEndDao ringEndDao = new RingEndDao(manager);
//				System.out.println(ringEndDao.findAll());
//
//				StickerDao stickerDao = new StickerDao(manager);
//				System.out.println(stickerDao.findAll());
//
//				TypeStickerDao typeStickerDao = new TypeStickerDao(manager);
//				System.out.println(typeStickerDao.findAll());
//
//				WoodDao woodDao = new WoodDao(manager);
//				System.out.println(woodDao.findAll());
//				break;
//			case "4":
//				break;
//			case "5":
//				MainDao mainDao1 = new MainDao(manager);
//				// mainDao1.addDamperToMain("strela", "dhf");
//				// DamperDao damperDao1 = new DamperDao(manager);
//				// System.out.println(damperDao1.findAll());
//				// mainDao1.addFerulaToMain("strela", "hfhf");
//				// FerulaDao ferulaDao2=new FerulaDao(manager);
//				// System.out.println(ferulaDao2.findAll());
//				mainDao1.addGashToMain("strela", "dfhf", "fhgj");
//				GashDao gashDao2=new GashDao(manager);
//				System.out.println(gashDao2.findAll());
//				break;
//			default:
//				manager.close();
//				factory.close();
//				sc.close();
//				return;
//			}
//		}

		// manager.getTransaction().commit();
		first(manager);
		MainDao mainDao3 = new MainDao(manager);
		mainDao3.deleteDamperFromMain("strela", "dhf");
		manager.close();
		factory.close();
		

	}

	static void first(EntityManager manager) {
		// System.out.println("Введите 1 если хотите записать ферулю");
		// System.out.println("Введите 2 если хотите записать наклейку");
		// System.out.println("Введите 3 если хотите записать тип наклейки");
		// System.out.println("Введите 4 если хотите записать скрутку");
		// System.out.println("Введите 5 если хотите записать кольцо бампера");
		// System.out.println("Введите 6 если хотите записать кольцо торцов");
		// System.out.println("Введите 7 если хотите записать амортизацию");
		// System.out.println("Введите 1 если хотите записать кий");
		// System.out.println("Введите 0 для выхода в основное меню");
		MainDao mainDao = new MainDao(manager);

		CarvingJointDao carvingJointDao = new CarvingJointDao(manager);
		CarvingJoint carvingJoint = new CarvingJoint("latyn");
		carvingJointDao.save(carvingJoint);
		MaterialJointDao materialJointDao = new MaterialJointDao(manager);
		MaterialJoint materialJoint = new MaterialJoint("nergavejka");
		materialJointDao.save(materialJoint);
		JointDao jointDao = new JointDao(manager);
		Joint joint = new Joint(carvingJoint, materialJoint);
		jointDao.save(joint);

		DamperDao damperDao = new DamperDao(manager);
		Damper damper = new Damper("dhf");
		damperDao.save(damper);
		FerulaDao ferulaDao = new FerulaDao(manager);
		Ferula ferula = new Ferula("hfhf");
		ferulaDao.save(ferula);

		ShaftDao shaftDao = new ShaftDao(manager);
		Shaft shaft = new Shaft("fhgj");
		shaftDao.save(shaft);
		ButtDao buttDao = new ButtDao(manager);
		Butt butt = new Butt("dfhf");
		buttDao.save(butt);
		GashDao gashDao = new GashDao(manager);
		Gash gash = new Gash(shaft, butt);
		gashDao.save(gash);

		MainMaterialDao mainMaterialDao = new MainMaterialDao(manager);
		MainMaterial mainMaterial = new MainMaterial("рара");
		mainMaterialDao.save(mainMaterial);

		GashTypeDao gashTypeDao = new GashTypeDao(manager);
		GashType gashType = new GashType("hgjf");
		gashTypeDao.save(gashType);

		RingBumperDao ringBumperDao = new RingBumperDao(manager);
		RingBumper ringBumper = new RingBumper("dvfgtg");
		ringBumperDao.save(ringBumper);

		RingEndDao ringEndDao = new RingEndDao(manager);
		RingEnd ringEnd = new RingEnd("ghkifv");
		ringEndDao.save(ringEnd);

		StickerDao stickerDao = new StickerDao(manager);
		Sticker sticker = new Sticker("ghghh");
		stickerDao.save(sticker);
		TypeStickerDao typeStickerDao = new TypeStickerDao(manager);
		TypeSticker typeSticker = new TypeSticker("cjfv");
		typeStickerDao.save(typeSticker);
		WoodDao woodDao = new WoodDao(manager);
		Wood wood = new Wood("grab");
		woodDao.save(wood);

		mainDao.save(new Main("strela", 400, 160, 710, mainMaterial, wood,
				ferula, gashType, gash, sticker, typeSticker, ringEnd,
				ringBumper, damper, joint));
	}
}
