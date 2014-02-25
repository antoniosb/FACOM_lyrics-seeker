package br.facom.lyricsseeker.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		//Pattern pattern = Pattern.compile("(youtu\\.be\\/|youtube\\.com\\/(watch\\?(.*&)?v=|(embed|v)\\/))([^\\?&\"'>]+)");
		
		String url = "http://www.youtube.com/watch?v=3p4MZJsexEs&list=RDIHRd0R-uKHc";
		
		//Matcher m = pattern.matcher(url);
		//System.out.println(m.group(5));
		
		String pattern = "https?:\\/\\/(?:[0-9A-Z-]+\\.)?(?:youtu\\.be\\/|youtube\\.com\\S*[^\\w\\-\\s])([\\w\\-]{11})(?=[^\\w\\-]|$)(?![?=&+%\\w]*(?:['\"][^<>]*>|<\\/a>))[?=&+%\\w]*";

		Pattern compiledPattern = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
		Matcher matcher = compiledPattern.matcher(url);
		while(matcher.find()) {
		    System.out.println("oo :"+matcher.group());
		}

	}

}
// http://www.tutorialspoint.com/sqlite/sqlite_java.htm
// https://bitbucket.org/xerial/sqlite-jdbc