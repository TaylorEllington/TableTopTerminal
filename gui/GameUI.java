package start;
import java.awt.*;
import javax.swing.*;  

public class GameUI {
	
	public static void addComponentsToPane(Container mainWindowBackground){
		
		//mainWindowBackground.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		mainWindowBackground.setLayout(new GridBagLayout());
		
		GridBagConstraints mainWindowBackgroundConstraints = new GridBagConstraints();
		//mainWindowBackgroundConstraints.fill = GridBagConstraints.HORIZONTAL;
		//mainWindowBackgroundConstraints.fill = GridBagConstraints.VERTICAL;
		
		JButton button;
		
		button = new JButton("MAP");
		
		mainWindowBackgroundConstraints.gridx = 0;
		mainWindowBackgroundConstraints.gridy = 0;
		mainWindowBackgroundConstraints.gridwidth = 3;
		mainWindowBackgroundConstraints.gridheight = 3;
		
		mainWindowBackground.add(button, mainWindowBackgroundConstraints);
		
		button = new JButton("KEY");
		
		mainWindowBackgroundConstraints.gridx = 3;
		mainWindowBackgroundConstraints.gridy = 0;
		mainWindowBackgroundConstraints.gridwidth = 1;
		mainWindowBackgroundConstraints.gridheight = 3;
		
		mainWindowBackground.add(button, mainWindowBackgroundConstraints);
		
		button = new JButton("CHAT BOX");
		
		mainWindowBackgroundConstraints.gridx = 0;
		mainWindowBackgroundConstraints.gridy = 3;
		mainWindowBackgroundConstraints.gridwidth = 3;
		mainWindowBackgroundConstraints.gridheight = 1;
		
		mainWindowBackground.add(button, mainWindowBackgroundConstraints);
		
		button = new JButton("ROLL DIE BUTTON");
		
		mainWindowBackgroundConstraints.gridx = 3;
		mainWindowBackgroundConstraints.gridy = 3;
		mainWindowBackgroundConstraints.gridwidth = 1;
		mainWindowBackgroundConstraints.gridheight = 2;
		
		mainWindowBackground.add(button, mainWindowBackgroundConstraints);	
		
		button = new JButton("TEXT BOX");
		
		mainWindowBackgroundConstraints.gridx = 0;
		mainWindowBackgroundConstraints.gridy = 4;
		mainWindowBackgroundConstraints.gridwidth = 2;
		mainWindowBackgroundConstraints.gridheight = 1;
		
		mainWindowBackground.add(button, mainWindowBackgroundConstraints);
		
		button = new JButton("ENTER BUTTON");
		
		mainWindowBackgroundConstraints.gridx = 2;
		mainWindowBackgroundConstraints.gridy = 4;
		mainWindowBackgroundConstraints.gridwidth = 1;
		mainWindowBackgroundConstraints.gridheight = 1;
		
		mainWindowBackground.add(button, mainWindowBackgroundConstraints);			
		
	}
	
	private static void createAndShowGUI(){
		
		Dimension mainWindowSize = new Dimension(800,600);
		
		JFrame mainWindow = new JFrame("Table Top Terminal");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setResizable(false);
		
		Container mainWindowBackground = mainWindow.getContentPane();
		mainWindowBackground.setPreferredSize(mainWindowSize);
		mainWindowBackground.setBackground(Color.YELLOW);
		
		addComponentsToPane(mainWindowBackground);
		
		//Display the window.
        mainWindow.pack();
        mainWindow.setVisible(true);
	}
	
	public static void main(String[] args) {
        
		//Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
