package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DBConnection;
import people.Admin;
import people.Contact;
import people.User;

public class Directory {

	static Scanner input = new Scanner(System.in);

	public static void displayContact(String keyword) throws SQLException {

		try (Connection conn = DBConnection.getConnection();
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery("SELECT*FROM contacts WHERE first_Name = '" + keyword
						+ "' OR last_Name ='" + keyword + "' OR phone_Number='" + keyword + "'");) {
			System.out.println(rs.getRow());

			while (rs.next()) {
				System.out.println(rs.getInt("contact_ID") + " " + rs.getString("first_Name") + " "
						+ rs.getString("last_Name") + " " + rs.getString("phone_Number") + " "
						+ rs.getString("number_Type") + " " + rs.getString("status") + " " + rs.getString("address"));
			}

		} catch (SQLException e) {
			System.err.println(e);

		}

	}

	public static void displayAllContacts() throws SQLException {

		try (Connection conn = DBConnection.getConnection();
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery("SELECT*FROM contacts ");) {

			while (rs.next()) {
				System.out.println(rs.getInt("contact_ID") + " " + rs.getString("first_Name") + " "
						+ rs.getString("last_Name") + " " + rs.getString("phone_Number") + " "
						+ rs.getString("number_Type") + " " + rs.getString("status") + " " + rs.getString("address"));
			}

		} catch (SQLException e) {
			System.err.println(e);

		}

	}

	public static boolean updateNumber(int contactID, String newNum) {

		ResultSet rs = null;

		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(
						"SELECT * FROM contacts WHERE contact_ID ='" + contactID + "'",
						ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {

			rs = stmt.executeQuery();

			if (rs.next()) {
				rs.updateInt("contact_ID", contactID);
				rs.updateString("phone_Number", newNum);
				rs.updateRow();
				return true;

			} else {
				return false;
			}

		} catch (Exception e) {
			System.err.println(e);

		}
		return false;

	}

	public static void displayCompany(String keyword) throws SQLException {

		try (Connection conn = DBConnection.getConnection();
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt
						.executeQuery("SELECT*FROM contacts WHERE first_Name = '" + keyword + "' OR last_Name ='"
								+ keyword + "' OR phone_Number='" + keyword + "' AND status='company'");) {
			System.out.println(rs.getRow());

			while (rs.next()) {
				System.out.println(rs.getString("first_Name") + " " + rs.getString("last_Name") + " "
						+ rs.getString("phone_Number") + " " + rs.getString("number_Type") + " "
						+ rs.getString("status") + " " + rs.getString("address"));
			}

		} catch (SQLException e) {
			System.err.println(e);

		}

	}

	public static void displayCompanyList() {

		try (Connection conn = DBConnection.getConnection();
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery("SELECT*FROM contacts WHERE status='company' ");) {

			while (rs.next()) {
				System.out.println(rs.getString("first_Name") + " " + rs.getString("last_Name") + " "
						+ rs.getString("phone_Number") + " " + rs.getString("number_Type") + " "
						+ rs.getString("address"));
			}

		} catch (SQLException e) {
			System.err.println(e);

		}

	}

	public static void displayAllUsers() {

		try (Connection conn = DBConnection.getConnection();
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery("SELECT*FROM users ");) {

			while (rs.next()) {
				System.out.println(
						rs.getInt("user_ID") + " " + rs.getString("first_Name") + " " + rs.getString("last_Name"));
			}

		} catch (SQLException e) {
			System.err.println(e);

		}

	}

	public static void displayAllAdmins() {

		try (Connection conn = DBConnection.getConnection();
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery("SELECT*FROM admin ");) {

			while (rs.next()) {
				System.out.println(rs.getInt("admin_ID") + " " + rs.getString("first_Name") + " "
						+ rs.getString("last_Name") + " " + rs.getString("status"));
			}

		} catch (SQLException e) {
			System.err.println(e);

		}

	}

	public static void displayInvalidNumbers() {

		try (Connection conn = DBConnection.getConnection();
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery("SELECT*FROM contacts WHERE comment='invalid' ");) {

			while (rs.next()) {
				System.out.println(rs.getInt("contact_ID") + " " + rs.getString("first_Name") + " "
						+ rs.getString("last_Name") + " " + rs.getString("phone_Number") + " "
						+ rs.getString("number_Type") + " " + rs.getString("address"));
			}

		} catch (SQLException e) {
			System.err.println(e);

		}

	}

	public static boolean markContactAsInvalid(Contact contact) {

		ResultSet rs = null;

		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM contacts WHERE contact_ID =?",
						ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {

			stmt.setString(1, contact.getFirstName());
			rs = stmt.executeQuery();

			if (rs.next()) {
				rs.updateInt("contact_ID", contact.getContactID());
				rs.updateString("comment", "invalid");
				rs.updateRow();
				return true;

			} else {
				return false;
			}

		} catch (Exception e) {
			System.err.println(e);

		}
		return false;

	}

	public static String getAdminType(String userName, String password) throws SQLException {

		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT status FROM admin WHERE BINARY first_Name = '"
						+ userName + "' AND BINARY password = '" + password + "'");) {

			ResultSet rs = stmt.executeQuery();

			return rs.getString("status");

		} catch (Exception e) {

			return e.getMessage();
		}

	}

	public static User addNewUser() {
		User user = new User();
		try {

			System.out.println("Enter data for new user.\nFirst name: ");
			user.setFirstName(input.next());
			System.out.println("Last name: ");
			user.setLastName(input.next());
			System.out.println("Password: ");
			user.setPassword(input.next());

		} catch (Exception e) {
			System.err.println(e);
		}
		return user;

	}

	public static Admin addNewAdmin() {
		Admin admin = new Admin();

		try {

			System.out.println("Enter data for new admin.\nFirst name: ");
			admin.setFirstName(input.next());
			System.out.println("Last name: ");
			admin.setLastName(input.next());
			System.out.println("Password: ");
			admin.setAdminPassword(input.next());
			admin.setStatus("admin");

		} catch (Exception e) {
			System.err.println(e);
		}
		return admin;
	}

	public static Contact addNewContact() {
		Contact contact = new Contact();

		try {

			System.out.println("Enter data for new contact.\nFirst name: ");
			contact.setFirstName(input.next());
			System.out.println("Last name: ");
			contact.setLastName(input.next());
			System.out.println("Phone number: ");
			contact.setPhoneNumber(input.next());
			System.out.println("Number type (mob or home): ");
			contact.setNumberType(input.next());
			System.out.println("Status (personal or company): ");
			contact.setStatus(input.next());
			System.out.println("Address: ");
			contact.setAddress(input.next());
			contact.setComment("valid");

		} catch (Exception e) {
			System.err.println(e);
		}
		return contact;
	}

}
