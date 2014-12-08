/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.paint.Color;
import javax.swing.*;


//package tabletopterminal;

/**
 *
 * @author nickmorris
 */
public class Title extends JFrame implements ActionListener{
    CreatePage newCreatePage;
    JoinPage newJoinPage;
    JPanel panel = new JPanel();
    FlowLayout layout = new FlowLayout();
    JLabel titleLabel = new JLabel("Table Top Terminal");
    JButton createButton = new JButton("Create Game");
    JButton joinButton = new JButton("Join Game");
    
    InitObject newObject = new InitObject();

    public static void main( String [] args ) { 
        Title titleWindow = new Title();
        // need to check which action performed
        
        
        
    }
    
    public Title(){
        //super(title);
        setSize(800,600);
        titleLabel.setFont(new Font("Arial", 2, 28));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        createButton.setPreferredSize(new Dimension(100, 100));
        joinButton.setPreferredSize(new Dimension(100, 100));
        
        createButton.addActionListener(this);
        joinButton.addActionListener(this);
        
        add(titleLabel, BorderLayout.NORTH);
        panel.setBackground(new java.awt.Color(122, 209, 237));
        panel.add(createButton);
        panel.add(joinButton);
        add(panel);
        panel.setLayout(layout);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == createButton){
            newObject.setIsServer(true);
            newCreatePage = new CreatePage();
        }
        
        if(source == joinButton){
            newObject.setIsServer(false);
            newJoinPage = new JoinPage();
        }
    }
    
    public InitObject getServerOrClientObject(){
        if(newObject.getIsServer() == true)
            newObject = newCreatePage.sendServerObjectToTableTopTerminal();
        else
            newObject = newJoinPage.sendClientObjectToTableTopTerminal();
        return newObject;
    }
}