package com.andersen.hibernate;

import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import com.andersen.hibernate.pojo.LeaderWithAnnotations;
import com.andersen.hibernate.pojo.LegionWithAnnotations;
import com.andersen.hibernate.pojo.SlaveWithAnnotations;

/*
 * Tests functionality of Annotations-based POJO classes
 * also tests  2*DetachedCriteria (can be created apart from session)
 */

public class HibernateAnnoConfigMain {

	public static void main(String[] args) {

		DetachedCriteria findAllArmies = DetachedCriteria.forClass(LeaderWithAnnotations.class)
				.setFetchMode("legions", FetchMode.JOIN).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		DetachedCriteria findCaesarArmy = DetachedCriteria.forClass(LeaderWithAnnotations.class)
				.add(Restrictions.like("leaderName", "%Caesar")).setFetchMode("legions", FetchMode.JOIN)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		DetachedCriteria findSlaves = DetachedCriteria.forClass(SlaveWithAnnotations.class);
		DetachedCriteria findLeaders = DetachedCriteria.forClass(LeaderWithAnnotations.class);
				

		SessionFactory sessionFactory = HiberbateUtils.createFectory();
		makeQuerry(sessionFactory, findAllArmies);
		sessionFactory.close();
	}

	private static void makeQuerry(SessionFactory sessionFactory, DetachedCriteria detCriteria) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = detCriteria.getExecutableCriteria(session);
		viewResult(criteria);
		session.getTransaction().commit();

	}

	private static void viewResult(Criteria criteria) {
		List<LeaderWithAnnotations> leaderList = criteria.list();
		System.out.println("/-------------/LEADERS Details/-------------/");
		for (LeaderWithAnnotations leader : leaderList) {
			System.out.println("| Leader ID : " + leader.getLeaderId());
			System.out.println("| Leader Name : " + leader.getLeaderName());
			System.out.println("| Leader Power : " + leader.getLeaderPower());
			Set<LegionWithAnnotations> legions = leader.getLegions();
			for (LegionWithAnnotations legion : legions) {
				System.out.println("|	Legions : " + legion.getLegioName());
			}
			System.out.println("/-------------/-------------/-------------/");
		}
	}
	
	private static void viewResultForSlaves(Criteria criteria) {
		List<SlaveWithAnnotations> slavesList = criteria.list();
		System.out.println("/-------------/SLAVES Details/-------------/");
		slavesList.size();
		for (SlaveWithAnnotations slave : slavesList) {
			System.out.println("| Slave ID : " + slave.getSlaveId());
			System.out.println("| Slave Name : " + slave.getSlaveName());
			System.out.println("/-------------/-------------/-------------/");
		}
	}
}
