package dao;

import java.sql.SQLException;

import people.User;


public interface UserDAO {
	
    
	/**
	 * <p>
	 * This method is returning User object from database based on user userName.
	 * </p>
	 * 
	 * @param userName
	 *            this parameter is used to create database query for selecting
	 *            user information from database
	 * @return new User object from database
	 * @throws SQLException 
	 */
	public User getUser(String userName) throws SQLException;

	/**
	 * <p>
	 * This method is used for adding new User object to database
	 * </p>
	 * 
	 * @param user
	 *            object that was created by moderator or admin
	 * @return true if new user is added or false if it is not added to
	 *         database
	 * @throws SQLException 
	 */
	public boolean addUser(User user) throws SQLException;

	/**
	 * <p>
	 * This method is used for removing user from database based on user userName
	 * </p>
	 * 
	 * @param userName
	 *            this parameter is used to create database query for selecting
	 *            user that should be deleted
	 * @return true if user is removed or false if it is not
	 * @throws SQLException 
	 */
	public boolean removeUser(int userID) throws SQLException;

}
