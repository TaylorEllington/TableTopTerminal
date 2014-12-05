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
public class CreatePage {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
                public void run(){
                    JFrame frame = new JFrame("Create a Game");
                    JPanel panel = new JPanel();
                    FlowLayout layout = new FlowLayout();
                    JLabel titleLabel = new JLabel("Enter File Path for JSON");
                    JLabel jsonLabel = new JLabel("JSON Path");
                    JTextField jsonTextField = new JTextField("JSON Path");
                    jsonTextField.setPreferredSize(new Dimension(300, 24));

                    titleLabel.setFont(new Font("Arial", 2, 28));
                    titleLabel.setHorizontalAlignment(JLabel.CENTER);

                    //createButton.setPreferredSize(new Dimension(100, 100));
                    //joinButton.setPreferredSize(new Dimension(100, 100));

                    panel.setLayout(layout);


                    frame.setSize(800, 600);
                    frame.add(titleLabel, BorderLayout.NORTH);
                    panel.add(jsonLabel);
                    panel.add(jsonTextField);
                    frame.add(panel);
                    //frame.add(titleLabel, BorderLayout.NORTH);

                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                }

        });
    }
}
