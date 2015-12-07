package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Library {
    
    private Connection myCon;

    public Library() {

        try {  
            // connect database MyLibrary with user root and its password
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/LanguageDatabase", "root", "");
        } catch (SQLException e) {
            System.out.println("Error 1: Database not found.");
            e.printStackTrace();
        }
    }

    private void create() {

    }

    private void search() {


    }

    private void viewLibrary() {

    }
}
