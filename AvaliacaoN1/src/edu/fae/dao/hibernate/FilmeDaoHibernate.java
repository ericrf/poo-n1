package edu.fae.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

import edu.fae.dao.FilmeDao;
import edu.fae.model.Filme;

/**
 * 
 * @author robsonluz
 *
 */
@SuppressWarnings("unchecked")
public class FilmeDaoHibernate extends AbstractDaoHibernate implements FilmeDao, Serializable {
	
	public List<Filme> findAll() {
		return getSession().createQuery("from Filme").list();
	}

	public Filme findById(Long id) {
		Query query = getSession().createQuery("from Filme where id=:id");
		query.setLong("id", id);
		return (Filme) query.uniqueResult();
	}

	public void remove(Filme filme) {
		getSession().delete(filme);
	}

	public void save(Filme filme) {
		getSession().saveOrUpdate(filme);
	}
	
}
