package com.github.snd297.finalentities.model;

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
			sess.save(bicycle);

			FinalWheel wheel = new FinalWheel();
			bicycle.addWheel(wheel);

			FinalSpoke spoke = new FinalSpoke();
			wheel.addSpoke(spoke);

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

			trx.commit();
		} catch (Exception e) {
			HibernateUtil.rollbackQuietly(trx);
			throw e;
		} finally {
			HibernateUtil.closeQuietly(sess);
		}
	}
}
