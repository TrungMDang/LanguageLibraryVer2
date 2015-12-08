
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * @author Trung Dang, Emrullah, Scott
 *
 */
public class Library {

    /**
     * A connection with the database
     */
    private static Connection myConn;

    /**
     * Scott: original which used mySQL server Trung: modified to Derby embedded
     * server
     * 
     */
    public Library() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();

            // connect database MyLibrary with user root and its password
            myConn = DriverManager
                            .getConnection("jdbc:derby:F:/Programming/TCSS 360/LanguageLibraryTrung/LLDB");

        } catch (Exception e) {
            System.out.println("Failed to connect to database");
            e.printStackTrace();
        }
    }

    /**
     * Emrullah (original), Trung (changed parameter, added class check, and
     * casting
     * 
     * @param info
     * @return
     */
    public List<Clause> search(Object info) {
        List<Clause> clauses = null;
        if (info instanceof JTextField) {
            String clause = ((JTextField) info).getText();
            System.out.println("clause: " + clause);
            if (clause != null && clause.trim().length() > 0) {
                try {
                    clauses = searchClause(clause);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    clauses = getAllClause();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        return clauses;

    }

    /**
     * Emrullah (original), Trung (update connection reference)
     * 
     * @return
     * @throws Exception
     */
    private List<Clause> getAllClause() throws Exception {
        List<Clause> list = new ArrayList<>();

        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from clause");

            while (myRs.next()) {
                Clause tempClause = convertRowToClause(myRs);
                list.add(tempClause);
            }

            return list;
        } finally {
            close(myStmt, myRs);
        }
    }

    /**
     * @author Emrullah (search functionality, sql calls)
     * @param keyword
     * @return
     * @throws Exception
     */
    public List<Clause> searchClause(String keyword) throws Exception {
        List<Clause> list = new ArrayList<>();

        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            keyword += "%";
            myStmt = myConn.prepareStatement("select * from clause where keyword like ?");

            myStmt.setString(1, keyword);

            myRs = myStmt.executeQuery();

            while (myRs.next()) {
                Clause tempClause = convertRowToClause(myRs);
                list.add(tempClause);
                System.out.println(list.toArray().toString());
            }

            return list;
        } finally {
            close(myStmt, myRs);
        }
    }

    /**
     * Emrullah
     * 
     * @param myRs
     * @return
     * @throws SQLException
     */
    private Clause convertRowToClause(ResultSet myRs) throws SQLException {

        String title = myRs.getString("title");
        String keyword = myRs.getString("keyword");
        String description = myRs.getString("description");
        String text = myRs.getString("text");

        Clause tempClause = new Clause(title, keyword, description, text);

        return tempClause;
    }

    /**
     * Emrullah
     * 
     * @param myConn
     * @param myStmt
     * @param myRs
     * @throws SQLException
     */
    private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
                    throws SQLException {

        if (myRs != null) {
            myRs.close();
        }

        if (myStmt != null) {

        }

        if (myConn != null) {
            myConn.close();
        }
    }

    /**
     * Emrullah
     * 
     * @param myStmt
     * @param myRs
     * @throws SQLException
     */
    private void close(Statement myStmt, ResultSet myRs) throws SQLException {
        close(null, myStmt, myRs);
    }

    /**
     * Scott (original), Trung (changed database type, url, ResultSet type to
     * scrollable
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        // set up connection
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();

            // connect database MyLibrary with user root and its password
            myConn = DriverManager
                            .getConnection("jdbc:derby:F:/Programming/TCSS 360/LanguageLibraryTrung/LLDB");

        } catch (Exception e) {
            e.printStackTrace();
        }
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
                System.out.println("Enter the new record by title, category and content:");
                System.out.println("title:");
                String input_title = input.next();
                System.out.println("category:");
                String input_category = input.next();
                System.out.println("content:");
                String input_content = input.next();

                String add_sql = "insert into library " + "values ('" + input_title + "','"
                                 + input_category + "','" + input_content + "')";

                Statement stmt = myConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                        ResultSet.CONCUR_READ_ONLY);
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
            PreparedStatement search_statement = myConn
                            .prepareStatement(search_sql, ResultSet.TYPE_SCROLL_SENSITIVE,
                                              ResultSet.CONCUR_READ_ONLY);

            // execute mysql query
            ResultSet search_result = search_statement.executeQuery();

            // check if it is null
            if (!search_result.isBeforeFirst()) {
                System.out.println("Nothing Found! Please try again.");
            }

            // Print founding result
            while (search_result.next()) {
                System.out.println("Title: " + search_result.getString(1) + " Category: "
                                   + search_result.getString(2) + " Content: "
                                   + search_result.getString(3));

            }
        }

    }

    /**
     * Authors: Scott & Stacie Scott - wrote the add to sql Database code in a
     * prev. version of the code Stacie - moved it to this version of the the
     * project and modified the add code() to this fit in this version of the
     * code
     */
    public boolean create(Object theClause) {
     
        if (theClause instanceof Clause) {
            System.out.println("In here");
            Clause newClause  = (Clause) theClause;
            String add_sql = "insert into clause " + "values ('" + newClause.gettitle()
                             + "','" + newClause.getkeyword() + "','"
                             + newClause.getdescription() + "','" + newClause.gettext() + "')";

            Statement stmt = null;
            try {
                stmt = myConn.createStatement();
                stmt.executeUpdate(add_sql);
                System.out.println("Worked");
                return true;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    /**
     * Trung borrowed Emrullah codes in search, Trung modified
     * 
     * @return
     */
    public DefaultTableModel viewLibray() {
        DefaultTableModel tModel = new DefaultTableModel();
        tModel.setColumnIdentifiers(new String[] {"Title", "Keyword", "Description", "Text"});
        List<Clause> list = new ArrayList<>();
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from clause");

            while (myRs.next()) {
                Clause tempClause = convertRowToClause(myRs);
                String[] rowData = new String[4];
                rowData[0] = tempClause.gettitle();
                rowData[1] = tempClause.getkeyword();
                rowData[2] = tempClause.getdescription();
                rowData[3] = tempClause.gettext();
                tModel.addRow(rowData);
                System.out.println(tModel.getRowCount());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                close(myStmt, myRs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return tModel;
    }
}
