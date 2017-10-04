package application;


import java.sql.SQLException;



public class Main {

	public static void main(String[] args) throws SQLException {

		try {

			System.out.println("***  *  *  ***  *   * **** ***   ***   ***  *  *");
			System.out.println("*  * *  * *   * **  * *    *  * *   * *   * * *");
			System.out.println("***  **** *   * * * * **** ***  *   * *   * **");
			System.out.println("*    *  * *   * *  ** *    *  * *   * *   * * *");
			System.out.println("*    *  *  ***  *   * **** ***   ***   ***  *  *");

			
			
			
			App.startApp();

		} catch (Exception e) {
			System.err.println(e);
		}

	}

}
