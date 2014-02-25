package br.facom.lyricsseeker.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import br.facom.lyricsseeker.DBConnection.SQLiteConnection;
import br.facom.lyricsseeker.models.Genero;

public class GeneroDAO {

	private static final Connection CONN = SQLiteConnection.getInstance();
	private static final String SELECT_ALL_QUERY = "SELECT * FROM GENERO";
	private static final String INSERT_QUERY = "INSERT INTO GENERO VALUES(null, '%s' ,'%s');";
	private static final String UPDATE_QUERY = "UPDATE GENERO SET nome_genero = '%s' , " +
			"descricao= '%s' WHERE nome_genero = '%s' ;";
	private static final String DELETE_QUERY = "DELETE FROM GENERO WHERE nome_genero = '%s' ;";
	private static final String SELECT_ONE_QUERY = "SELECT * FROM GENERO WHERE nome_genero= '%s' LIMIT 1";
	private static final String SELECT_SOME_QUERY = "SELECT * FROM GENERO WHERE lower(nome_genero) like '%%%s%%';";
	private static final String SELECT_BY_ID = "SELECT * FROM GENERO WHERE id_genero= %d";

	public List<Genero> getAll() {
		List<Genero> result = new LinkedList<Genero>();
		try {
			Statement stmt = CONN.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_QUERY);
			while (rs.next()) {
				Genero each = new Genero();
				each.setNomeGenero(rs.getString("nome_genero"));
				each.setDescricao(rs.getString("descricao"));
				each.setId(rs.getInt("id_genero"));
				result.add(each);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean add(Genero g) {
		try {
			Statement stmt = CONN.createStatement();
			String query = String.format(INSERT_QUERY, g.getNomeGenero(),
					g.getDescricao());

			stmt.executeUpdate(query);
			stmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean edit(String nome, Genero neww){
		try{
			Statement stmt = CONN.createStatement();
			String query = String.format(UPDATE_QUERY, 
					neww.getNomeGenero(), neww.getDescricao(), nome);
					
			
			stmt.executeUpdate(query);
			stmt.close();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;		
	}
	
	public boolean delete(String name){
		try{
			Statement stmt = CONN.createStatement();
			String query = String.format(DELETE_QUERY, name);

			stmt.executeUpdate(query);
			stmt.close();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	public Genero getOne(String nome){
		Genero result = new Genero();
		try{
			Statement stmt = CONN.createStatement();
			String query = String.format(SELECT_ONE_QUERY, nome);

			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				result.setNomeGenero(rs.getString("nome_genero"));
				result.setDescricao(rs.getString("descricao"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean existeGenero(String nome){
		List<Genero> all = getAll();
		boolean result = false;
		
		
		for(Genero each : all){
			if(each.getNomeGenero().equalsIgnoreCase(nome)){
				result = true;
				break;
			}
		}
		return result;
	}
	
	public List<Genero> getSome(String nome){

		List<Genero> result = new LinkedList<Genero>();
		try {
			Statement stmt = CONN.createStatement();
			String query = String.format(SELECT_SOME_QUERY, nome.toLowerCase());
			
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Genero each = new Genero();
				each.setNomeGenero(rs.getString("nome_genero"));
				each.setDescricao(rs.getString("descricao"));
				result.add(each);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static Genero getOneById(int id){
		Genero result = new Genero();
		try{
			Statement stmt = CONN.createStatement();
			String query = String.format(SELECT_BY_ID, id);

			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				result.setNomeGenero(rs.getString("nome_genero"));
				result.setDescricao(rs.getString("descricao"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}
}
