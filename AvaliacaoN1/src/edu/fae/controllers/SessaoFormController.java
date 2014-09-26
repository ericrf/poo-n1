package edu.fae.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.fae.dao.DaoFactory;
import edu.fae.dao.FilmeDao;
import edu.fae.dao.SalaDao;
import edu.fae.dao.SessaoDao;
import edu.fae.model.Filme;
import edu.fae.model.Sala;
import edu.fae.model.Sessao;

@ViewScoped
@ManagedBean(name = "sessaoFormController")
public class SessaoFormController implements Serializable {
	private SessaoDao sessaoDao = DaoFactory.getSessaoDao();
	private SalaDao salaDao = DaoFactory.getSalaDao();
	private FilmeDao filmeDao = DaoFactory.getFilmeDao();

	private Sessao sessao;

	@PostConstruct
	public void iniciar() {
		String id = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("id");
		if (id == null) {
			sessao = new Sessao();
		} else {
			sessao = sessaoDao.findById(new Long(id));
		}
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void salvar() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		sessaoDao.save(sessao);
		ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Sessao salva com sucesso!", null));
	}

	public List<Sala> getSalas() {
		return salaDao.findAll();
	}

	public List<Filme> getFilmes() {
		return filmeDao.findAll();
	}

	public void comprar() {
		if(sessao.getQtdeDisponivel() > 0){
			int ingressosVendidos = sessao.getIngressosVendidos() + 1;
			sessao.setIngressosVendidos(ingressosVendidos);
			
			sessaoDao.save(sessao);
			return;
		}
		
		FacesContext.getCurrentInstance().addMessage(null, 
		new FacesMessage(FacesMessage.SEVERITY_INFO, "Sessão está cheia!", null));
	}

}
