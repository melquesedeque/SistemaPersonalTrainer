package br.com.personal.MODEL;

import java.util.Date;

public class AgendaModal {

	private Long id_agenda;
	private String dataAgenda;
	private String Nome_Aluno;
	private Date data;
	private Long idAluno;
	private Long idTreinador;
	
	@Override
	public String toString(){
		return this.id_agenda + " / " + this.dataAgenda + " / " + this.Nome_Aluno + " / " + this.idAluno + " / " + this.idTreinador;
	}
	
	public Long getId_agenda() {
		return id_agenda;
	}
	public void setId_agenda(Long id_agenda) {
		this.id_agenda = id_agenda;
	}
	
	public String getNome_Aluno() {
		return Nome_Aluno;
	}
	public void setNome_Aluno(String nome_Aluno) {
		Nome_Aluno = nome_Aluno;
	}

	public String getDataAgenda() {
		return dataAgenda;
	}

	public void setDataAgenda(String dataAgenda) {
		this.dataAgenda = dataAgenda;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}

	public Long getIdTreinador() {
		return idTreinador;
	}

	public void setIdTreinador(Long idTreinador) {
		this.idTreinador = idTreinador;
	}
	
}
