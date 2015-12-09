
package gui;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.Menu;

import javax.swing.JScrollPane;

/**
 * View Library.
 * 
 * @author Emrullah Celik, Trung Dang
 * @version 11/27/15
 *
 */

@SuppressWarnings("serial")
public class ViewLibrary extends JFrame implements Observer {

//    public JFrame getFrame() {
//        return myFrame;
//    }

   // private static JFrame myFrame;

    private static JPanel contentPane;

    private static JTable table;

    private static JScrollPane myScrollPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    ViewLibrary frame = new ViewLibrary();
                    //frame.addPropertyChangeListener(M);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     * 
     * Emrullah (original), Trung (changed look and feel, added 2 buttons, and functionality)
     */
    public ViewLibrary() {
        table = new JTable();
        this.setTitle("View Library");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        setBackground(new Color(204, 204, 255));
        setBounds(100, 100, 550, 600);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(232, 239, 233));
        contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
                                              null, null));

        contentPane.setLayout(null);

        JLabel lblViewLibrary = new JLabel("View Library");
        lblViewLibrary.setForeground(Color.RED);
        lblViewLibrary.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC,
                                        40));
        lblViewLibrary.setBackground(new Color(204, 204, 255));
        lblViewLibrary.setBounds(160, 20, 265, 57);
        contentPane.add(lblViewLibrary);
        myScrollPane = new JScrollPane();

        myScrollPane.setBounds(12, 100, 510, 400);
        contentPane.add(myScrollPane);
       
        table.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        

        setContentPane(contentPane);
        
        
        JButton keywordButton = new JButton("View By Keyword");
        keywordButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        keywordButton.setBackground(new Color(242,247,242));
        keywordButton.setBorder(BorderFactory.createRaisedBevelBorder());
        keywordButton.setBounds(40, 510, 200, 30);
        keywordButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                firePropertyChange("key", this, "key");
                
                System.err.println("button pressed key");
            }
        });
        JButton titleButton = new JButton("View By Title");
        titleButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        titleButton.setBackground(new Color(242,247,242));
        titleButton.setBorder(BorderFactory.createRaisedBevelBorder());
        titleButton.setBounds(290, 510, 200, 30);

        titleButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                firePropertyChange("title", this, "title");
                System.err.println("button pressed title");

            }
        });
        add(keywordButton);
        add(titleButton);
        
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Menu && arg instanceof TableModel) {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("inside update view");
                        table.setModel((DefaultTableModel) arg);
                       
                        table.getColumnModel().getColumn(0).setPreferredWidth(150);
                        table.getColumnModel().getColumn(1).setPreferredWidth(90);
                        table.getColumnModel().getColumn(2).setPreferredWidth(200);
                        table.getColumnModel().getColumn(3).setPreferredWidth(300);
                        table.validate();
                        myScrollPane.setViewportView(table);
                        setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
           
           
           // myFrame.setVisible(true);
            
            // {
            // @SuppressWarnings("rawtypes")
            // Class[] columnTypes = new Class[] {
            // String.class, String.class, String.class, String.class
            // };
            // @Override
            // @SuppressWarnings({"unchecked", "rawtypes"})
            // public Class getColumnClass(int columnIndex) {
            // return columnTypes[columnIndex];
            // }
            // });
        }

    }

}
