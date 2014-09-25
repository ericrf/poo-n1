package edu.fae.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.fae.dao.DaoFactory;
import edu.fae.dao.SalaDao;
import edu.fae.model.Sala;

@ViewScoped
@ManagedBean(name="salaFormController")
public class SalaFormController implements Serializable{
	private SalaDao salaDao = DaoFactory.getSalaDao();
	private Sala sala;

	@PostConstruct
	public void iniciar() {
		//Pegando o parâmetro id da URL
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if(id==null) {//Quando o id está null, abrimos o formulário para inserção
			sala = new Sala();
		}else{//Quando o id é passado como parâmetro abrimos o formulário para edição
			sala = salaDao.findById(new Long(id));
		}
	}
	public Sala getSala() {
		return sala;
	}
	
	public void salvar() {
		//Pegamos uma referencia para o FacesContext, para mandar mensagens para a tela
		FacesContext ctx = FacesContext.getCurrentInstance();
		

		//Chama o salaDao para salvar o objeto Sala
		salaDao.save(sala);
		
		//Mandando uma mensagem para a tela
		ctx.addMessage(null, 
			new FacesMessage(FacesMessage.SEVERITY_INFO, "Sala salva com sucesso!", null)
		);
	}
	

}
