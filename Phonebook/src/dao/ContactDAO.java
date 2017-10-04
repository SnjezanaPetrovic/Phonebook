package dao;

import java.sql.SQLException;

import people.Contact;

public interface ContactDAO {

	/**
	 * <p>
	 * This method is returning Contact object from database based on user
	 * contactName.
	 * </p>
	 * 
	 * @param contactName
	 *            this parameter is used to create database query for selecting
	 *            contact information from database
	 * @return new Contact object from database
	 * @throws SQLException
	 */
	public Contact getContact(String contactName) throws SQLException;

	/**
	 * <p>
	 * This method is used for adding new Contact object to database
	 * </p>
	 * 
	 * @param contact
	 *            object that was created by moderator or admin
	 * @return true if new contact is added or false if it is not added to database
	 * @throws SQLException
	 */
	public boolean addContact(Contact contact) throws SQLException;

	/**
	 * <p>
	 * This method is used for removing contact from database based on contact
	 * contactName
	 * </p>
	 * 
	 * @param contactName
	 *            this parameter is used to create database query for selecting
	 *            contact that should be deleted
	 * @return true if contact is removed or false if it is not
	 * @throws SQLException
	 */
	public boolean removeContact(int contactID) throws SQLException;

}
