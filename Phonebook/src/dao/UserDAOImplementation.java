package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBConnection;
import people.User;

public class UserDAOImplementation implements UserDAO {

	ResultSet rs = null;
	String sql = null;
	PreparedStatement stmt;

	@Override
	public User getUser(String userName) throws SQLException {

		Connection conn = DBConnection.getConnection();

		sql = "SELECT * FROM users WHERE first_Name = ?";

		try {
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, userName);
			rs = stmt.executeQuery();

			if (rs.next()) {
				return new User(rs.getInt("user_ID"), rs.getString("first_Name"), rs.getNString("last_Name"),
						rs.getString("password"));
			}

		} catch (Exception e) {
			System.err.println(e);
		}

		return null;

	}

	@Override
	public boolean addUser(User user) throws SQLException {

		Connection conn = DBConnection.getConnection();

		sql = "INSERT INTO users (first_name, last_name, password ) VALUES (?, ?, ?)";

		try {

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getPassword());

			stmt.executeUpdate();

		} catch (Exception e) {
			System.err.println(e);
		}

		return false;
	}

	@Override
	public boolean removeUser(int userID) throws SQLException {
		Connection conn = DBConnection.getConnection();

		sql = "DELETE FROM users WHERE user_ID = ?";

		try {

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, userID);
			stmt.executeUpdate();

		} catch (Exception e) {
			System.err.println(e);
		}

		return false;
	}

}
