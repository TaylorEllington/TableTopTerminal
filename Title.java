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
import tabletopterminal.CreatePage;
import tabletopterminal.InitObject;

//package tabletopterminal;

/**
 *
 * @author nickmorris
 */
public class Title extends JFrame{
    /*JFrame frame = new JFrame("Welcome to Table Top Terminal!");*/
        JPanel panel = new JPanel();
        FlowLayout layout = new FlowLayout();
        JLabel titleLabel = new JLabel("Table Top Terminal");
        JButton createButton = new JButton("Create Game");
        JButton joinButton = new JButton("Join Game");
        
        
        InitObject newObject = new InitObject();

    public static void main( String [] args ) { 
        Title titleWindow = new Title("Welcome to Table Top Terminal!");
        
    }
    
    public Title(String title){
        super(title);
        setSize(800,600);
        titleLabel.setFont(new Font("Arial", 2, 28));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        createButton.setPreferredSize(new Dimension(100, 100));
        joinButton.setPreferredSize(new Dimension(100, 100));
        
        createButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                newObject.InitServer(WIDTH, null);
                CreatePage newCreatePage = new CreatePage();
                System.out.println("New server object created.");
            }
        });
        
        joinButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                newObject.InitClient(WIDTH);
                System.out.println("New client object created.");
            }
        });
        
        
        add(titleLabel, BorderLayout.NORTH);
        panel.setBackground(new java.awt.Color(122, 209, 237));
        panel.add(createButton);
        panel.add(joinButton);
        add(panel);
        panel.setLayout(layout);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}