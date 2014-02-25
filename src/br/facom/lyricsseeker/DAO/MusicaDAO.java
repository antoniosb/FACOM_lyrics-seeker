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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.facom.lyricsseeker.DBConnection.SQLiteConnection;
import br.facom.lyricsseeker.models.Musica;

public class MusicaDAO {
	private static final Connection CONN = SQLiteConnection.getInstance();
	private static final String SELECT_ALL_QUERY = "SELECT * FROM MUSICA";
	private static final String INSERT_QUERY = "INSERT INTO MUSICA "
			+ "VALUES(null, '%s' ,'%d', %d, '%s', '%s', '%s' );";
	private static final String UPDATE_QUERY = "UPDATE MUSICA SET nome_musica = '%s' , "
			+ "id_artista=%d, id_genero= %d, url_video= '%s', data_criacao= '%s', letra= '%s'"
			+ "WHERE id_musica=%d ;";
	private static final String DELETE_QUERY = "DELETE FROM MUSICA WHERE id_musica =%d ;";
	private static final String SELECT_ONE_QUERY = "SELECT * FROM MUSICA WHERE id_musica= %d LIMIT 1";
	private static final String SELECT_NAME_QUERY = "SELECT * FROM MUSICA WHERE lower(nome_musica) like '%%%s%%';";

	public static final DateFormat PATTERN = new SimpleDateFormat(
			"YYYY-MM-DD HH:MM:SS.SSS");

	public List<Musica> getAll() {
		List<Musica> result = new LinkedList<Musica>();
		try {
			Statement stmt = CONN.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_QUERY);
			while (rs.next()) {
				Musica each = new Musica();

				each.setIdMusica(rs.getInt("id_musica"));
				each.setNomeMusica(rs.getString("nome_musica"));
				each.setIdArtista(rs.getInt("id_artista"));
				each.setIdGenero(rs.getInt("id_genero"));
				each.setUrlVideo(rs.getString("url_video"));
				each.setLetra(rs.getString("letra"));

				try {
					each.setDataCriacao(PATTERN.parse(rs
							.getString("data_criacao")));
				} catch (ParseException e) {
					each.setDataCriacao(new Date());
				}
				result.add(each);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean add(Musica m) {
		try {
			Statement stmt = CONN.createStatement();
			String dataCriacao = PATTERN.format(m.getDataCriacao());
			String query = String.format(INSERT_QUERY, m.getNomeMusica(),
					m.getIdArtista(), m.getIdGenero(), m.getUrlVideo(),
					dataCriacao, m.getLetra());

			stmt.executeUpdate(query);
			stmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean edit(int id, Musica m) {
		try {
			Statement stmt = CONN.createStatement();
			String dataCriacao = PATTERN.format(m.getDataCriacao());
			String query = String.format(UPDATE_QUERY, m.getNomeMusica(),
					m.getIdArtista(), m.getIdGenero(), m.getUrlVideo(),
					dataCriacao, m.getLetra(), m.getIdMusica());

			stmt.executeUpdate(query);
			stmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(int id) {
		try {
			Statement stmt = CONN.createStatement();
			String query = String.format(DELETE_QUERY, id);

			stmt.executeUpdate(query);
			stmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Musica getOne(int id) {
		Musica result = null;
		try {
			Statement stmt = CONN.createStatement();
			String query = String.format(SELECT_ONE_QUERY, id);

			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				result = new Musica();

				result.setIdMusica(rs.getInt("id_musica"));
				result.setNomeMusica(rs.getString("nome_musica"));
				result.setIdArtista(rs.getInt("id_artista"));
				result.setIdGenero(rs.getInt("id_genero"));
				result.setUrlVideo(rs.getString("url_video"));
				result.setLetra(rs.getString("letra"));

				try {
					result.setDataCriacao(PATTERN.parse(rs
							.getString("data_criacao")));
				} catch (ParseException e) {
					result.setDataCriacao(new Date());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean existeMusica(int id) {
		Musica a = getOne(id);
		if (a != null) {
			return true;
		} else {
			return false;
		}
	}

	public List<Musica> getSome(String nome) {
		List<Musica> result = new LinkedList<Musica>();
		try {
			Statement stmt = CONN.createStatement();
			String query = String.format(SELECT_NAME_QUERY, nome.toLowerCase());

			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Musica each = new Musica();

				each.setIdMusica(rs.getInt("id_musica"));
				each.setNomeMusica(rs.getString("nome_musica"));
				each.setIdArtista(rs.getInt("id_artista"));
				each.setIdGenero(rs.getInt("id_genero"));
				each.setUrlVideo(rs.getString("url_video"));
				each.setLetra(rs.getString("letra"));

				try {
					each.setDataCriacao(PATTERN.parse(rs
							.getString("data_criacao")));
				} catch (ParseException e) {
					each.setDataCriacao(new Date());
				}
				result.add(each);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String getYoutubeVideoId(String youtubeUrl) {
		String video_id = "";
		if (youtubeUrl != null && youtubeUrl.trim().length() > 0
				&& youtubeUrl.startsWith("http")) {

			String expression = "^.*((youtu.be"
					+ "\\/)"
					+ "|(v\\/)|(\\/u\\/w\\/)|(embed\\/)|(watch\\?))\\??v?=?([^#\\&\\?]*).*"; 
			// var regExp= /^.*((youtu.be\/)|(v\/)|(\/u\/\w\/)|(embed\/)|(watch\?))\??v?=?([^#\&\?]*).*/;
			CharSequence input = youtubeUrl;
			Pattern pattern = Pattern.compile(expression,
					Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(input);
			if (matcher.matches()) {
				String groupIndex1 = matcher.group(7);
				if (groupIndex1 != null && groupIndex1.length() == 11)
					video_id = groupIndex1;
			}
		}
		return video_id;
	}
}
