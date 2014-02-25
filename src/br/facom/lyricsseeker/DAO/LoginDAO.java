package br.facom.lyricsseeker.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import br.facom.lyricsseeker.DBConnection.SQLiteConnection;
import br.facom.lyricsseeker.models.Login;

public class LoginDAO {
	
	private static final Connection CONN = SQLiteConnection.getInstance();
	private static final String SELECT_ALL_QUERY = "SELECT * FROM LOGIN"; 
	
	
	public static List<Login> getAll() {
		List<Login> result = new LinkedList<Login>();
		try{
			Statement stmt = CONN.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_QUERY);
			while(rs.next()){
				Login each = new Login();
				each.setUsuario(rs.getString("usuario"));
				each.setSenha(rs.getString("senha"));
				result.add(each);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}
	
	public static boolean authenticate(Login user){
		boolean itsMe = false;
		List<Login> allOfUs = LoginDAO.getAll();
		for(Login each : allOfUs){
			if( each.getSenha().equals(user.getSenha()) && each.getUsuario().equals(user.getUsuario())){
				itsMe = true;
				break;
			}
		}
		return itsMe;
	}
	
}
