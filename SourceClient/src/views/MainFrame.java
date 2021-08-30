/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Fabbo
 */
public class MainFrame extends JFrame {
    
    private MainPanel mainPanel;
    
    public MainFrame() {
        
        this.setBounds(700, 300, 280, 350);
        
        this.initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    /**
     * This method creates main components of this frame
     */
    public void initComponents() {
        this.mainPanel = new MainPanel(this);
        this.add(this.mainPanel);
        
    }
}
