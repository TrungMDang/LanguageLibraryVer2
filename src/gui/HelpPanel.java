package gui;

import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class HelpPanel extends JPanel {

    /**
     * Help Panel.
     * @author Emrullah Celik
     * @version 11/28/15
     *
     */
    public HelpPanel() {
        setBackground(new Color(204, 204, 255));
        setLayout(null);
        
        JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
        internalFrame.getContentPane().setBackground(new Color(232,239,233));
        internalFrame.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        internalFrame.setBackground(new Color(204, 204, 255));
        internalFrame.getContentPane().setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        internalFrame.setBounds(-83, -53, 848, 545);
        add(internalFrame);
        internalFrame.getContentPane().setLayout(null);
        
        JLabel lblCcsLanguageLibrary = new JLabel("CCS Language Library");
        lblCcsLanguageLibrary.setForeground(SystemColor.textHighlight);
        lblCcsLanguageLibrary.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 50));
        lblCcsLanguageLibrary.setBackground(new Color(204, 204, 204));
        lblCcsLanguageLibrary.setBounds(135, 126, 589, 82);
        internalFrame.getContentPane().add(lblCcsLanguageLibrary);
        
        JLabel lblVersion = new JLabel("Version 1.0  \u00A9 2015");
        lblVersion.setForeground(new Color(0, 204, 0));
        lblVersion.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 35));
        lblVersion.setBackground(new Color(204, 204, 204));
        lblVersion.setBounds(395, 312, 383, 82);
        internalFrame.getContentPane().add(lblVersion);
        
        JLabel labelHelp = new JLabel(" HELP PAGE!");
        labelHelp.setForeground(new Color(255, 0, 0));
        labelHelp.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        labelHelp.setBounds(219, 219, 312, 120);
        final java.awt.Image img3 = new ImageIcon(this.getClass().getResource ("/help2.png")).getImage();
        labelHelp.setIcon(new ImageIcon(img3));
        internalFrame.getContentPane().add(labelHelp);
        internalFrame.setVisible(true);

    }
}
