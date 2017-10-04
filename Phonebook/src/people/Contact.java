package people;

public class Contact {

	private int contactID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String numberType;
	private String status;
	private String address;
	private String comment;

	public Contact() {

	}

	public Contact(int contactID, String firstName, String lastName, String phoneNumber, String numberType,
			String status, String address, String comment) {
		super();
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.numberType = numberType;
		this.status = status;
		this.address = address;
		this.comment = comment;
	}

	public int getContactID() {
		return contactID;
	}

	public void setContactID(int contactID) {
		this.contactID = contactID;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getNumberType() {
		return numberType;
	}

	public void setNumberType(String numberType) {
		this.numberType = numberType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Contact [contactID=" + contactID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNumber=" + phoneNumber + ", numberType=" + numberType + ", status=" + status + ", address="
				+ address + ", comment=" + comment + "]";
	}

}
