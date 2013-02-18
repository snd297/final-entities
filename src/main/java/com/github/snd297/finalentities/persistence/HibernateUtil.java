package com.github.snd297.finalentities.persistence;

import javax.annotation.Nullable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.ImprovedNamingStrategy;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	static {
		try {
			Configuration config = new Configuration();
			config.setNamingStrategy(new ImprovedNamingStrategy());
			config.configure();
			sessionFactory = config.buildSessionFactory();
		} catch (Throwable t) {
			t.printStackTrace();
			throw new ExceptionInInitializerError(t);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	private HibernateUtil() {
		throw new AssertionError();
	}

	public static void closeQuietly(@Nullable Session sess) {
		try {
			if (sess != null && sess.isOpen()) {
				sess.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void rollbackQuietly(@Nullable Transaction trx) {
		try {
			if (trx != null && trx.isActive()) {
				trx.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
