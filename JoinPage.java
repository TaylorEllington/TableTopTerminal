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
public class JoinPage extends JFrame {
    JPanel panel = new JPanel();
    FlowLayout layout = new FlowLayout();
    JLabel joinLabel = new JLabel("Enter Correct IP Address");
    JLabel ipAddressLabel = new JLabel("IP Address");
    JTextField ipAddressField = new JTextField("IP Address");
    JButton joinButton = new JButton("Join Game");
    public static void main(String[] args){ 
        JoinPage joinPage = new JoinPage();
    }
    
    public JoinPage(){
        super("Join a Game");
        setSize(800, 600);
        ipAddressField.setPreferredSize(new Dimension(300, 24));
        joinLabel.setFont(new Font("Arial", 2, 28));
        joinLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(layout);
        panel.setBackground(new java.awt.Color(122, 209, 237));
        
        joinButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("BAMA");
            }
        });
        
        add(joinLabel, BorderLayout.NORTH);
        panel.add(ipAddressLabel);
        panel.add(ipAddressField);
        panel.add(joinButton);
        add(panel);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}