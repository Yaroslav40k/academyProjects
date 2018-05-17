package com.andersen.hibernate;

import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.andersen.hibernate.pojo.LeaderWithAnnotations;
import com.andersen.hibernate.pojo.LegionWithAnnotations;


/*
 * Tests functionality of Annotations-based POJO classes, standard CRUD operations
 * uses JPA EntityManagerFactory and JPA Criteria API
 */
public class HibernateJPACriteriaMain {

	// An EntityManagerFactory creation
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("persistence.xml");

	public static void main(String[] args) {
		
		printList(readAll());

		ENTITY_MANAGER_FACTORY.close();
	}

	/**
	 * Create a new LeaderWithAnnotations.
	 * 
	 * @param name
	 * @param power
	 * @param money
	 */
	public static void create(String leaderName, int leaderPower, int leaderMoney) {
		// Create an EntityManager
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			transaction = manager.getTransaction();
			transaction.begin();

			LeaderWithAnnotations leaderWithAnnotations = new LeaderWithAnnotations();
			leaderWithAnnotations.setLeaderName(leaderName);
			leaderWithAnnotations.setLeaderPower(leaderPower);
			leaderWithAnnotations.setLeaderMoney(leaderMoney);

			manager.persist(leaderWithAnnotations);

			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			manager.close();
		}
	}

	/**
	 * Read all LeaderWithAnnotations.
	 * 
	 * @return a List of LeaderWithAnnotations
	 */
	public static List<LeaderWithAnnotations> readAll() {

		List<LeaderWithAnnotations> leadersWithAnnotations = null;
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			transaction = manager.getTransaction();
			transaction.begin();
			leadersWithAnnotations = manager
					.createQuery(
							"SELECT DISTINCT leader FROM LeaderWithAnnotations leader JOIN FETCH leader.legions legions")
					.getResultList();
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			manager.close();
		}
		return leadersWithAnnotations;
	}

	/**
	 * Delete the existing LeaderWithAnnotations.
	 * 
	 * @param id
	 */
	public static void delete(int id) {
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			transaction = manager.getTransaction();
			transaction.begin();
			LeaderWithAnnotations leaderWithAnnotations = manager.find(LeaderWithAnnotations.class, id);
			manager.remove(leaderWithAnnotations);
			transaction.commit();
		} catch (Exception ex) {

			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			manager.close();
		}
	}

	/**
	 * Update the existing LeaderWithAnnotations.
	 * 
	 * @param name
	 * @param power
	 * @param money
	 */
	public static void upate(int leaderId, String leaderName, int leaderPower, int leaderMoney) {
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {
			transaction = manager.getTransaction();
			transaction.begin();
			LeaderWithAnnotations leaderWithAnnotations = manager.find(LeaderWithAnnotations.class, leaderId);
			leaderWithAnnotations.setLeaderName(leaderName);
			leaderWithAnnotations.setLeaderPower(leaderPower);
			leaderWithAnnotations.setLeaderMoney(leaderMoney);
			manager.persist(leaderWithAnnotations);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			manager.close();
		}
	}

	/**
	 * Prints list of Roman Leaders and their Legions
	 * 
	 * @param  leaderList

	 */
	private static void printList(List<LeaderWithAnnotations> leaderList) {
		for (LeaderWithAnnotations leader : leaderList) {
			System.out.println("| Leader ID : " + leader.getLeaderId());
			System.out.println("| Leader Name : " + leader.getLeaderName());
			System.out.println("| Leader Power : " + leader.getLeaderPower());
			Set<LegionWithAnnotations> legions = leader.getLegions();
			for (LegionWithAnnotations legion : legions) {
				System.out.println("|	Legions : " + legion.getLegioName());
			}
		}
	}
}
