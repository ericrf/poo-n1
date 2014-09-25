package edu.fae.dao;

import java.util.List;

import edu.fae.model.Ator;

/**
 * 
 * @author robsonluz
 *
 */
public interface AtorDao {
	public List<Ator> findAll();
	public void save(Ator ator);
	public void remove(Ator ator);
	public Ator findById(Long id);
}
