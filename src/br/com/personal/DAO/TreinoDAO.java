package br.com.personal.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.personal.ConexaoFactory.ConexaoFactory;
import br.com.personal.MODEL.TreinoModal;

public class TreinoDAO {

	public void salvar(TreinoModal treino) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO treinos (nome_aluno, coxas_exer, coxas_series, coxas_repe, biceps_exer, biceps_series, biceps_repe, ombro_exer, ombro_series, ombro_repe, panturrilha_exer, panturrilha_series, panturrilha_repe, ante_exer, ante_serie, ante_repe, trapezio_exer, trapezio_serie, trapezio_repe, obs, alunos_id_alunos, id_treinador) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql);
		
		comando.setString(1, treino.getNome_aluno());
		comando.setString(2, treino.getCoxas_exer());
		comando.setString(3, treino.getCoxas_series());
		comando.setString(4, treino.getCoxas_repe());
		comando.setString(5, treino.getBiceps_exer());
		comando.setString(6, treino.getBiceps_series());
		comando.setString(7, treino.getBiceps_repe());
		comando.setString(8, treino.getOmbro_exer());
		comando.setString(9, treino.getOmbro_series());
		comando.setString(10, treino.getOmbro_repe());
		comando.setString(11, treino.getPanturrilha_exer());
		comando.setString(12, treino.getPanturrilha_series());
		comando.setString(13, treino.getPanturrilha_repe());
		comando.setString(14, treino.getAnte_exer());
		comando.setString(15, treino.getAnte_serie());
		comando.setString(16, treino.getAnte_repe());
		comando.setString(17, treino.getTrapezio_exer());
		comando.setString(18, treino.getTrapazio_serie());
		comando.setString(19, treino.getTrapezio_repe());
		comando.setString(20, treino.getObs());
		comando.setLong(21, treino.getAlunos_id_alunos());
		comando.setLong(22, treino.getIdTreinador());
		
		comando.executeUpdate();
	}
	
	public ArrayList<TreinoModal> listar(Long id) throws ClassNotFoundException, SQLException{
		String sql = "SELECT id_treino ,alunos_id_alunos, nome_aluno, coxas_exer, coxas_series, coxas_repe, biceps_exer, biceps_series, biceps_repe, ombro_exer, ombro_series, ombro_repe, panturrilha_exer, panturrilha_series, panturrilha_repe, ante_exer, ante_serie, ante_repe, trapezio_exer, trapezio_serie, trapezio_repe, obs, id_treinador FROM treinos WHERE id_treinador = ?";
		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql);
		comando.setLong(1, id);
		
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<TreinoModal> lista = new ArrayList<>();
		
		while(resultado.next()) {
			TreinoModal treino = new TreinoModal();
			treino.setId_treino(resultado.getLong("id_treino"));
			treino.setAlunos_id_alunos(resultado.getLong("alunos_id_alunos"));
			treino.setNome_aluno(resultado.getString("nome_aluno"));
			treino.setCoxas_exer(resultado.getString("coxas_exer"));;
			treino.setCoxas_series(resultado.getString("coxas_series"));
			treino.setCoxas_repe(resultado.getString("coxas_repe"));
			treino.setBiceps_exer(resultado.getString("biceps_exer"));
			treino.setBiceps_series(resultado.getString("biceps_series"));
			treino.setBiceps_repe(resultado.getString("biceps_repe"));
			treino.setOmbro_exer(resultado.getString("ombro_exer"));
			treino.setOmbro_series(resultado.getString("ombro_series"));
			treino.setOmbro_repe(resultado.getString("ombro_repe"));
			treino.setPanturrilha_exer(resultado.getString("panturrilha_exer"));
			treino.setPanturrilha_series(resultado.getString("panturrilha_series"));
			treino.setPanturrilha_repe(resultado.getString("panturrilha_repe"));
			treino.setAnte_exer(resultado.getString("ante_exer"));
			treino.setAnte_serie(resultado.getString("ante_serie"));
			treino.setAnte_repe(resultado.getString("ante_repe"));
			treino.setTrapezio_exer(resultado.getString("trapezio_exer"));
			treino.setTrapazio_serie(resultado.getString("trapezio_serie"));
			treino.setTrapezio_repe(resultado.getString("trapezio_repe"));
			treino.setObs(resultado.getString("obs"));
			treino.setIdTreinador(resultado.getLong("id_treinador"));
			
			lista.add(treino);
		}
		
		
		return lista;
	}
	
	public void deletar(TreinoModal treino) throws ClassNotFoundException, SQLException {
		String sql = "DELETE FROM treinos WHERE id_treino = ? ";
		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql);
		comando.setLong(1, treino.getId_treino());
		
		comando.executeUpdate();
	}
	
	public void editar(TreinoModal treino) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE treinos set alunos_id_alunos = ? , nome_aluno = ? , coxas_exer = ? , coxas_series = ? , coxas_repe = ? , biceps_exer = ? , biceps_series = ? , biceps_repe = ? , ombro_exer = ? , ombro_series = ? , ombro_repe = ? , panturrilha_exer = ? , panturrilha_series = ? , panturrilha_repe = ? , ante_exer = ? , ante_serie = ? , ante_repe = ? , trapezio_exer = ? , trapezio_serie = ? , trapezio_repe = ? , obs = ? WHERE id_treino = ? ";
		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql);
		
		comando.setLong(1, treino.getAlunos_id_alunos());
		comando.setString(2, treino.getNome_aluno());
		comando.setString(3, treino.getCoxas_exer());
		comando.setString(4, treino.getCoxas_series());
		comando.setString(5, treino.getCoxas_repe());
		comando.setString(6, treino.getBiceps_exer());
		comando.setString(7, treino.getBiceps_series());
		comando.setString(8, treino.getBiceps_repe());
		comando.setString(9, treino.getOmbro_exer());
		comando.setString(10, treino.getOmbro_series());
		comando.setString(11, treino.getOmbro_repe());
		comando.setString(12, treino.getPanturrilha_exer());
		comando.setString(13, treino.getPanturrilha_series());
		comando.setString(14, treino.getPanturrilha_repe());
		comando.setString(15, treino.getAnte_exer());
		comando.setString(16, treino.getAnte_serie());
		comando.setString(17, treino.getAnte_repe());
		comando.setString(18, treino.getTrapezio_exer());
		comando.setString(19, treino.getTrapazio_serie());
		comando.setString(20, treino.getTrapezio_repe());
		comando.setString(21, treino.getObs());
		comando.setLong(22, treino.getId_treino());
		
		comando.executeUpdate();
	}
	
	/*public static void main(String[] args) {
		
		TreinoModal treino = new TreinoModal();
		
		treino.setAlunos_id_alunos(1L);
		treino.setNome_aluno("Sarah Teste");
		treino.setCoxas_exer("teste");
		treino.setCoxas_series("teste_series");
		treino.setCoxas_repe("teste_repe");
		
		try {
			TreinoDAO TreinoDAO = new TreinoDAO();
			TreinoDAO.salvar(treino);
			System.out.println("Insert Certo");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Erro no Insert");
		}
	}*/
	
	/*public static void main(String[] args) {
		
		TreinoDAO treino_aluno = new TreinoDAO();
		
		try {
			ArrayList<TreinoModal> lista = treino_aluno.listar();
			
			for (TreinoModal treinoModal : lista) {
				System.out.println("Nome do Aluno -> "+treinoModal);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Erro no Listar");
		}
	}*/
	
	/*public static void main(String[] args) {
		
		try {
			TreinoModal treino = new TreinoModal();
			treino.setId_treino(3L);
			TreinoDAO treinoDao = new TreinoDAO();
			treinoDao.deletar(treino);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao Deletar");
		}
	}*/
	
	/*public static void main(String[] args) {
		
		try {
			TreinoModal treino =  new TreinoModal();
			treino.setId_treino(7L);
			treino.setAlunos_id_alunos(8L);
			treino.setCoxas_repe("20");
			treino.setCoxas_series("20");
			
			TreinoDAO treinoDao = new TreinoDAO();
			treinoDao.editar(treino);
			
			System.out.println("Editado Show");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Falhou");
		}
	}*/
}
