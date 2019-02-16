package br.com.personal.CONTROLE;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

import br.com.personal.DAO.AlunoDAO;
import br.com.personal.DAO.TreinoDAO;
import br.com.personal.MODEL.AlunoModal;
import br.com.personal.MODEL.TreinoModal;
import br.com.personal.MODEL.UsuarioModel;

@ManagedBean
@SessionScoped
public class TreinoControle {
	private ListDataModel<TreinoModal> itens_treino;
	TreinoModal treinoModal =  new TreinoModal();
	private Long idTreinador;
	
	@PostConstruct
	public void prepararPesquisa() {
		UsuarioModel user = new UsuarioModel();
		user = (UsuarioModel) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioSession");
		
		if(user != null) {
			this.idTreinador = user.getIdTreinador();
		}
		
		try {
			TreinoDAO treinoDao = new TreinoDAO();
			
			if(this.idTreinador != null) {
				ArrayList<TreinoModal> lista = treinoDao.listar(this.idTreinador);
				itens_treino = new ListDataModel<TreinoModal>(lista);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao Listar treinos");
		}
	}
	
	public void salvar() {
		
		try {
			TreinoDAO treinoDao =  new TreinoDAO();
			AlunoDAO alunoDao = new AlunoDAO();
			AlunoModal aluno =  new AlunoModal();
			
			aluno.setId(treinoModal.getAlunos_id_alunos());
			this.treinoModal.setNome_aluno(alunoDao.buscarPorId(aluno));
			this.treinoModal.setIdTreinador(this.idTreinador);
			
			treinoDao.salvar(treinoModal);
			
			if(treinoDao != null) {
				treinoModal =  new TreinoModal();
				
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Treino Cadastrato com Sucesso!", "");
	            FacesContext ct = FacesContext.getCurrentInstance();
	            ct.addMessage(null, msg);
	            
	            prepararPesquisa();
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void PrepaExclusao() {
		treinoModal = itens_treino.getRowData();
	}
	
	public void excluir() {
		
		try {
			TreinoDAO treinoDAO = new TreinoDAO();
			treinoDAO.deletar(treinoModal);
			
			if(treinoDAO != null) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Treino Excluido com Sucesso!", "");
	            FacesContext ct = FacesContext.getCurrentInstance();
	            ct.addMessage(null, msg);
	            
				prepararPesquisa();
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao Excluir");
		}
	}
	
	public void prepaEdicao() {
		treinoModal = itens_treino.getRowData();
	}
	
	public void editar() {
		
		try {
			TreinoDAO treinoDao =  new TreinoDAO();
			treinoDao.editar(treinoModal);
			
			if(treinoDao != null) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Treino Editado com Sucesso!", "");
	            FacesContext ct = FacesContext.getCurrentInstance();
	            ct.addMessage(null, msg);
	            
				prepararPesquisa();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public ListDataModel<TreinoModal> getItens_treino() {
		return itens_treino;
	}

	public void setItens_treino(ListDataModel<TreinoModal> itens_treino) {
		this.itens_treino = itens_treino;
	}

	public TreinoModal getTreinoModal() {
		return treinoModal;
	}

	public void setTreinoModal(TreinoModal treinoModal) {
		this.treinoModal = treinoModal;
	}
	
}
