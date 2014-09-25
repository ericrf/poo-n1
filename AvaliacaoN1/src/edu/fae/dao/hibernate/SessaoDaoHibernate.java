package edu.fae.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

import edu.fae.dao.SessaoDao;
import edu.fae.model.Sessao;

/**
 * 
 * @author robsonluz
 *
 */
@SuppressWarnings("unchecked")
public class SessaoDaoHibernate extends AbstractDaoHibernate implements SessaoDao, Serializable {
	
	public List<Sessao> findAll() {
		return getSession().createQuery("from Sessao").list();
	}

	public Sessao findById(Long id) {
		Query query = getSession().createQuery("from Sessao where id=:id");
		query.setLong("id", id);
		return (Sessao) query.uniqueResult();
	}

	public void remove(Sessao sessao) {
		getSession().delete(sessao);
	}

	public void save(Sessao sessao) {
		getSession().saveOrUpdate(sessao);
	}
	
}
