package br.com.personal.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.personal.ConexaoFactory.ConexaoFactory;
import br.com.personal.MODEL.UsuarioModel;


public class LoginDAO {
	
	public Boolean logado = false;
	
	public UsuarioModel FazerLogin (String usuario, String senha) throws ClassNotFoundException, SQLException{
		UsuarioModel objUsuario = new UsuarioModel();
		
		String sql = "SELECT id_login, nome, senha FROM usuarios  WHERE nome = ? and senha = ?";
		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
    	comando.setString(1, usuario);
    	comando.setString(2, senha);		
		ResultSet resultado = comando.executeQuery();
		
				
		while(resultado.next()) {
			
			objUsuario.setIdTreinador(resultado.getLong("id_login"));
			objUsuario.setUsuario(resultado.getString("nome"));
			objUsuario.setSenha(resultado.getString("senha"));
			logado = true;	
		}
		return objUsuario;
		
	}
	
}
