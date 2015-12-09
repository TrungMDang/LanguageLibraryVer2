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
                    ViewLibrary frame = new ViewLibrary();
                    
                    Menu menu = new Menu(gui.getSearchPanel(),gui.getCreatePanel(), frame);
                    
                    gui.getSearchPanel().addPropertyChangeListener(menu);
                    gui.getCreatePanel().addPropertyChangeListener(menu);
                    //gui.getViewLibraryPanel().addPropertyChangeListener(menu);
                    
                    
                    gui.start();
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
