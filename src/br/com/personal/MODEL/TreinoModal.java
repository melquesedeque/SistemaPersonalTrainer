package br.com.personal.MODEL;

public class TreinoModal {

	private Long id_treino;
	private String nome_aluno;
	private String coxas_exer;
	private String coxas_series;
	private String coxas_repe;
	private String biceps_exer;
	private String biceps_series;
	private String biceps_repe;
	private String ombro_exer;
	private String ombro_series;
	private String ombro_repe;
	private String panturrilha_exer;
	private String panturrilha_series;
	private String panturrilha_repe;
	private String ante_exer;
	private String ante_serie;
	private String ante_repe;
	private String trapezio_exer;
	private String trapazio_serie;
	private String trapezio_repe;
	private String obs;
	private Long alunos_id_alunos;
	private Long idTreinador;
	
	private AlunoModal aluno = new AlunoModal();
	
	@Override
	public String toString() {
		String saida = id_treino + " / " +alunos_id_alunos + " / " + " / " + nome_aluno + "/" + coxas_exer + "/" + coxas_series
				+ "/" + coxas_repe + "/" + biceps_exer + "/" + biceps_series + "/" + biceps_repe + "/" + ombro_exer
				+ "/" + ombro_series + "/" + ombro_repe + "/" + panturrilha_exer + "/" + "/" + panturrilha_series + "/"
				+ panturrilha_repe + "/" + ante_exer + "/" + ante_serie + "/" + ante_repe + "/" + trapezio_exer + "/"
				+ trapazio_serie + "/" + trapezio_repe + "/" + obs + "/" + idTreinador;
		return saida;
	}

	public Long getId_treino() {
		return id_treino;
	}

	public void setId_treino(Long id_treino) {
		this.id_treino = id_treino;
	}

	public Long getAlunos_id_alunos() {
		return alunos_id_alunos;
	}

	public void setAlunos_id_alunos(Long alunos_id_alunos) {
		this.alunos_id_alunos = alunos_id_alunos;
	}

	public String getNome_aluno() {
		return nome_aluno;
	}

	public void setNome_aluno(String nome_aluno) {
		this.nome_aluno = nome_aluno;
	}

	public String getCoxas_exer() {
		return coxas_exer;
	}

	public void setCoxas_exer(String coxas_exer) {
		this.coxas_exer = coxas_exer;
	}

	public String getCoxas_series() {
		return coxas_series;
	}

	public void setCoxas_series(String coxas_series) {
		this.coxas_series = coxas_series;
	}

	public String getCoxas_repe() {
		return coxas_repe;
	}

	public void setCoxas_repe(String coxas_repe) {
		this.coxas_repe = coxas_repe;
	}

	public String getBiceps_exer() {
		return biceps_exer;
	}

	public void setBiceps_exer(String biceps_exer) {
		this.biceps_exer = biceps_exer;
	}

	public String getBiceps_series() {
		return biceps_series;
	}

	public void setBiceps_series(String biceps_series) {
		this.biceps_series = biceps_series;
	}

	public String getBiceps_repe() {
		return biceps_repe;
	}

	public void setBiceps_repe(String biceps_repe) {
		this.biceps_repe = biceps_repe;
	}

	public String getOmbro_exer() {
		return ombro_exer;
	}

	public void setOmbro_exer(String ombro_exer) {
		this.ombro_exer = ombro_exer;
	}

	public String getOmbro_series() {
		return ombro_series;
	}

	public void setOmbro_series(String ombro_series) {
		this.ombro_series = ombro_series;
	}

	public String getOmbro_repe() {
		return ombro_repe;
	}

	public void setOmbro_repe(String ombro_repe) {
		this.ombro_repe = ombro_repe;
	}

	public String getPanturrilha_exer() {
		return panturrilha_exer;
	}

	public void setPanturrilha_exer(String panturrilha_exer) {
		this.panturrilha_exer = panturrilha_exer;
	}

	public String getPanturrilha_series() {
		return panturrilha_series;
	}

	public void setPanturrilha_series(String panturrilha_series) {
		this.panturrilha_series = panturrilha_series;
	}

	public String getPanturrilha_repe() {
		return panturrilha_repe;
	}

	public void setPanturrilha_repe(String panturrilha_repe) {
		this.panturrilha_repe = panturrilha_repe;
	}

	public String getAnte_exer() {
		return ante_exer;
	}

	public void setAnte_exer(String ante_exer) {
		this.ante_exer = ante_exer;
	}

	public String getAnte_serie() {
		return ante_serie;
	}

	public void setAnte_serie(String ante_serie) {
		this.ante_serie = ante_serie;
	}

	public String getAnte_repe() {
		return ante_repe;
	}

	public void setAnte_repe(String ante_repe) {
		this.ante_repe = ante_repe;
	}

	public String getTrapezio_exer() {
		return trapezio_exer;
	}

	public void setTrapezio_exer(String trapezio_exer) {
		this.trapezio_exer = trapezio_exer;
	}

	public String getTrapazio_serie() {
		return trapazio_serie;
	}

	public void setTrapazio_serie(String trapazio_serie) {
		this.trapazio_serie = trapazio_serie;
	}

	public String getTrapezio_repe() {
		return trapezio_repe;
	}

	public void setTrapezio_repe(String trapezio_repe) {
		this.trapezio_repe = trapezio_repe;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public AlunoModal getAluno() {
		return aluno;
	}

	public void setAluno(AlunoModal aluno) {
		this.aluno = aluno;
	}

	public Long getIdTreinador() {
		return idTreinador;
	}

	public void setIdTreinador(Long idTreinador) {
		this.idTreinador = idTreinador;
	}
	
}
