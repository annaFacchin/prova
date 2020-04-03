package it.objectmethod.world.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private static final String URL = "jdbc:mysql://localhost:3306/world?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASS = "ciao1234";

	public static Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

}
