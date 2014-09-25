package edu.fae.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.fae.dao.DaoFactory;
import edu.fae.dao.AtorDao;
import edu.fae.model.Ator;

@ViewScoped
@ManagedBean(name="atorListaController")
public class AtorListaController implements Serializable{
	private AtorDao atorDao = DaoFactory.getAtorDao();
	/**
	 * Armazena as atores mostrados na view
	 */
	private List<Ator> atores;
	
	/**
	 * Recebe o id da ator para ser excluído
	 */
	private Long id;
	
	/**
	 * Método que é chamado quando a view é aberta
	 * pela primeira vez
	 */
	@PostConstruct
	public void buscaTodos() {
		atores = atorDao.findAll();
	}

	/**
	 * Método que exclui um ator
	 */
	public void excluir() {
		if(id!=null) {
			Ator ator = atorDao.findById(id);
			if(ator!=null) {
				atorDao.remove(ator);
				
				//Chama o buscaTodos para atualizar a lista
				buscaTodos();
			}
		}
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Ator> getAtores() {
		return atores;
	}
}
