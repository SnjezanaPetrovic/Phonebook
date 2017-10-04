package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBConnection;

public class Validations {

	public static boolean isValidUser(String userName, String password) throws SQLException {

		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT*FROM users WHERE BINARY first_Name = '" + userName
					+ "' AND BINARY password = '" + password + "'");
			ResultSet result = stmt.executeQuery();

			if (!result.isBeforeFirst()) {
				return false;
			}
			return true;

		} catch (Exception e) {

			System.err.println(e);
			return false;
		}

	}

	public static boolean isValidAdmin(String userName, String password) throws SQLException {

		try {

			Connection conn = DBConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT*FROM admin WHERE BINARY first_Name = '" + userName
					+ "' AND BINARY password = '" + password + "'");
			ResultSet result = stmt.executeQuery();

			if (!result.isBeforeFirst()) {
				return false;
			}

			return true;

		} catch (Exception e) {

			System.err.println(e);
			return false;
		}

	}

}
