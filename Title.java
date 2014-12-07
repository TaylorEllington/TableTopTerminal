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
import javafx.scene.paint.Color;
import javax.swing.*;

//package tabletopterminal;

/**
 *
 * @author nickmorris
 */
public class Title {

    public static void main( String [] args ) {

        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                JFrame frame = new JFrame("Welcome to Table Top Terminal!");
                JPanel panel = new JPanel();
                FlowLayout layout = new FlowLayout();
                JLabel titleLabel = new JLabel("Table Top Terminal");
                JButton createButton = new JButton("Create Game");
                JButton joinButton = new JButton("Join Game");
                
                titleLabel.setFont(new Font("Arial", 2, 28));
                titleLabel.setHorizontalAlignment(JLabel.CENTER);
                
                createButton.setPreferredSize(new Dimension(100, 100));
                joinButton.setPreferredSize(new Dimension(100, 100));
                
                panel.setLayout(layout);
                
                panel.setBackground(new java.awt.Color(122, 209, 237));
                
                frame.setSize(800, 600);
                frame.add(titleLabel, BorderLayout.NORTH);
                panel.add(createButton);
                panel.add(joinButton);
                frame.add(panel);
                //frame.add(titleLabel, BorderLayout.NORTH);
                
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        
        });

    }

}