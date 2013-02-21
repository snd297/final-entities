package com.github.snd297.finalentities.model;

import static org.junit.Assert.assertTrue;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.snd297.finalentities.persistence.HibernateUtil;

public class FinalEntitiesTest {

	private static Long finalSpokeId;

	@BeforeClass
	public static void classSetup() throws Exception {
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		Session sess = null;
		Transaction trx = null;
		try {
			sess = sessFac.openSession();
			trx = sess.beginTransaction();
			FinalBicycle bicycle = new FinalBicycle();
			FinalWheel wheel1 = new FinalWheel(bicycle);
			FinalMethodSpoke spoke = new FinalMethodSpoke(wheel1);

			sess.save(bicycle);

			trx.commit();

			finalSpokeId = spoke.getId();
		} catch (Exception e) {
			HibernateUtil.rollbackQuietly(trx);
			throw e;
		} finally {
			HibernateUtil.closeQuietly(sess);
		}
	}

	@Test
	public void test() throws Exception {
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		Session sess = null;
		Transaction trx = null;
		try {
			sess = sessFac.openSession();
			trx = sess.beginTransaction();

			FinalMethodSpoke spoke = (FinalMethodSpoke)
					sess.load(FinalMethodSpoke.class, finalSpokeId);

			assertTrue(Hibernate.isInitialized(spoke.getWheel()));

			trx.commit();
		} catch (Exception e) {
			HibernateUtil.rollbackQuietly(trx);
			throw e;
		} finally {
			HibernateUtil.closeQuietly(sess);
		}
	}
}
