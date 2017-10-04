package people;

public class User {

	private int userID;
	private String firstName;
	private String lastName;
	private String password;

	public User() {

	}

	public User(int userID, String firstName, String lastName, String password) {
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;

	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + "]";
	}

}
