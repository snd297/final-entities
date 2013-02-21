package com.github.snd297.finalentities.model;

import static org.junit.Assert.assertFalse;
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
			FinalWheel finalWheel = new FinalWheel(bicycle);
			FinalSpoke finalSpoke = new FinalSpoke(finalWheel);
			sess.save(bicycle);

			Wheel wheel = new Wheel();
			Spoke spoke = new Spoke(wheel);
			sess.save(wheel);

			trx.commit();

			finalSpokeId = finalSpoke.getId();
			spokeId = spoke.getId();
		} catch (Exception e) {
			HibernateUtil.rollbackQuietly(trx);
			throw e;
		} finally {
			HibernateUtil.closeQuietly(sess);
		}
	}

	@Test
	public void finalNoProxy() throws Exception {
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		Session sess = null;
		Transaction trx = null;
		try {
			sess = sessFac.openSession();
			trx = sess.beginTransaction();

			FinalSpoke spoke = (FinalSpoke)
					sess.load(FinalSpoke.class, finalSpokeId);

			assertTrue(Hibernate.isInitialized(spoke.getWheel()));

			trx.commit();
		} catch (Exception e) {
			HibernateUtil.rollbackQuietly(trx);
			throw e;
		} finally {
			HibernateUtil.closeQuietly(sess);
		}
	}

	@Test
	public void proxy() throws Exception {
		SessionFactory sessFac = HibernateUtil.getSessionFactory();
		Session sess = null;
		Transaction trx = null;
		try {
			sess = sessFac.openSession();
			trx = sess.beginTransaction();

			Spoke spoke =
					(Spoke) sess.load(Spoke.class, spokeId);

			assertFalse(Hibernate.isInitialized(spoke.getWheel()));

			trx.commit();
		} catch (Exception e) {
			HibernateUtil.rollbackQuietly(trx);
			throw e;
		} finally {
			HibernateUtil.closeQuietly(sess);
		}
	}
}
