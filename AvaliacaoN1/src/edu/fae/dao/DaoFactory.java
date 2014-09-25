package edu.fae.dao;

import edu.fae.dao.hibernate.AtorDaoHibernate;
import edu.fae.dao.hibernate.FilmeDaoHibernate;
import edu.fae.dao.hibernate.SalaDaoHibernate;
import edu.fae.dao.hibernate.SessaoDaoHibernate;

/**
 * Factory de Dao
 * @author Robson J. P.
 * @since 1.0
 */
public class DaoFactory {
	
	public static AtorDao getCategoriaDao() {
		return new AtorDaoHibernate();
	}		
	
	public static SalaDao getSalaDao() {
		return new SalaDaoHibernate();
	}		

	public static FilmeDao getFilmeDao() {
		return new FilmeDaoHibernate();
	}		

	public static SessaoDao getSessaoDao() {
		return new SessaoDaoHibernate();
	}		

	
}
