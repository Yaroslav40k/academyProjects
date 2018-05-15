package com.andersen.hibernate;

import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.andersen.hibernate.pojo.Leader;
import com.andersen.hibernate.pojo.Legion;



/*
 * Tests functionality of XML-based POJO classes, standard CRUD operations
 * uses HQL for SELECT query
 */

public class HibernateXMLConfigMain {
	public static void main(String[] args) {
		
		// builds a session factory
		SessionFactory sessionFactory = HiberbateUtils.createFectory();

		//createLeader(sessionFactory);
		//updateLeader(sessionFactory, 6);
		showAllLeaders(sessionFactory);
		//deleteLeader(sessionFactory, 9);
		
		sessionFactory.close();
	}

	private static void createLeader(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		Leader leader = new Leader();
		leader.setLeaderName("Titus Flavius");
		leader.setLeaderPower(1); 
		leader.setLeaderMoney(0);
		session.beginTransaction();
		session.save(leader);
		session.getTransaction().commit();
		System.out.println("Leader "+leader.getLeaderName()+ " Created!!!");
	}

	private static void showAllLeaders(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Leader> leaderList = session.createQuery("select distinct leader FROM Leader leader JOIN FETCH leader.legions legions").list();
		System.out.println("/-------------/LEADERS Details/-------------/");
		for (Leader leader : leaderList) {
			System.out.println("| Leader ID : " + leader.getLeaderId());
			System.out.println("| Leader Name : " + leader.getLeaderName());
			System.out.println("| Leader Power : " + leader.getLeaderPower());
			Set<Legion> legions = leader.getLegions();
			for (Legion legion : legions) {
				System.out.println("|	Legions : " + legion.getLegioName());
			}
		}
		session.getTransaction().commit();
	}

	private static void updateLeader(SessionFactory sessionFactory, int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Leader leader = (Leader) session.get(Leader.class, id);
		leader.setLeaderName("Puzarion-Cesarion");
		session.update(leader);
		session.getTransaction().commit();
		System.out.println("Leader " + leader.getLeaderName() + " updated!!!");
	}
	
	private static void  deleteLeader(SessionFactory sessionFactory, int id)
    {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Leader leader = (Leader) session.get(Leader.class, id);  
        session.delete(leader);
		session.getTransaction().commit();
		System.out.println("Leader " + leader.getLeaderName() + " deleted!!!");
    }
}
