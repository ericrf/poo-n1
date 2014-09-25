package edu.fae.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

import edu.fae.dao.AtorDao;
import edu.fae.model.Ator;

/**
 * 
 * @author robsonluz
 *
 */
@SuppressWarnings("unchecked")
public class AtorDaoHibernate extends AbstractDaoHibernate implements AtorDao, Serializable {
	
	public List<Ator> findAll() {
		return getSession().createQuery("from Ator").list();
	}

	public Ator findById(Long id) {
		Query query = getSession().createQuery("from Ator where id=:id");
		query.setLong("id", id);
		return (Ator) query.uniqueResult();
	}

	public void remove(Ator ator) {
		getSession().delete(ator);
	}

	public void save(Ator ator) {
		getSession().saveOrUpdate(ator);
	}
	
}
