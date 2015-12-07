package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class ConnectDatabase {
    
	public static void main(String[] args) throws Exception {
		// set up connection
		//Class.forName("com.mysql.jdbc.Driver");

		// connect database MyLibrary with user root and its password
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/LanguageDatabase", "root", "");

		System.out.println("Connecting database successfully...");

		Scanner input = new Scanner(System.in);

		System.out.println("Choose 1 to search, 2 to add (only for admin)");

		int choose = input.nextInt();

		if (choose == 2) {
			int password = 123;
			System.out.println("Please enter admin password: ");
			int checkp = input.nextInt();
			if (checkp != password) {
				System.out.println("Invalid password, access denied");
			} else {
				System.out
						.println("Enter the new record by title, category and content:");
				System.out.println("title:");
				String input_title = input.next();
				System.out.println("category:");
				String input_category = input.next();
				System.out.println("content:");
				String input_content = input.next();

				String add_sql = "insert into library " + "values ('"
						+ input_title + "','" + input_category + "','"
						+ input_content + "')";

				Statement stmt = null;
				stmt = con.createStatement();
				stmt.executeUpdate(add_sql);
				System.out.println("Update successfully...");
			}
		}

		else {
			String search;
			System.out.println("Enter your keyword (title or category) :");
			search = input.next();

			// Use mysql query
			String search_sql = "select * from clause where title ='" + search
					+ "' or keyword ='" + search + "'";
			PreparedStatement search_statement = con
					.prepareStatement(search_sql);

			// execute mysql query
			ResultSet search_result = search_statement.executeQuery();

			// check if it is null
			if (!search_result.isBeforeFirst()) {
				System.out.println("Nothing Found! Please try again.");
			}

			// Print founding result
			while (search_result.next()) {
				System.out.println("Title: " + search_result.getString(1)
						+ " Category: " + search_result.getString(2)
						+ " Content: " + search_result.getString(3));

			}
		}

	}
}