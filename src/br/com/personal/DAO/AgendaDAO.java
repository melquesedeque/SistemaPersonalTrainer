package br.com.personal.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import br.com.personal.ConexaoFactory.ConexaoFactory;
import br.com.personal.MODEL.AgendaModal;

public class AgendaDAO {

	public void salvar(AgendaModal agenda) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO agenda (nome_aluno, data_agenda, id_treinador) VALUES (?,?,?)";
		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql);
		
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		agenda.setDataAgenda(f.format(agenda.getData()));
		
		comando.setString(1, agenda.getNome_Aluno());
		comando.setString(2, agenda.getDataAgenda());
		comando.setLong(3, agenda.getIdTreinador());
		
		comando.executeUpdate();
	}
	
	public void editar(AgendaModal agenda) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE agenda SET nome_aluno = ?, data_agenda = ? WHERE id_agenda = ? ";
		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql);
		
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		agenda.setDataAgenda(f.format(agenda.getData()));
		
		comando.setString(1, agenda.getNome_Aluno());
		comando.setString(2, agenda.getDataAgenda());
		comando.setLong(3, agenda.getId_agenda());
		
		comando.executeUpdate();
	}
	
	public void deletar(AgendaModal agenda) throws ClassNotFoundException, SQLException {
		String sql = "DELETE FROM agenda WHERE id_agenda = ?";
		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando =  conexao.prepareStatement(sql);
		comando.setLong(1, agenda.getId_agenda());
		
		comando.executeUpdate();
	}
	
	public ArrayList<AgendaModal> listar(Long id) throws ClassNotFoundException, SQLException{
		String sql = "SELECT id_agenda, nome_aluno, data_agenda, id_treinador FROM agenda WHERE id_treinador = ?";
		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql);
		comando.setLong(1, id);
		
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<AgendaModal> listar = new ArrayList<>();
		
		while(resultado.next()) {
			AgendaModal agenda = new AgendaModal();
			agenda.setId_agenda(resultado.getLong("id_agenda"));
			agenda.setNome_Aluno(resultado.getString("nome_aluno"));
			agenda.setDataAgenda(resultado.getString("data_agenda"));
			agenda.setIdTreinador(resultado.getLong("id_treinador"));
			
			listar.add(agenda);
		}
		
		return listar;
	}
	
	/*public static void main(String[] args) {
		
		try {
			AgendaModal agenda = new AgendaModal();

			agenda.setNome_Aluno("teste3");
			agenda.setDataAgenda("22-22-2018");
			
			AgendaDAO agendaSalvar = new AgendaDAO();
			agendaSalvar.salvar(agenda);
			
			System.out.println("Salvou");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Erro");
		}
	}*/
	
	/*public static void main(String[] args) {
		
		try {
			AgendaModal agenda =  new AgendaModal();
			AgendaDAO agendaeditar =  new AgendaDAO();
			
			agenda.setId_agenda(30L);
			agenda.setNome_Aluno("Show Aluno");
			agenda.setDataAgenda("02/01/2010");
			
			agendaeditar.editar(agenda);
			
			System.out.println("Editou");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Erro");
		}
	}*/
	
//	public static void main(String[] args) {
//		
//		try {
//			AgendaModal agenda =  new AgendaModal();
//			AgendaDAO agendaDeletar =  new AgendaDAO();
//			
//			agenda.setId_agenda(15L);
//			agendaDeletar.deletar(agenda);
//			
//			System.out.println("Deletou");
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//			System.out.println("Erro");
//		}
//	}
	
	/*public static void main(String[] args) {
		
		try {
			AgendaDAO agendaListar =  new AgendaDAO();
			
			ArrayList<AgendaModal> lista = agendaListar.listar();
			
			for (AgendaModal agendaModal : lista) {
				System.out.println(agendaModal);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Erro");
		}
		
		
	}*/
}
