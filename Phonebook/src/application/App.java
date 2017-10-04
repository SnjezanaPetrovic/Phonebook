package application;


import java.sql.SQLException;
import java.util.Scanner;

import dao.AdminDAOImplementation;
import people.Admin;

public class App {

	static Scanner input = new Scanner(System.in);

	public static void startApp() throws SQLException {
		
		System.out.println("---------Welcome------------");

		Menus.mainMenu();
	}

	public static void logIn() throws SQLException {

		AdminDAOImplementation adminDAOImplementation = new AdminDAOImplementation();

		try {

			boolean log = true;
			while (log) {

				System.out.println("Enter your  name: ");
				String userName = input.nextLine();
				System.out.println("Enter your password: ");
				String password = input.nextLine();

				if (Validations.isValidAdmin(userName, password)) {
					log = false;

					Admin admin = adminDAOImplementation.getAdmin(userName);

					if (admin.getStatus().equals("mod")) {
						Menus.moderatorMenu();
					} else {
						Menus.adminMenu();
					}

				} else if (Validations.isValidUser(userName, password)) {
					log = false;
					Menus.userMenu();
				} else {
					System.out.println("Name or password are not valid.Press enter to try again. ");
					input.nextLine();
				}

			}

		} catch (Exception e) {

			System.err.println(e);
			input.nextLine();

		}
	}

}
