package br.com.personal.CONTROLE;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

import br.com.personal.DAO.AgendaDAO;
import br.com.personal.MODEL.AgendaModal;
import br.com.personal.MODEL.UsuarioModel;

@ManagedBean
@SessionScoped
public class AgendaControle {
	private ListDataModel<AgendaModal> itens;
	AgendaModal agendaModal = new AgendaModal();
	private Long idTreinador;

	@PostConstruct
	public void listarAgenda() {
		UsuarioModel user = new UsuarioModel();
		user = (UsuarioModel) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioSession");

		if (user != null) {
			this.idTreinador = user.getIdTreinador();
		}

		try {
			AgendaDAO agendalistar = new AgendaDAO();

			if (this.idTreinador != null) {
				ArrayList<AgendaModal> lista = agendalistar.listar(this.idTreinador);
				itens = new ListDataModel<AgendaModal>(lista);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao Listar Agenda");
		}
	}

	public String salvar() {

		try {
			AgendaDAO agendaSalvar = new AgendaDAO();
			this.agendaModal.setIdTreinador(this.idTreinador);

			agendaSalvar.salvar(agendaModal);
			
			if(agendaSalvar != null) {
				agendaModal = new AgendaModal();
				
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Agenda Cadastrato com Sucesso!", "");
	            FacesContext ct = FacesContext.getCurrentInstance();
	            ct.addMessage(null, msg);
				
				listarAgenda();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso, Já existe uma Agendamento Cadastrado com a data "+ this.agendaModal.getDataAgenda() +" no Sistema!", "");
            FacesContext ct = FacesContext.getCurrentInstance();
            ct.addMessage(null, msg);
			
			e.printStackTrace();
		}
		return "/";
	}

	public void prepararExclursao() {
		agendaModal = itens.getRowData();
	}

	public void deletar() {

		try {
			AgendaDAO agendaDeletar = new AgendaDAO();
			
			agendaDeletar.deletar(agendaModal);
			
			if(agendaDeletar != null) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Agenda Deletada com Sucesso!", "");
	            FacesContext ct = FacesContext.getCurrentInstance();
	            ct.addMessage(null, msg);
				
				listarAgenda();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso, Erro ao Deletar Agenda!", "");
            FacesContext ct = FacesContext.getCurrentInstance();
            ct.addMessage(null, msg);
			
			e.printStackTrace();
		}
	}

	public void preparaEdicao() {
		agendaModal = itens.getRowData();
	}

	public void editar() {

		try {
			AgendaDAO agendaEditar = new AgendaDAO();
			agendaEditar.editar(agendaModal);
			
			if(agendaEditar != null) {
				
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Agenda Editada com Sucesso!", "");
	            FacesContext ct = FacesContext.getCurrentInstance();
	            ct.addMessage(null, msg);
				
				listarAgenda();
			}

		} catch (ClassNotFoundException | SQLException e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso, Erro ao Editar Agenda!", "");
            FacesContext ct = FacesContext.getCurrentInstance();
            ct.addMessage(null, msg);
			
			e.printStackTrace();
		}
	}

	public ListDataModel<AgendaModal> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<AgendaModal> itens) {
		this.itens = itens;
	}

	public AgendaModal getAgendaModal() {
		return agendaModal;
	}

	public void setAgendaModal(AgendaModal agendaModal) {
		this.agendaModal = agendaModal;
	}

}
