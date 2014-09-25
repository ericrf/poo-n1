package edu.fae.dao;

import java.util.List;

import edu.fae.model.Sessao;

/**
 * 
 * @author robsonluz
 *
 */
public interface SessaoDao {
	public List<Sessao> findAll();
	public void save(Sessao sessao);
	public void remove(Sessao sessao);
	public Sessao findById(Long id);
}
