package br.facom.lyricsseeker.models;

import java.sql.Connection;
import java.sql.DriverManager;

public class Model {
	public int square(int x) {
		return x * x;
	}

	public int factorial(int x) {
		if (x < 0)
			return 0;
		int fact = 1;
		for (int i = 1; i <= x; i++)
			fact *= i;
		return fact;
	}

	public static void main(String args[]) {
		Connection c = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:./db/lyricsDB.db");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Opened database successfully");
	}

}
// http://www.tutorialspoint.com/sqlite/sqlite_java.htm
// https://bitbucket.org/xerial/sqlite-jdbc