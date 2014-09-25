package edu.fae.dao.hibernate;

import org.hibernate.Session;

public abstract class AbstractDaoHibernate {

	protected Session getSession() {
		return HibernateUtil.getSession();
	}
}
