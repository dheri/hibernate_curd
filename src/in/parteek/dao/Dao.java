/**
 * 
 */
package in.parteek.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.parteek.beans.Animal;
import in.parteek.beans.Toy;

/**
 * Created on : 2019-01-22, 3:42:16 p.m.
 *
 * @author Parteek Dheri
 */
public class Dao {
	SessionFactory sessionFactory = new Configuration().configure("in/parteek/config/hibernate.cfg.xml")
			.buildSessionFactory();

	public void addAnmal(Animal student) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// write code here

		session.save(student);

		// stop code here
		session.getTransaction().commit();
		session.close();
	}

	public void generateValues() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// write code here

//		session.save(student);

		for (int i = 1; i < 11; i++) {
			Animal animal = new Animal("tommy" + i, "dog");
			session.save(animal);
		}

		for (int i = 15; i < 20; i++) {
			Animal animal = new Animal("tiger" + i, "doge");
			animal.getToys().add(new Toy("cat", 2, "green"));
			animal.getToys().add(new Toy("bone", 2, "grey"));
			session.save(animal);
		}

		// stop code here
		session.getTransaction().commit();
		session.close();

	}

	public Animal retriveAnimalById(int id) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// write code here

		// animal is persistent object
		// Exists while transaction is open
		// connected to that row in DB
		Animal animal = session.get(Animal.class, id);

		// this is transient object
		// not conencted to DB
		String transientObj = "hello";

		// stop code here
		session.getTransaction().commit();
		session.close();

		transientObj.strip();
		// animal is now Detached Object
		return animal;
	}

	public void updateAnimalNameById(int id, String name) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// write code here

		Animal animal = session.get(Animal.class, id);
		animal.setName(name);

		// stop code here
		session.getTransaction().commit();
		session.close();

		return;
	}

	public void deleteAnimalById(int id) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// write code here

		Animal animal = session.get(Animal.class, id);
		session.delete(animal);

		// stop code here
		session.getTransaction().commit();
		session.close();

		return;
	}
}
