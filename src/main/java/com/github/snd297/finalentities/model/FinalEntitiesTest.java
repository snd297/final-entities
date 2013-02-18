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

	private static Long spokeId;

	@BeforeClass
	public static void classSetup() throws Exception {
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		Session sess = null;
		Transaction trx = null;
		try {
			sess = sessFac.openSession();
			trx = sess.beginTransaction();
			FinalBicycle bicycle = new FinalBicycle();

			FinalWheel wheel1 = new FinalWheel();
			bicycle.addWheel(wheel1);

			FinalWheel wheel2 = new FinalWheel();
			bicycle.addWheel(wheel2);

			FinalSpoke spoke = new FinalSpoke();
			wheel1.addSpoke(spoke);

			sess.save(bicycle);

			trx.commit();

			spokeId = spoke.getId();
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

			FinalSpoke spoke = (FinalSpoke)
					sess.load(FinalSpoke.class, spokeId);

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
