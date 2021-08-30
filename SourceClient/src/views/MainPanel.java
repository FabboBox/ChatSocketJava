/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.io.DataOutputStream;

/**
 *
 * @author Fabbo
 */
public class MainPanel extends JPanel{
    
    private MainFrame mainFrame;
    
    private JLabel clientText;
    
    private JTextField msgField;
    
    private JButton sendButton;
    
    private Socket clientSocket;
    
    private DataOutputStream outputFlow;
    
    private ActionListener sendTextEvent = e -> {
        try{
            this.outputFlow.writeUTF(this.msgField.getText());
            this.msgField.setText("");
        }
        catch(IOException ex){
            this.showErr("This message connot be sent :(");
        }
    };
    
    public MainPanel(MainFrame mFrame) {
        this.mainFrame = mFrame;
        this.initComponents();
        this.connectServer();
    }
    
    public void initComponents() {
        this.clientText = new JLabel("Client:");
        this.add(this.clientText);
        
        this.msgField = new JTextField(20);
        this.add(this.msgField);
        
        this.sendButton = new JButton("Send");
        this.sendButton.addActionListener(sendTextEvent);
        this.add(this.sendButton);
    }
    
    public void connectServer() {
        try{
            this.clientSocket = new Socket("192.168.0.17", 9999);
            outputFlow = new DataOutputStream(this.clientSocket.getOutputStream());
        } 
        catch (IOException ex) {
            this.showErr("Server disconnected...");
        }
        
    }
    
    public void showErr(String msg) {
        JDialog err = new JDialog(this.mainFrame, msg);
    }
}