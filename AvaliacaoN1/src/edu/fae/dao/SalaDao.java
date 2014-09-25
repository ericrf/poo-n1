package edu.fae.dao;

import java.util.List;

import edu.fae.model.Sala;

/**
 * 
 * @author robsonluz
 *
 */
public interface SalaDao {
	public List<Sala> findAll();
	public void save(Sala sala);
	public void remove(Sala sala);
	public Sala findById(Long id);
}
