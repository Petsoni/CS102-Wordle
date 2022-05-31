package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static final String URL = "jdbc:mysql://localhost:3306/wordle";
	private static final String username = "root";
	private static final String password = "";

	private static Connection connection;

	/***
	 * Method that opens the connection to the database
	 * @return connection
	 */
	public static Connection openConnection() {

		try {
			connection = DriverManager.getConnection(URL, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}
}
