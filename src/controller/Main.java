package controller;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gui.MenuFrame;
import gui.ViewLibrary;
import model.Clause;
import model.Library;

/**
 * Launch Application.
 * @author Emrullah Celik
 * @version 11/26/15
 *
 */
public class Main {

    //private Connection myConn;

//    public Main() throws Exception {
//
//        myConn = DriverManager.getConnection(
//       "jdbc:mysql://localhost/LanguageDatabase", "root", "");
//    }

//    public List<Clause> getAllClause() throws Exception {
//        List<Clause> list = new ArrayList<>();
//
//        Statement myStmt = null;
//        ResultSet myRs = null;
//
//        try {
//            myStmt = myConn.createStatement();
//            myRs = myStmt.executeQuery("select * from clause");
//
//            while (myRs.next()) {
//                Clause tempClause = convertRowToClause(myRs);
//                list.add(tempClause);
//            }
//
//            return list;        
//        }
//        finally {
//            close(myStmt, myRs);
//        }
//    }
//
//    public List<Clause> searchClause(String keyword) throws Exception {
//        List<Clause> list = new ArrayList<>();
//
//        PreparedStatement myStmt = null;
//        ResultSet myRs = null;
//
//        try {
//            keyword += "%";
//            myStmt = myConn.prepareStatement("select * from clause where keyword like ?");
//
//            myStmt.setString(1, keyword);
//
//            myRs = myStmt.executeQuery();
//
//            while (myRs.next()) {
//                Clause tempClause = convertRowToClause(myRs);
//                list.add(tempClause);
//            }
//
//            return list;
//        }
//        finally {
//            close(myStmt, myRs);
//        }
//    }

//    private Clause convertRowToClause(ResultSet myRs) throws SQLException {
//
//
//        String title = myRs.getString("title");
//        String keyword = myRs.getString("keyword");
//        String description = myRs.getString("description");
//        String text = myRs.getString("text");
//
//
//        Clause tempClause = new Clause(title, keyword, description, text);
//
//        return tempClause;
//    }
//
//
//    private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
//                    throws SQLException {
//
//        if (myRs != null) {
//            myRs.close();
//        }
//
//        if (myStmt != null) {
//
//        }
//
//        if (myConn != null) {
//            myConn.close();
//        }
//    }
//
//    private void close(Statement myStmt, ResultSet myRs) throws SQLException {
//        close(null, myStmt, myRs);      
//    }


    /**
     * Launch the application.
     * @param theArgs run frame.
     * @throws Throwable 
     */
    public static void main(final String[] theArgs) throws Throwable {
//        Main dao = new Main();
//        // System.out.println(dao.searchClause("keyword2")); 
//        System.out.println(dao.getAllClause());

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    final MenuFrame gui = new MenuFrame();
                    gui.setBackground(new Color(204, 204, 255));
                    
                    Menu menu = new Menu(gui.getSearchPanel(),gui.getCreatePanel());
                   
                    gui.getSearchPanel().addPropertyChangeListener(menu);
                    gui.getCreatePanel().addPropertyChangeListener(menu);
                    
                    
                    gui.start();
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
