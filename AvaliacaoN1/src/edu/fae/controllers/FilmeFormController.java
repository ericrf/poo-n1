package edu.fae.controllers;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.fae.dao.DaoFactory;
import edu.fae.dao.FilmeDao;
import edu.fae.model.Filme;

@ViewScoped
@ManagedBean(name="filmeFormController")
public class FilmeFormController {
	private FilmeDao filmeDao = DaoFactory.getFilmeDao();
	private Filme filme;

	@PostConstruct
	public void iniciar() {
		//Pegando o par�metro id da URL
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if(id==null) {//Quando o id est� null, abrimos o formul�rio para inser��o
			filme = new Filme();
		}else{//Quando o id � passado como par�metro abrimos o formul�rio para edi��o
			filme = filmeDao.findById(new Long(id));
		}
	}
	public Filme getFilme() {
		return filme;
	}
	
	public void salvar() {
		//Pegamos uma referencia para o FacesContext, para mandar mensagens para a tela
		FacesContext ctx = FacesContext.getCurrentInstance();
		

		//Chama o filmeDao para salvar o objeto Filme
		filmeDao.save(filme);
		
		//Mandando uma mensagem para a tela
		ctx.addMessage(null, 
			new FacesMessage(FacesMessage.SEVERITY_INFO, "Filme salva com sucesso!", null)
		);
	}
	

}
