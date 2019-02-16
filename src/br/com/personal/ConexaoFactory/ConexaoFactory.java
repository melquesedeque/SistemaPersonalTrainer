package br.com.personal.ConexaoFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	private static final String USUARIO = "root"; // Final(ela é uma variavel constante); static(não precisa criar o new Objeto para acessar) 
	private static final String SENHA = "";
	private static final String URL = "jdbc:mysql://localhost:3306/web";
	
	
	public static Connection conectar() throws SQLException, ClassNotFoundException{
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		/*Class.forName("com.mysql.jdbc.Driver");*/
		Connection conexao;
		conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

		return conexao;
			
	}
	
	/*public static void main(String[] args) throws ClassNotFoundException {
		
			try {
				Connection conexao = ConexaoFactory.conectar();
				System.out.println("Conexão realizada com Sucesso");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Não foi possivel Realizar a Conexão");
			}
			
	}*/
}
