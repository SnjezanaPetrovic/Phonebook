package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBConnection;
import people.Contact;

public class ContactDAOImplementation implements ContactDAO {

	ResultSet rs = null;
	String sql = null;
	PreparedStatement stmt;

	@Override
	public Contact getContact(String contactName) throws SQLException {

		Connection conn = DBConnection.getConnection();

		sql = "SELECT * FROM contacts WHERE first_Name = ?";

		try {
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, contactName);
			rs = stmt.executeQuery();

			if (rs.next()) {
				return new Contact(rs.getInt("contact_ID"), rs.getString("first_Name"), rs.getNString("last_Name"),
						rs.getString("phone_Number"), rs.getString("number_Type"), rs.getString("status"),
						rs.getString("address"), rs.getString("comment"));
			}

		} catch (Exception e) {
			System.err.println(e);
		}

		return null;
	}

	@Override
	public boolean addContact(Contact contact) throws SQLException {

		Connection conn = DBConnection.getConnection();
		sql = "INSERT INTO contacts (first_name, last_name, phone_Number,number_Type,status,address,comment ) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, contact.getFirstName());
			stmt.setString(2, contact.getLastName());
			stmt.setString(3, contact.getPhoneNumber());
			stmt.setString(4, contact.getNumberType());
			stmt.setString(5, contact.getStatus());
			stmt.setString(6, contact.getAddress());
			stmt.setString(7, contact.getComment());

			stmt.executeUpdate();

		} catch (Exception e) {
			System.err.println(e);
		}

		return false;
	}

	@Override
	public boolean removeContact(int contactID) throws SQLException {

		Connection conn = DBConnection.getConnection();

		sql = "DELETE FROM contacts WHERE contact_ID = ?";

		try {

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, contactID);
			stmt.executeUpdate();

		} catch (Exception e) {
			System.err.println(e);
		}

		return false;
	}

}
