package edu.fae.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.fae.dao.DaoFactory;
import edu.fae.dao.SessaoDao;
import edu.fae.model.Sessao;

@ViewScoped
@ManagedBean(name="sessaoListaController")
public class SessaoListaController implements Serializable{
	private SessaoDao sessaoDao = DaoFactory.getSessaoDao();
	/**
	 * Armazena as sessoes mostrados na view
	 */
	private List<Sessao> sessoes;
	
	/**
	 * Recebe o id da sessao para ser exclu�do
	 */
	private Long id;
	
	/**
	 * M�todo que � chamado quando a view � aberta
	 * pela primeira vez
	 */
	@PostConstruct
	public void buscaTodos() {
		sessoes = sessaoDao.findAll();
	}

	/**
	 * M�todo que exclui um sessao
	 */
	public void excluir() {
		if(id!=null) {
			Sessao sessao = sessaoDao.findById(id);
			if(sessao!=null) {
				sessaoDao.remove(sessao);
				
				//Chama o buscaTodos para atualizar a lista
				buscaTodos();
			}
		}
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Sessao> getSessoes() {
		return sessoes;
	}
}
