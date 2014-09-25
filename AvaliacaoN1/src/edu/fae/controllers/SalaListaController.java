package edu.fae.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.fae.dao.DaoFactory;
import edu.fae.dao.SalaDao;
import edu.fae.model.Sala;

@ViewScoped
@ManagedBean(name="salaListaController")
public class SalaListaController implements Serializable{
	private SalaDao salaDao = DaoFactory.getSalaDao();
	/**
	 * Armazena as salas mostrados na view
	 */
	private List<Sala> salas;
	
	/**
	 * Recebe o id da sala para ser exclu�do
	 */
	private Long id;
	
	/**
	 * M�todo que � chamado quando a view � aberta
	 * pela primeira vez
	 */
	@PostConstruct
	public void buscaTodos() {
		salas = salaDao.findAll();
	}

	/**
	 * M�todo que exclui um sala
	 */
	public void excluir() {
		if(id!=null) {
			Sala sala = salaDao.findById(id);
			if(sala!=null) {
				salaDao.remove(sala);
				
				//Chama o buscaTodos para atualizar a lista
				buscaTodos();
			}
		}
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Sala> getSalas() {
		return salas;
	}
}
