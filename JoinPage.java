/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tabletopterminal;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author nickmorris
 */
public class JoinPage extends JFrame implements ActionListener{
    JPanel panel = new JPanel();
    FlowLayout layout = new FlowLayout();
    JLabel joinLabel = new JLabel("Enter Correct IP Address");
    JLabel ipAddressLabel = new JLabel("IP Address");
    JTextField ipAddressField = new JTextField("IP Address");
    JButton joinButton = new JButton("Join Game");
    
    InitObject newClient = new InitObject();
    
    public static void main(String[] args){ 
        JoinPage joinPage = new JoinPage();
    }
    
    public void JoinPage(){
        setSize(800, 600);
        ipAddressField.setPreferredSize(new Dimension(300, 24));
        joinLabel.setFont(new Font("Arial", 2, 28));
        joinLabel.setHorizontalAlignment(JLabel.CENTER);
        
        // Since a client isn't a server, we set this boolean to false.
        newClient.setIsServer(false);
        
        joinButton.addActionListener(this);
        
        panel.setLayout(layout);
        panel.setBackground(new java.awt.Color(122, 209, 237));
        
        // We set the IP address to the value of the text field
        add(joinLabel, BorderLayout.NORTH);
        panel.add(ipAddressLabel);
        panel.add(ipAddressField);
        panel.add(joinButton);
        add(panel);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        
        //return newClient;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
       Object source = e.getSource();
       if(source == joinButton){
           int address = Integer.parseInt(ipAddressField.getText());
           newClient.setIPAddress(address);
       }
    }
    
    public InitObject sendClientObjectToTableTopTerminal(){
        System.out.println(newClient.getIsServer());
        System.out.println(newClient.getIPAddress());
        System.out.println(newClient.getMapPath());
        System.out.println(newClient.getPort());
        return newClient;
    }
}