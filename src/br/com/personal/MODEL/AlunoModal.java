package br.com.personal.MODEL;

import java.util.Date;

public class AlunoModal {

	private Long id;
	private String nome;
	private String cpf;
	private String rg;
	private String sexo;
	private String data_nascimento;
	private String cor;
	private String peso;
	private String altura;
	private String gordura;
	private String motivo;
	private String sanguinio;
	private Date data;
	private Long id_treinador;

	@Override
	public String toString() {
		String saida = id + "/" + nome + "/" + cpf + "/" + rg + "/" + sexo + "/" + data_nascimento + "/"+ cor + "/"+ peso + "/" + altura + "/" + gordura + "/" + motivo + "/" + sanguinio + "/" + id_treinador;
		return saida;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getGordura() {
		return gordura;
	}

	public void setGordura(String gordura) {
		this.gordura = gordura;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getSanguinio() {
		return sanguinio;
	}

	public void setSanguinio(String sanguinio) {
		this.sanguinio = sanguinio;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Long getId_treinador() {
		return id_treinador;
	}

	public void setId_treinador(Long id_treinador) {
		this.id_treinador = id_treinador;
	}
	
}
