package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import controller.Menu;

import javax.swing.JScrollPane;

/**
 * View Library.
 * @author Emrullah Celik, Trung Dang
 * @version 11/27/15
 *
 */

@SuppressWarnings("serial")
public class ViewLibrary implements Observer{
    
    public static JFrame getFrame() {
        return myFrame;
    }

    private static JFrame myFrame;

    private JPanel contentPane;
    
    private static JTable table;
    
    private JScrollPane myScrollPane;
   

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    myFrame.setVisible(true);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ViewLibrary() {
        myFrame = new JFrame("View Library");
        myFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        myFrame.setBackground(new Color(204, 204, 255));
        myFrame.setBounds(100, 100, 550, 600);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(232,239,233));
        contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        myFrame.setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblViewLibrary = new JLabel("View Library");
        lblViewLibrary.setForeground(Color.RED);
        lblViewLibrary.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 40));
        lblViewLibrary.setBackground(new Color(204, 204, 255));
        lblViewLibrary.setBounds(165, 20, 265, 57);
        contentPane.add(lblViewLibrary);
        myScrollPane = new JScrollPane();
        
        myScrollPane.setBounds(15, 100, 510, 400);
        contentPane.add(myScrollPane);
        table = new JTable();
        table.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        myScrollPane.setViewportView(table);
        myFrame.setVisible(true);
       
        
        //        table.setModel(new DefaultTableModel(
        //            new Object[][] {
        //                {null, null, null, null},
        //                {null, null, null, null},
        //                {null, null, null, null},
        //                {null, null, null, null},
        //                {null, null, null, null},
        //                {null, null, null, null},
        //                {null, null, null, null},
        //                {null, null, null, null},
        //                {null, null, null, null},
        //                {null, null, null, null},
        //                {null, null, null, null},
        //                {null, null, null, null},
        //                {null, null, null, null},
        //                {null, null, null, null},
        //                {null, null, null, null},
        //                {null, null, null, null},
        //                {null, null, null, null},
        //                {null, null, null, null},
        //                {null, null, null, null},
        //                {null, null, null, null},
        //                {null, null, null, null},
        //                {null, null, null, null},
        //                {null, null, null, null},
        //                {null, null, null, null},
        //                {null, null, null, null},
        //                {null, null, null, null},
        //                {null, null, null, null},
        //                {null, null, null, null},
        //                {null, null, null, null},
        //                {null, null, null, null},
        //            },
        //            new String[] {
        //                "Title", "Keyword", "Description", "Text"
        //            }
        //        ) {
        //            @SuppressWarnings("rawtypes")
        //            Class[] columnTypes = new Class[] {
        //                String.class, String.class, String.class, String.class
        //            };
        //            @Override
        //            @SuppressWarnings({"unchecked", "rawtypes"})
        //            public Class getColumnClass(int columnIndex) {
        //                return columnTypes[columnIndex];
        //            }
        //        });


        //        label = new JLabel("Title");
        //        label.setForeground(new Color(128, 0, 128));
        //        label.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        //        label.setBackground(new Color(204, 204, 255));
        //        label.setBounds(44, 123, 68, 27);
        //        contentPane.add(label);
        //        
        //        label_1 = new JLabel("Keyword");
        //        label_1.setForeground(new Color(128, 0, 128));
        //        label_1.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        //        label_1.setBackground(new Color(204, 204, 255));
        //        label_1.setBounds(122, 123, 100, 27);
        //        contentPane.add(label_1);
        //        
        //        label_2 = new JLabel("Description");
        //        label_2.setForeground(new Color(128, 0, 128));
        //        label_2.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        //        label_2.setBackground(new Color(204, 204, 255));
        //        label_2.setBounds(232, 123, 150, 27);
        //        contentPane.add(label_2);
        //        
        //        label_3 = new JLabel("Text");
        //        label_3.setForeground(new Color(128, 0, 128));
        //        label_3.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        //        label_3.setBackground(new Color(204, 204, 255));
        //        label_3.setBounds(392, 123, 98, 27);
        //        contentPane.add(label_3);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Menu && arg instanceof DefaultTableModel) {
            table.setModel((DefaultTableModel) arg);
            table.getColumnModel().getColumn(0).setPreferredWidth(150);
            table.getColumnModel().getColumn(1).setPreferredWidth(90);
            table.getColumnModel().getColumn(2).setPreferredWidth(200);
            table.getColumnModel().getColumn(3).setPreferredWidth(300);
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        myFrame.setVisible(true);
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
//                             {
//                @SuppressWarnings("rawtypes")
//                Class[] columnTypes = new Class[] {
//                                String.class, String.class, String.class, String.class
//                };
//                @Override
//                @SuppressWarnings({"unchecked", "rawtypes"})
//                public Class getColumnClass(int columnIndex) {
//                    return columnTypes[columnIndex];
//                }
//            });
        }

    }

}
