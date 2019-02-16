package br.com.personal.CONTROLE;

import java.io.IOException;
import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.personal.DAO.LoginDAO;
import br.com.personal.MODEL.UsuarioModel;

@ManagedBean
@SessionScoped
public class LoginControle {
	UsuarioModel login =  new UsuarioModel();
	//FacesContext context = FacesContext.getCurrentInstance();
	
	public String Validando() throws ClassNotFoundException, SQLException {

		LoginDAO User = new LoginDAO();
		String caminho;

		UsuarioModel usuario = User.FazerLogin(this.login.getUsuario(), this.login.getSenha());
		
		System.out.println("Usuario Logado? " + User.logado);
		 
		if (usuario != null && User.logado) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioSession", usuario);
			//UsuarioModel user = (UsuarioModel) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioSession");
			//System.out.println("Nome do Usuario " +user.getUsuario());
			
			caminho = "menu.xhtml?faces-redirect=true";
		}else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso, Email ou senha inválidos!", null);
            FacesContext ct = FacesContext.getCurrentInstance();
            ct.addMessage(null, msg);
			caminho = "/";
			//caminho = "erro.xhtml?faces-redirect=true";
		}
		
		return caminho;
		
	
	}
	
	public void deslogar() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml?faces-redirect=true");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Não Deslogou");
		}
	}

	public UsuarioModel getLogin() {
		return login;
	}

	public void setLogin(UsuarioModel login) {
		this.login = login;
	}
	
}
