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
import br.com.personal.MODEL.AlunoModal;
import br.com.personal.MODEL.UsuarioModel;

@ManagedBean
@SessionScoped
public class AlunoControle {
	private ListDataModel<AlunoModal> itens;
	AlunoModal CadastroAluno = new AlunoModal();
	private ArrayList<AlunoModal> listaAluno;
	private Long idTreinador;

	@PostConstruct
	public void PrepararPesquisa() {
		UsuarioModel user = new UsuarioModel();
		user = (UsuarioModel) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioSession");

		try {
			this.idTreinador = user.getIdTreinador();
			System.out.println("Id do treinador " + user.getIdTreinador());
			System.out.println("Nome treinador " + user.getUsuario());

			if (user != null) {
				AlunoDAO alunoDAO = new AlunoDAO();
				ArrayList<AlunoModal> lista = alunoDAO.listar(user.getIdTreinador());
				
				this.listaAluno = alunoDAO.listar(user.getIdTreinador());// colocar parametro do obeto da sessao
				itens = new ListDataModel<AlunoModal>(lista);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso, Erro ao Listar ALunos", null);
            FacesContext ct = FacesContext.getCurrentInstance();
            ct.addMessage(null, msg);
		}
	}

	public void salvar() {

		try {
			AlunoDAO alunoDao = new AlunoDAO();
			this.CadastroAluno.setId_treinador(this.idTreinador);

			alunoDao.salvar(CadastroAluno);
			
			if(alunoDao != null) {
				CadastroAluno = new AlunoModal();
				
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aluno Cadastrato com Sucesso!", "");
	            FacesContext ct = FacesContext.getCurrentInstance();
	            ct.addMessage(null, msg);
	            
	            PrepararPesquisa();
			}
			
		} catch (ClassNotFoundException e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso, Erro ALunos!", "");
            FacesContext ct = FacesContext.getCurrentInstance();
            ct.addMessage(null, msg);
			e.printStackTrace();
		} catch (SQLException e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso, Erro ao Salvar ALunos", "");
            FacesContext ct = FacesContext.getCurrentInstance();
            ct.addMessage(null, msg);
			e.printStackTrace();
		}
		
	}

	public void PrepararExclusao() {
		CadastroAluno = itens.getRowData(); // pega todos os dado da linha selecionadada
	}

	public void excluir() {

		try {
			AlunoDAO alunoDao = new AlunoDAO();
			alunoDao.excluir(CadastroAluno);
			
			if(alunoDao != null) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aluno Excluido com Sucesso!", "");
	            FacesContext ct = FacesContext.getCurrentInstance();
	            ct.addMessage(null, msg);
	            
				PrepararPesquisa();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public void PrepararEdicao() {
		CadastroAluno = itens.getRowData();// pega todos os dado da linha selecionadada
	}

	public void editar() {

		try {
			AlunoDAO alunoDao = new AlunoDAO();
			alunoDao.editar(CadastroAluno);

			if (alunoDao != null) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aluno Editado com Sucesso!", "");
	            FacesContext ct = FacesContext.getCurrentInstance();
	            ct.addMessage(null, msg);
	            
				PrepararPesquisa();
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao Editar Aluno");
		}
	}

	public ListDataModel<AlunoModal> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<AlunoModal> itens) {
		this.itens = itens;
	}

	public AlunoModal getCadastroAluno() {
		return CadastroAluno;
	}

	public void setCadastroAluno(AlunoModal cadastroAluno) {
		CadastroAluno = cadastroAluno;
	}

	public ArrayList<AlunoModal> getListaAluno() {
		return listaAluno;
	}

	public void setListaAluno(ArrayList<AlunoModal> listaAluno) {
		this.listaAluno = listaAluno;
	}

}
