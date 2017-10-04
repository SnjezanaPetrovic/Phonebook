package dao;

import java.sql.SQLException;

import people.Admin;

public interface AdminDAO {

	/**
	 * <p>
	 * This method is returning Admin object from database based on admin adminName.
	 * </p>
	 * 
	 * @param adminName
	 *            this parameter is used to create database query for selecting
	 *            admin information from database
	 * @return new Admin object from database
	 */
	public Admin getAdmin(String adminName) throws SQLException;

	/**
	 * <p>
	 * This method is used for adding new Admin object to database
	 * </p>
	 * 
	 * @param admin
	 *            object that was created by moderator
	 * @return true if new admin is added or false if it is not added to database
	 */
	public boolean addAdmin(Admin admin) throws SQLException;

	/**
	 * <p>
	 * This method is used for removing admin from database based on admin name
	 * </p>
	 * 
	 * @param adminName
	 *            this parameter is used to create database query for selecting
	 *            admin that should be deleted
	 * @return true if admin is removed or false if it is not
	 */
	public boolean removeAdmin(int adminID) throws SQLException;

}
