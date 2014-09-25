package edu.fae.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.fae.dao.DaoFactory;
import edu.fae.dao.FilmeDao;
import edu.fae.model.Filme;

@ViewScoped
@ManagedBean(name="filmeListaController")
public class FilmeListaController {
	private FilmeDao filmeDao = DaoFactory.getFilmeDao();
	/**
	 * Armazena as filmes mostrados na view
	 */
	private List<Filme> filmes;
	
	/**
	 * Recebe o id da filme para ser excluído
	 */
	private Long id;
	
	/**
	 * Método que é chamado quando a view é aberta
	 * pela primeira vez
	 */
	@PostConstruct
	public void buscaTodos() {
		filmes = filmeDao.findAll();
	}

	/**
	 * Método que exclui um filme
	 */
	public void excluir() {
		if(id!=null) {
			Filme filme = filmeDao.findById(id);
			if(filme!=null) {
				filmeDao.remove(filme);
				
				//Chama o buscaTodos para atualizar a lista
				buscaTodos();
			}
		}
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Filme> getFilmes() {
		return filmes;
	}
}
