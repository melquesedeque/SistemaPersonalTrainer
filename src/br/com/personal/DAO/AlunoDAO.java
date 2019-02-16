package br.com.personal.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import br.com.personal.ConexaoFactory.ConexaoFactory;
import br.com.personal.MODEL.AlunoModal;

public class AlunoDAO {

	public void salvar(AlunoModal aluno) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO alunos (nome, cpf, rg, nascimento, sexo, cor, peso, altura, gordura, sangue, motivo, id_treinador) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

		Connection conexao = ConexaoFactory.conectar();

		// Formatar a Data para Salvar no Banco

		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		aluno.setData_nascimento(f.format(aluno.getData()));

		PreparedStatement comando = conexao.prepareStatement(sql);
		comando.setString(1, aluno.getNome());
		comando.setString(2, aluno.getCpf());
		comando.setString(3, aluno.getRg());
		comando.setString(4, aluno.getData_nascimento());
		comando.setString(5, aluno.getSexo());
		comando.setString(6, aluno.getCor());
		comando.setString(7, aluno.getPeso());
		comando.setString(8, aluno.getAltura());
		comando.setString(9, aluno.getGordura());
		comando.setString(10, aluno.getSanguinio());
		comando.setString(11, aluno.getMotivo());
		comando.setLong(12, aluno.getId_treinador());
		
		comando.executeUpdate();
	}

	public void excluir(AlunoModal aluno) throws ClassNotFoundException, SQLException {
		String sql = "DELETE FROM alunos WHERE id_alunos = ? ";

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql);
		comando.setLong(1, aluno.getId());

		comando.executeUpdate();
	}

	public void editar(AlunoModal aluno) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE alunos SET nome = ?, cpf = ?, rg = ?, nascimento = ?, sexo = ?, cor = ?, peso = ?, altura = ?, gordura = ?, sangue = ?, motivo = ? WHERE id_alunos = ?";

		Connection conexao = ConexaoFactory.conectar();
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		aluno.setData_nascimento(f.format(aluno.getData()));

		PreparedStatement comando = conexao.prepareStatement(sql);

		comando.setString(1, aluno.getNome());
		comando.setString(2, aluno.getCpf());
		comando.setString(3, aluno.getRg());
		comando.setString(4, aluno.getData_nascimento());
		comando.setString(5, aluno.getSexo());
		comando.setString(6, aluno.getCor());
		comando.setString(7, aluno.getPeso());
		comando.setString(8, aluno.getAltura());
		comando.setString(9, aluno.getGordura());
		comando.setString(10, aluno.getSanguinio());
		comando.setString(11, aluno.getMotivo());
		comando.setLong(12, aluno.getId());

		comando.executeUpdate();

	}

	public ArrayList<AlunoModal> listar(Long id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT id_alunos, nome, cpf, rg, nascimento, sexo, cor, peso, altura, gordura, sangue, motivo, id_treinador FROM alunos WHERE id_treinador = ?";

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql);
		comando.setLong(1, id);
		
		ResultSet resultado = comando.executeQuery();

		ArrayList<AlunoModal> lista = new ArrayList<>();

		while (resultado.next()) {
			AlunoModal aluno = new AlunoModal();
			aluno.setId(resultado.getLong("id_alunos"));
			aluno.setNome(resultado.getString("nome"));
			aluno.setCpf(resultado.getString("cpf"));
			aluno.setRg(resultado.getString("rg"));
			aluno.setData_nascimento(resultado.getString("nascimento"));
			aluno.setSexo(resultado.getString("sexo"));
			aluno.setCor(resultado.getString("cor"));
			aluno.setPeso(resultado.getString("peso"));
			aluno.setAltura(resultado.getString("altura"));
			aluno.setGordura(resultado.getString("gordura"));
			aluno.setSanguinio(resultado.getString("sangue"));
			aluno.setMotivo(resultado.getString("motivo"));
			aluno.setId_treinador(resultado.getLong("id_treinador"));

			lista.add(aluno);
		}
		return lista;
	}

	public ArrayList<AlunoModal> listarPorNome() throws ClassNotFoundException, SQLException {
		String sql = "SELECT nome FROM alunos order by nome ASC";

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		ResultSet resultado = comando.executeQuery();

		ArrayList<AlunoModal> lista = new ArrayList<>();

		while (resultado.next()) {
			AlunoModal aluno = new AlunoModal();
			aluno.setNome(resultado.getString("nome"));

			lista.add(aluno);
		}
		return lista;
	}

	public String buscarPorId(AlunoModal aluno) throws ClassNotFoundException, SQLException {
		String sql = "SELECT nome FROM alunos WHERE id_alunos = ? ";

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, aluno.getId());

		ResultSet resultado = comando.executeQuery();

		AlunoModal retorno = null;

		if (resultado.next()) {
			retorno = new AlunoModal();
			retorno.setNome(resultado.getString("nome"));
		}
		return retorno.getNome();
	}

	/*public static void main(String[] args) {
		AlunoModal aluno = new AlunoModal();
		aluno.setNome("nome Teste");
		aluno.setCpf("999.222.333-55");
		aluno.setRg("9686513");
		aluno.setData_nascimento("21/10/1999");
		aluno.setSexo("masculino");
		aluno.setCor("nego");
		aluno.setPeso("188kg");
		aluno.setAltura("1.78m");
		aluno.setGordura("20%");
		aluno.setSanguinio("A-");
		aluno.setMotivo("Perda de Peso");

		try {
			System.out.println("entrou");
			AlunoDAO alunoDAO = new AlunoDAO();
			alunoDAO.salvar(aluno);
			System.out.println("INSERT realizado com sucesso");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Falhou");
		}

		AlunoDAO listarAluno = new AlunoDAO();

		try {
			ArrayList<AlunoModal> lista = listarAluno.listarPorNome();

			for (AlunoModal a : lista) {
				System.out.println("Nome do Aluno -> " + a);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Erro");
		}

	}*/

	/*
	 * public static void main(String[] args) {
	 * 
	 * try {
	 * 
	 * AlunoModal aluno = new AlunoModal(); aluno.setId(8L);
	 * 
	 * AlunoDAO alunoDao = new AlunoDAO(); AlunoModal teste =
	 * alunoDao.buscarPorId(aluno);
	 * 
	 * System.out.println("Deu Certo " + teste); } catch (ClassNotFoundException |
	 * SQLException e) { e.printStackTrace(); System.out.println("Erro ao Listar");
	 * } }
	 */
}
