package edu.fae.dao.hibernate;

import java.util.List;

import org.hibernate.Query;

import edu.fae.dao.SalaDao;
import edu.fae.model.Sala;

/**
 * 
 * @author robsonluz
 *
 */
@SuppressWarnings("unchecked")
public class SalaDaoHibernate extends AbstractDaoHibernate implements SalaDao {
	
	public List<Sala> findAll() {
		return getSession().createQuery("from Sala").list();
	}

	public Sala findById(Long id) {
		Query query = getSession().createQuery("from Sala where id=:id");
		query.setLong("id", id);
		return (Sala) query.uniqueResult();
	}

	public void remove(Sala sala) {
		getSession().delete(sala);
	}

	public void save(Sala sala) {
		getSession().saveOrUpdate(sala);
	}
	
}
