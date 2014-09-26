package edu.fae.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.DualListModel;

import edu.fae.dao.AtorDao;
import edu.fae.dao.DaoFactory;
import edu.fae.dao.FilmeDao;
import edu.fae.model.Ator;
import edu.fae.model.Filme;
import edu.fae.util.DualListModelDiff;

@ViewScoped
@ManagedBean(name="filmeFormController")
public class FilmeFormController implements Serializable {
	private FilmeDao filmeDao = DaoFactory.getFilmeDao();
	private AtorDao atorDao = DaoFactory.getAtorDao();
	private Filme filme;

	@PostConstruct
	public void iniciar() {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if(id==null) {
			filme = new Filme();
		}else{
			filme = filmeDao.findById(new Long(id));
		}
		
	}
	public Filme getFilme() {
		return filme;
	}
	
	public void salvar() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		filmeDao.save(filme);
		
		ctx.addMessage(null, 
			new FacesMessage(FacesMessage.SEVERITY_INFO, "Filme salvo com sucesso!", null)
		);
	}
	
	public DualListModel<Ator> getAtores() {
		return new DualListModelDiff<Ator>(atorDao.findAll(), filme.getAtores());
	}	
	public void setAtores(DualListModel<Ator> target) {
		filme.setAtores(target.getTarget());
	}
}
