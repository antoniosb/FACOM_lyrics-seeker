package br.facom.lyricsseeker.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import br.facom.lyricsseeker.DBConnection.SQLiteConnection;
import br.facom.lyricsseeker.models.Artista;

public class ArtistaDAO {
	private static final Connection CONN = SQLiteConnection.getInstance();
	private static final String SELECT_ALL_QUERY = "SELECT * FROM ARTISTA";
	private static final String INSERT_QUERY = "INSERT INTO ARTISTA " +
			"VALUES(null, '%s' ,'%s', %d, '%s', '%s' );";
	private static final String UPDATE_QUERY = "UPDATE ARTISTA SET nome_artista = '%s' , " +
			"data_nascimento= '%s', id_genero= %d, url_foto = '%s', biografia= '%s'" +
			"WHERE id_artista=%d ;";
	private static final String DELETE_QUERY = "DELETE FROM ARTISTA WHERE id_artista =%d ;";
	private static final String SELECT_ONE_QUERY = "SELECT * FROM ARTISTA WHERE id_artista= %d LIMIT 1";
	private static final String SELECT_NAME_QUERY = "SELECT * FROM ARTISTA WHERE lower(nome_artista) like '%%%s%%';";
	
	public static final DateFormat PATTERN = new SimpleDateFormat("YYYY-MM-DD HH:MM:SS.SSS");
	

	public List<Artista> getAll() {
		List<Artista> result = new LinkedList<Artista>();
		try {
			Statement stmt = CONN.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_QUERY);
			while (rs.next()) {
				Artista each = new Artista();
				
				each.setIdArtista(rs.getInt("id_artista"));
				each.setNomeArtista(rs.getString("nome_artista"));
				each.setIdGenero(rs.getInt("id_genero"));
				each.setUrlFoto(rs.getString("url_foto"));
				each.setBiografia(rs.getString("biografia"));
				try{
					each.setDataNascimento(PATTERN.parse(rs.getString("data_nascimento")));
				}catch(ParseException e){
					each.setDataNascimento(new Date());
				}
				result.add(each);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean add(Artista a) {
		try {
			Statement stmt = CONN.createStatement();
			String dataNascimento = PATTERN.format(a.getDataNascimento());
			String query = String.format(INSERT_QUERY, a.getNomeArtista(),
					dataNascimento, a.getIdGenero(), a.getUrlFoto(), a.getBiografia());

			stmt.executeUpdate(query);
			stmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean edit(int id, Artista a){
		try{
			Statement stmt = CONN.createStatement();
			String dataNascimento = PATTERN.format(a.getDataNascimento());
			String query = String.format(UPDATE_QUERY, a.getNomeArtista(),
					dataNascimento, a.getIdGenero(), a.getUrlFoto(), 
					a.getBiografia(), a.getIdArtista());
			
			stmt.executeUpdate(query);
			stmt.close();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;		
	}
	
	public boolean delete(int id){
		try{
			Statement stmt = CONN.createStatement();
			String query = String.format(DELETE_QUERY, id);

			stmt.executeUpdate(query);
			stmt.close();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	public Artista getOne(int id){
		Artista result = null;
		try{
			Statement stmt = CONN.createStatement();
			String query = String.format(SELECT_ONE_QUERY, id);

			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				result = new Artista();
				result.setIdArtista(rs.getInt("id_artista"));
				result.setNomeArtista(rs.getString("nome_artista"));
				result.setIdGenero(rs.getInt("id_genero"));
				result.setUrlFoto(rs.getString("url_foto"));
				result.setBiografia(rs.getString("biografia"));
				try{
					result.setDataNascimento(PATTERN.parse(rs.getString("data_nascimento")));
				}catch(ParseException e){
					result.setDataNascimento(new Date());
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean existeArtista(int id){
		Artista a = getOne(id);
		if(a != null){
			return true;
		}else{
			return false;
		}
	}
	
	public List<Artista> getSome(String nome){
		List<Artista> result = new LinkedList<Artista>();
		try {
			Statement stmt = CONN.createStatement();
			String query = String.format(SELECT_NAME_QUERY, nome.toLowerCase());
			
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Artista each = new Artista();
				
				each.setIdArtista(rs.getInt("id_artista"));
				each.setNomeArtista(rs.getString("nome_artista"));
				each.setIdGenero(rs.getInt("id_genero"));
				each.setUrlFoto(rs.getString("url_foto"));
				each.setBiografia(rs.getString("biografia"));
				try{
					each.setDataNascimento(PATTERN.parse(rs.getString("data_nascimento")));
				}catch(ParseException e){
					each.setDataNascimento(new Date());
				}
				result.add(each);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
