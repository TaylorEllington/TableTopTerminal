/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tabletopterminal;

import java.awt.BorderLayout;
import java.awt.Color;
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
public class CreatePage extends JFrame implements ActionListener {
    JPanel panel = new JPanel();
    FlowLayout layout = new FlowLayout();
    JLabel titleLabel = new JLabel("Enter Map File Path");
    JLabel mapPathLabel = new JLabel("Map File Path");
    JTextField mapPathTextField = new JTextField("Map File");
    JButton startButton = new JButton("Create Game");
    
    InitObject newServer = new InitObject();
    
    
    public static void main(String[] args){
        CreatePage createPage = new CreatePage();
    }
    
    public CreatePage(){
        setSize(800,600);
        titleLabel.setFont(new Font("Arial", 2, 28));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        mapPathTextField.setPreferredSize(new Dimension(300, 24));
        
        // Since a server is a server is a server...return this as true.
        newServer.setIsServer(true);
        
        startButton.addActionListener(this);
        
        
        panel.setLayout(layout);
        panel.setBackground(new java.awt.Color(122, 209, 237));

        setSize(800, 600);
        add(titleLabel, BorderLayout.NORTH);
        panel.add(mapPathLabel);
        panel.add(mapPathTextField);
        panel.add(startButton);
        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        
        if(source == startButton){
            newServer.setMapPath(mapPathTextField.getText());
        }
    }
    
    public InitObject sendServerObjectToTableTopTerminal(){
        System.out.println(newServer.getIsServer());
        System.out.println(newServer.getIPAddress());
        System.out.println(newServer.getMapPath());
        System.out.println(newServer.getPort());
        return newServer;
    }
}