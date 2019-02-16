package br.com.personal.MODEL;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class UsuarioModel {
	private Long idTreinador;
	private String usuario;
	private String senha;
	
	@Override
	public String toString() {
		String saida = idTreinador + "/" + usuario + "/" + senha;
		return saida;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getIdTreinador() {
		return idTreinador;
	}

	public void setIdTreinador(Long idTreinador) {
		this.idTreinador = idTreinador;
	}

}
