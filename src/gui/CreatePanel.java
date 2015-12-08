package gui;

import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Menu;
import model.Clause;

/**
 * @author Emrullah, Trung (modified some codes)
 *
 */
@SuppressWarnings("serial")
public class CreatePanel extends JPanel implements Observer {
    private JTable table;

    /**
     * Create Panel.
     * @author Viktoriya Celik, Trung Dang
     * @version 11/28/15
     *
     */
    public CreatePanel() {
        setBackground(new Color(242,247,242));
        setLayout(null);
        
        JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
        internalFrame.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        internalFrame.setBackground(new Color(242,247,242));
        internalFrame.getContentPane().setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        internalFrame.setBounds(-33, -35, 832, 558);
        add(internalFrame);
        internalFrame.getContentPane().setLayout(null);
        
        JLabel lblPleaseEnterInformation = new JLabel("Please Enter Information Below :");
        lblPleaseEnterInformation.setForeground(Color.BLACK);
        lblPleaseEnterInformation.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
        lblPleaseEnterInformation.setBackground(new Color(204, 204, 255));
        lblPleaseEnterInformation.setBounds(70, 140, 573, 40);
        internalFrame.getContentPane().add(lblPleaseEnterInformation);
        
//        JLabel label = new JLabel("Title");
//        label.setForeground(new Color(128, 0, 128));
//        label.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
//        label.setBackground(new Color(204, 204, 255));
//        label.setBounds(73, 146, 68, 27);
//        internalFrame.getContentPane().add(label);
//        
//        JLabel label_1 = new JLabel("Keyword");
//        label_1.setForeground(new Color(128, 0, 128));
//        label_1.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
//        label_1.setBackground(new Color(204, 204, 255));
//        label_1.setBounds(187, 146, 115, 27);
//        internalFrame.getContentPane().add(label_1);
//        
//        JLabel label_2 = new JLabel("Description");
//        label_2.setForeground(new Color(128, 0, 128));
//        label_2.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
//        label_2.setBackground(new Color(204, 204, 255));
//        label_2.setBounds(313, 146, 150, 27);
//        internalFrame.getContentPane().add(label_2);
//        
//        JLabel label_3 = new JLabel("Text");
//        label_3.setForeground(new Color(128, 0, 128));
//        label_3.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
//        label_3.setBackground(new Color(204, 204, 255));
//        label_3.setBounds(532, 144, 98, 27);
//        internalFrame.getContentPane().add(label_3);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(60, 186, 691, 161);
        internalFrame.getContentPane().add(scrollPane);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {null, null, null, null},
            },
            new String[] {
                "Title", "Keyword", "Description", "Text"
            }
        ) {
            @SuppressWarnings("rawtypes")
            Class[] columnTypes = new Class[] {
                String.class, String.class, String.class, String.class
            };
            @Override
            @SuppressWarnings({"unchecked", "rawtypes"})
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(3).setPreferredWidth(250);
        table.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        
        String title = (String) table.getModel().getValueAt(0, 0);
        String keyword = (String) table.getModel().getValueAt(0, 1);
        String description = (String) table.getModel().getValueAt(0, 2);
        String text = (String) table.getModel().getValueAt(0, 3);
        Clause newClause = new Clause(title, keyword, description, text);
        System.out.println(title + " " + keyword + " " + description + " " + text);
        
        JButton createButton = new JButton(" Create New Clause");
        createButton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createRaisedBevelBorder(), BorderFactory.createLineBorder(Color.BLACK, 1)));
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String title = (String) table.getModel().getValueAt(0, 0);
                String keyword = (String) table.getModel().getValueAt(0, 1);
                String description = (String) table.getModel().getValueAt(0, 2);
                String text = (String) table.getModel().getValueAt(0, 3);
                Clause newClause = new Clause(title, keyword, description, text);
                System.out.println(title + " " + keyword + " " + description + " " + text);
                firePropertyChange("create", null, newClause);
                
                //JOptionPane.showMessageDialog (null, "Your Clause Added to Library!", "Title", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        createButton.setForeground(Color.BLACK);
        createButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        createButton.setBackground(Color.WHITE);
        createButton.setBounds(460, 369, 284, 57);
        final java.awt.Image img3 = new ImageIcon(this.getClass().getResource ("/create2.png")).getImage();
        createButton.setIcon(new ImageIcon(img3));
        internalFrame.getContentPane().add(createButton);
        internalFrame.setVisible(true);

    }
  
    /**
     * @author Trung
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Menu && arg instanceof Boolean) {
            if (((Boolean) arg).booleanValue()){
                JOptionPane.showMessageDialog(this, "Creation of new record succeed!");
            } else {
                JOptionPane.showMessageDialog(this, "Creation of new record failed!");
            }
            
        }
        
    }
}
