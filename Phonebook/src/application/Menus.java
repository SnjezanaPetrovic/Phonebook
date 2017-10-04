package application;

import java.sql.SQLException;
import java.util.Scanner;

import dao.AdminDAOImplementation;
import dao.ContactDAOImplementation;
import dao.UserDAOImplementation;
import people.Admin;
import people.Contact;
import people.User;

public class Menus {

	static Scanner input = new Scanner(System.in);

	public static void mainMenu() throws SQLException {

		UserDAOImplementation userDAOImplementation = new UserDAOImplementation();

		System.out.println("******************************");
		System.out.println("--------------------\nChoose an option:\n--------------------\n1.Log in as an admin"
				+ "\n2.Log in as a user\n3.Find company number\n4.Register\n5.Leave phonebook");
		int choice = input.nextInt();
		boolean valid = true;
		while (valid) {
			try {
				switch (choice) {
				case 1:
					App.logIn();
					break;
				case 2:
					App.logIn();
					break;
				case 3:
					System.out.println("1.See all companies\n2.Find specific company");
					int option = input.nextInt();
					if (option == 1) {
						Directory.displayCompanyList();
						mainMenu();
					} else {
						System.out.println("Enter first name, last name or phone number: ");
						String keyword = input.next();
						Directory.displayCompany(keyword);
						mainMenu();
					}
					break;
				case 4:
					User user = Directory.addNewUser();
					userDAOImplementation.addUser(user);
					userMenu();
					break;
				case 5:
					System.out.println("Good buy.");
					break;
				default:
					System.out.println("Invalid input.Choose 1,2,3,4 or 5 please.");
					mainMenu();
					break;

				}
			} catch (Exception e) {

				System.err.println(e);

			}
			valid = false;
		}
	}

	public static void userMenu() throws SQLException {

		ContactDAOImplementation contactDAOImplementation = new ContactDAOImplementation();

		System.out.println("--------------------\nChoose an option:\n--------------------\n1.See all contacts"
				+ "\n2.Find contact\n3.Mark contact as invalid\n4.Log out");
		int choice = input.nextInt();
		boolean valid = true;
		while (valid) {
			try {
				switch (choice) {
				case 1:
					Directory.displayAllContacts();
					break;
				case 2:
					System.out.println("Enter first name, last name or phone number: ");
					String keyword = input.next();
					Directory.displayContact(keyword);
					break;
				case 3:
					System.out.println("Enter the name of the contact you wish to mark as invalid: ");
					String invalidContact = input.next();
					Contact contact = contactDAOImplementation.getContact(invalidContact);
					Directory.markContactAsInvalid(contact);
					break;
				case 4:
					System.out.println("You successfully loged out.Good buy.");
					break;
				default:
					System.out.println("Invalid input.Choose 1,2,3,4 or 5 please.");
					userMenu();
					break;

				}
				if (choice > 0 && choice < 4) {
					userMenu();

				} else {
					System.out.println("******************************");
				}

			} catch (Exception e) {

				System.err.println(e);

			}
			valid = false;
		}
	}

	public static void adminMenu() throws SQLException {

		UserDAOImplementation userDAOImplementation = new UserDAOImplementation();
		ContactDAOImplementation contactDAOImplementation = new ContactDAOImplementation();

		System.out.println("--------------------\nChoose an option:\n--------------------\n1.See all contacts"
				+ "\n2.Find contact\n3.Create contact\n4.Delete contact\n5.Get list of invalid numbers\n6.Add user"
				+ "\n7.Delete user.\n8.Log out");
		int choice = input.nextInt();
		boolean valid = true;
		while (valid) {
			try {
				switch (choice) {
				case 1:
					Directory.displayAllContacts();
					break;
				case 2:
					System.out.println("Enter first name, last name or phone number: ");
					String keyword = input.next();
					Directory.displayContact(keyword);
					System.out.println("Do you wish to update this number?\n1.Yes      2.No");
					int answ = input.nextInt();
					if (answ == 1) {
						System.out.println("Enter the contact ID: ");
						int contactID = input.nextInt();
						System.out.println("Enter new number (00-XX-XXXXXXXXXX): ");
						String newNum = input.next();
						Directory.updateNumber(contactID, newNum);
					} else if (answ == 2) {
						continue;
					} else {
						System.out.println("Invalid input.Choose 1 or 2 please: ");
					}
					break;
				case 3:
					Contact contact = Directory.addNewContact();
					contactDAOImplementation.addContact(contact);
					break;
				case 4:
					System.out.println("Enter the ID of the contact you wish to delete: ");
					int contactID = input.nextInt();
					contactDAOImplementation.removeContact(contactID);
					break;
				case 5:
					Directory.displayInvalidNumbers();
					break;
				case 6:
					User user = Directory.addNewUser();
					userDAOImplementation.addUser(user);
					break;
				case 7:
					System.out.println("1.Display all users\n2.Find specific one");
					int option = input.nextInt();
					if (option == 1) {
						Directory.displayAllUsers();
					} else if (option == 2) {
						System.out.println("Enter the name of the user: ");
						String userName = input.next();
						userDAOImplementation.getUser(userName);
					} else {
						System.out.println("Invalid input.Choose 1 or 2 please: ");
					}
					System.out.println("Enter the ID of the user you wish to delete: ");
					int userID = input.nextInt();
					userDAOImplementation.removeUser(userID);
					break;
				case 8:
					System.out.println("You successfully loged out.Good buy.");
					break;
				default:
					System.out.println("Invalid input.Choose 1,2,3,4,5,6,7 or 8 please.");
					adminMenu();
					break;

				}
				if (choice > 0 && choice < 8) {
					adminMenu();

				} else {
					System.out.println("******************************");
				}

			} catch (Exception e) {

				System.err.println(e);

			}
			valid = false;

		}
	}

	public static void moderatorMenu() throws SQLException {

		AdminDAOImplementation adminDAOImplementation = new AdminDAOImplementation();
		UserDAOImplementation userDAOImplementation = new UserDAOImplementation();
		ContactDAOImplementation contactDAOImplementation = new ContactDAOImplementation();

		System.out.println("--------------------\nChoose an option:\n--------------------\n1.See all contacts"
				+ "\n2.Find contact\n3.Create contact\n4.Delete contact\n5.Get list of invalid numbers\n6.Add user"
				+ "\n7.Delete user\n8.Add admin\n9.Delete admin\n10.Log out");
		int choice = input.nextInt();
		boolean valid = true;
		while (valid) {
			try {
				switch (choice) {
				case 1:
					Directory.displayAllContacts();
					break;
				case 2:
					System.out.println("Enter first name, last name or phone number: ");
					String keyword = input.next();
					Directory.displayContact(keyword);
					System.out.println("Do you wish to update this number?\n1.Yes      2.No");
					int answ = input.nextInt();
					if (answ == 1) {
						System.out.println("Enter the contact ID: ");
						int contactID = input.nextInt();
						System.out.println("Enter new number (00-XX-XXXXXXXXXX): ");
						String newNum = input.next();
						Directory.updateNumber(contactID, newNum);
					} else if (answ == 2) {
						continue;
					} else {
						System.out.println("Invalid input.Choose 1 or 2 please: ");
					}
					break;
				case 3:
					Contact contact = Directory.addNewContact();
					contactDAOImplementation.addContact(contact);
					break;
				case 4:
					System.out.println("Enter the ID of the contact you wish to delete: ");
					int contactID = input.nextInt();
					contactDAOImplementation.removeContact(contactID);
					break;
				case 5:
					Directory.displayInvalidNumbers();
					break;
				case 6:
					User user = Directory.addNewUser();
					userDAOImplementation.addUser(user);
					break;
				case 7:
					System.out.println("1.Display all users\n2.Find specific one");
					int option = input.nextInt();
					if (option == 1) {
						Directory.displayAllUsers();
					} else if (option == 2) {
						System.out.println("Enter the name of the user: ");
						String userName = input.next();
						userDAOImplementation.getUser(userName);
					} else {
						System.out.println("Invalid input.Choose 1 or 2 please: ");
					}
					System.out.println("Enter the ID of the user you wish to delete: ");
					int userID = input.nextInt();
					userDAOImplementation.removeUser(userID);
					break;
				case 8:
					Admin admin = Directory.addNewAdmin();
					adminDAOImplementation.addAdmin(admin);
					break;
				case 9:
					System.out.println("1.Display all admins\n2.Find specific one");
					int option2 = input.nextInt();
					if (option2 == 1) {
						Directory.displayAllAdmins();
					} else if (option2 == 2) {
						System.out.println("Enter the name of the admin: ");
						String adminName = input.next();
						userDAOImplementation.getUser(adminName);
					} else {
						System.out.println("Invalid input.Choose 1 or 2 please: ");
					}
					System.out.println("Enter the ID of the admin you wish to delete: ");
					int adminID = input.nextInt();
					adminDAOImplementation.removeAdmin(adminID);
					break;
				case 10:
					System.out.println("You successfully loged out.Good buy.");
					break;
				default:
					System.out.println("Invalid input.Choose 1,2,3,4,5,6,7,8,9 or 10 please.");
					moderatorMenu();
					break;

				}
				if (choice > 0 && choice < 10) {
					moderatorMenu();

				} else {
					System.out.println("******************************");
				}
			} catch (Exception e) {

				System.err.println(e);

			}
			valid = false;

		}
	}
}
