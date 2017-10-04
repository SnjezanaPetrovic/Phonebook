package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBConnection;
import people.Admin;

public class AdminDAOImplementation implements AdminDAO {

	ResultSet rs = null;
	String sql = null;
	PreparedStatement stmt;

	@Override
	public Admin getAdmin(String adminName) throws SQLException {
		Connection conn = DBConnection.getConnection();

		sql = "SELECT * FROM admin WHERE first_Name = ?";

		try {
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, adminName);
			rs = stmt.executeQuery();

			if (rs.next()) {
				return new Admin(rs.getInt("admin_ID"), rs.getString("first_Name"), rs.getNString("last_Name"),
						rs.getString("password"), rs.getString("status"));
			}

		} catch (Exception e) {
			System.err.println(e);
		}

		return null;
	}

	@Override
	public boolean addAdmin(Admin admin) throws SQLException {
		Connection conn = DBConnection.getConnection();

		sql = "INSERT INTO admin (first_name, last_name, password, status ) VALUES (?, ?, ?, ?)";

		try {

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, admin.getFirstName());
			stmt.setString(2, admin.getLastName());
			stmt.setString(3, admin.getAdminPassword());
			stmt.setString(4, admin.getStatus());

			stmt.executeUpdate();

		} catch (Exception e) {
			System.err.println(e);
		}

		return false;
	}

	@Override
	public boolean removeAdmin(int adminID) throws SQLException {
		Connection conn = DBConnection.getConnection();

		sql = "DELETE FROM admin WHERE admin_ID = ?";

		try {

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, adminID);;
			stmt.executeUpdate();
			// int done = stmt.executeUpdate();
			// if (done == 1) {
			// System.out.println("Admin deleted");
			// } else {
			// System.out.println("Admin not deleted");
			// }

		} catch (Exception e) {
			System.err.println(e);
		}

		return false;
	}

}
