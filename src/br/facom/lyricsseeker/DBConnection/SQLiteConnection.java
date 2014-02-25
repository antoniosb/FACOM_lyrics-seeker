package br.facom.lyricsseeker.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteConnection {

	private SQLiteConnection() {
	}

	public static Connection getInstance() {
		Connection conn = null;
		try {
			Class.forName("org.sqlite.JDBC");
			
//		    URL location = SQLiteConnection.class.getProtectionDomain().getCodeSource().getLocation();
//	        System.out.println(location.getFile());
	        
			//conn = DriverManager.getConnection("jdbc:sqlite:./db/lyricsDB");
			conn = DriverManager.getConnection("jdbc:sqlite:Projects/lyrics-seeker/db/lyricsDB");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return conn;
	}

	private static void mountDatabase() {
		// load the sqlite-JDBC driver using the current class loader
		Connection connection = getInstance();
		try {
			// create a database connection
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.

			statement.executeUpdate("drop table if exists login");
			statement.executeUpdate("drop table if exists musico");
			statement.executeUpdate("drop table if exists letra");
			statement.executeUpdate("drop table if exists genero");
			statement.executeUpdate("drop table if exists acesso_cantor");
			statement.executeUpdate("drop table if exists acesso_letra");
			statement.executeUpdate("drop table if exists music_genero");

			statement
					.executeUpdate("CREATE TABLE login(usuario string, senha string)");

			statement
					.executeUpdate("CREATE TABLE musico ("
							+ "id_musico CHAR(20) PRIMARY KEY NOT NULL,"
							+ "nome_musico CHAR(20),"
							+ "data_nascimento CHAR(60),"
							+ "nome_genero CHAR(20),"
							+ "fotos CHAR(200),"
							+ "biografia CHAR(512),"
							+ "FOREIGN KEY (nome_genero) REFERENCES genero(nome_genero))");

			statement
					.executeUpdate("CREATE TABLE letra ("
							+ "id_letra CHAR(20) PRIMARY KEY NOT NULL,"
							+ "nome_letra CHAR(20),"
							+ "id_musico CHAR(20),"
							+ "nome_genero CHAR(20),"
							+ "url_video CHAR(50),"
							+ "data_criacao DATE,"
							+ "texto CHAR(1000),"
							+ "FOREIGN KEY (id_musico) REFERENCES musico(id_musico),"
							+ "FOREIGN KEY (nome_genero) REFERENCES genero(nome_genero))");

			statement.executeUpdate("CREATE TABLE genero ("
					+ "nome_genero CHAR(20) PRIMARY KEY NOT NULL,"
					+ "descricao CHAR(60))");

			statement.executeUpdate("CREATE TABLE acesso_cantor ("
					+ "id_musico CHAR(20)," + "numero_visitas INT,"
					+ "ultima_visita DATE,"
					+ "FOREIGN KEY (id_musico) REFERENCES letra(id_musico))");

			statement.executeUpdate("CREATE TABLE acesso_letra ("
					+ "id_letra CHAR(20)," + "numero_visitas INT,"
					+ "ultima_visita DATE,"
					+ "FOREIGN KEY (id_letra) REFERENCES letra(id_letra))");

			statement
					.executeUpdate("CREATE TABLE musico_genero("
							+ "id_musico CHAR(20),"
							+ "nome_genero CHAR(20),"
							+ "PRIMARY KEY (id_musico, nome_genero),"
							+ "FOREIGN KEY (id_musico) REFERENCES musico(id_musico),"
							+ "FOREIGN KEY (nome_genero) REFERENCES genero(nome_genero))");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
	}

}
