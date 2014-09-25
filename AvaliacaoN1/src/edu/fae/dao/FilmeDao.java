package edu.fae.dao;

import java.util.List;

import edu.fae.model.Filme;

/**
 * 
 * @author robsonluz
 *
 */
public interface FilmeDao {
	public List<Filme> findAll();
	public void save(Filme filme);
	public void remove(Filme filme);
	public Filme findById(Long id);
}
