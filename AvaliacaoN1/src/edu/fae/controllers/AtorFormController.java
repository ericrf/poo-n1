package edu.fae.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.fae.dao.DaoFactory;
import edu.fae.dao.AtorDao;
import edu.fae.model.Ator;

@ViewScoped
@ManagedBean(name="atorFormController")
public class AtorFormController implements Serializable{
	private AtorDao atorDao = DaoFactory.getAtorDao();
	private Ator ator;

	@PostConstruct
	public void iniciar() {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if(id==null) {
			ator = new Ator();
		}else{
			ator = atorDao.findById(new Long(id));
		}
	}
	public Ator getAtor() {
		return ator;
	}
	
	public void salvar() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		atorDao.save(ator);
		ctx.addMessage(null, 
			new FacesMessage(FacesMessage.SEVERITY_INFO, "Ator salva com sucesso!", null)
		);
	}
	

}
