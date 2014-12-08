import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.event.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*; 
import java.util.Observable;
import java.util.Observer;
import java.awt.BorderLayout;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.util.ArrayList;


public class GridBagLayoutDemo   implements Observer{
  final static boolean shouldFill = true;
  final static boolean shouldWeightX = true;
  final static boolean RIGHT_TO_LEFT = false;

  static JPanel[][] map;

  static JEditorPane chatBoxTextPane;
  static ArrayList<Player> playerlist;
  static ConnectionManager connections;
  static String name;
  

  public GridBagLayoutDemo( ConnectionManager connections, String pname, Players players){
    name = pname;
    this.connections = connections;
    
    playerlist = new ArrayList<Player>();

    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });

  }
  public static void updateChat(String nname, String text){
    if(!nname.equals(name)){
    chatBoxTextPane.setText(chatBoxTextPane.getText() + "\n" + nname + ": " + text);
    connections.serverEchoChatMessage(text, nname);
}
  }

  public static void updatePlayer(String name, int x, int y){
    boolean found = false;
    //search playerlist for name
    for(int i =0 ; i < playerlist.size(); i++ ){
        //if found move
        if(playerlist.get(i).playerName.equals(name) ){
            map[playerlist.get(i).getCurrentX()][playerlist.get(i).getCurrentY()].setBackground(Color.WHITE);
            map[x][y].setBackground(Color.BLACK);
            playerlist.get(i).setCurrentX(x);
            playerlist.get(i).setCurrentY(y);
            found = true;

        }
    }
        
        //if not found create and place;
        if(!found){
            Player temp = new Player();
            temp.setCurrentY(y);
            temp.setCurrentX(x);
            map[x][y].setBackground(Color.BLACK);
            temp.playerName = name;
            playerlist.add(temp);
        }
        connections.serverEchoPlayerCoord(name, x, y);
    
  }
  public static void updateDieRoll(String name, String text){
    
    }

  public void update(Observable o, Object arg){
    //THIS ISNT WORKING!!!!
    if(o instanceof ChatLog){

    }

  }




  public  void addComponentsToPane(Container pane) {
    if (RIGHT_TO_LEFT) {
      pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    }

    Dimension mainWindowSize = new Dimension(800,600);
    pane.setPreferredSize(mainWindowSize);
    
    JButton button;
    pane.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    
    if (shouldFill) {
      // natural height, maximum width
      c.fill = GridBagConstraints.HORIZONTAL;
    }
    
    int rows = 9;
    int cols = 9;

    map = new JPanel[cols][rows];
    
    c.gridx = 0;
    c.gridy = 0;
    c.gridwidth = 3;
    c.gridheight = 3;
    
    GridLayout mapPanelGrid = new GridLayout(rows, cols);
    
    JPanel mapPanel = new JPanel(mapPanelGrid);
    
    for (int i = 0; i < rows; i++){
    	for (int j = 0; j < cols; j++){
    	   Border thinBorder = LineBorder.createBlackLineBorder();

    		MapTile tempPanel = new MapTile();
            tempPanel.setBorder(thinBorder);
    		tempPanel.setRow(i);
    		tempPanel.setColumn(j);
            map[j][i] = tempPanel;
    		
    		if ((i+j) % 2 == 0){
    			
    			//tempPanel.setBackground(Color.CYAN);
    			//tempPanel.setColor("CYAN");
    			
    			//TEST CODE
    			//System.out.println(tempPanel.getColor());
    		}
    		else{
    		
    			//tempPanel.setBackground(Color.RED);
    			//tempPanel.setColor("RED");
    		}
    		
    		tempPanel.addMouseListener(new MouseAdapter() {
    			@Override
    			public void mousePressed(MouseEvent e) {
    				//clicks++;
    				//text.setText(clicks + " Clicks");
    				/*
    				JPanel k = (JPanel) e.getSource();
    				k.setBackground(Color.WHITE);
    				k.setColor("WHITE");
    				*/
    				
    				MapTile k = (MapTile) e.getSource();
    				k.setBackground(Color.BLACK);
    				//k.setColor("WHITE");    				
    				
    				//TEST CODE
    				//System.out.print("Row: ");
    				//System.out.println();
    				//System.out.print("Column: ");
    				//System.out.println();    				
    				//System.out.println(k.getColor());
                    updatePlayer(name, k.getColumn(), k.getRow() );
                    connections.sendPlayerCoordinates(name, k.getColumn(), k.getRow());

    			}
    		});
    	
    		mapPanel.add(tempPanel);    		
    	
    	}
    }
    
    
    
     /*

    for (int i = 0; i < (rows*cols); i++){
    	JPanel tempPanel = new JPanel();
    	
    	if (i % 2 == 0){
    		tempPanel.setBackground(Color.CYAN);
    	}
    	else{
    		tempPanel.setBackground(Color.RED);
    	}
        
    	tempPanel.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mousePressed(MouseEvent e) {
    			//clicks++;
    			//text.setText(clicks + " Clicks");
    			JPanel k = (JPanel) e.getSource();
    			k.setBackground(Color.WHITE);
    		}
    	});
    	
    	mapPanel.add(tempPanel);
    }
    
    */
    
    mapPanel.setBackground(Color.CYAN);
    mapPanel.setPreferredSize(new Dimension(600, 360));
    
    pane.add(mapPanel, c);
    
    // Map Key Panel------------------------------------------------------------
    JPanel mapKeyPanel = new JPanel();
    mapKeyPanel.setBackground(Color.GRAY);
    mapKeyPanel.setPreferredSize(new Dimension(200, 360));
    
    c.gridx = 3;
    c.gridy = 0;
    c.gridwidth = 1;
    c.gridheight = 3;
    
    JLabel mapKeyTextPaneLabel = new JLabel("Player Key");
    mapKeyPanel.add(mapKeyTextPaneLabel);
    
    JEditorPane mapKeyTextPane = new JEditorPane();
    mapKeyTextPane.setPreferredSize(new Dimension(190, 325));
    mapKeyPanel.add(mapKeyTextPane);
    
    JScrollPane mapKeyScroll = new JScrollPane (mapKeyTextPane, 
    	JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
    	JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
    mapKeyScroll.setPreferredSize(new Dimension(190, 325));
    
    mapKeyPanel.add(mapKeyScroll);
    
    pane.add(mapKeyPanel, c);
    
    // Chat Box Panel-----------------------------------------------------------
    JPanel chatBoxPanel = new JPanel();
    chatBoxPanel.setBackground(Color.GRAY);
    chatBoxPanel.setPreferredSize(new Dimension(600, 120));   
    
    c.gridx = 0;
    c.gridy = 3;
    c.gridwidth = 3;
    c.gridheight = 1;
    
     chatBoxTextPane = new JEditorPane();
    chatBoxTextPane.setPreferredSize(new Dimension(590, 110));
    chatBoxPanel.add(chatBoxTextPane);
    
    JScrollPane chatBoxScroll = new JScrollPane (chatBoxTextPane, 
    	JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
    	JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
    chatBoxScroll.setPreferredSize(new Dimension(590, 110));
    
    chatBoxPanel.add(chatBoxScroll);
    
    pane.add(chatBoxPanel, c);
    
    // Text Box Panel-----------------------------------------------------------
    JPanel textBoxPanel = new JPanel();
    textBoxPanel.setBackground(Color.GRAY);
    textBoxPanel.setPreferredSize(new Dimension(400, 120));   
    
    c.gridx = 0;
    c.gridy = 4;
    c.gridwidth = 2;
    c.gridheight = 1;
    
    JTextArea textField = new JTextArea("Chat Here!");
    textField.setPreferredSize(new Dimension(390, 110));
    textField.setLineWrap(true);
    
    JScrollPane textFieldScroll = new JScrollPane (textField, 
    	JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
    	JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
    textFieldScroll.setPreferredSize(new Dimension(390, 110));
    
    textBoxPanel.add(textFieldScroll);
    
    pane.add(textBoxPanel, c);
    
    // Roll Die Panel-----------------------------------------------------------
    JPanel rollDiePanel = new JPanel();
    rollDiePanel.setBackground(Color.GRAY);
    rollDiePanel.setPreferredSize(new Dimension(200, 240));   
    
    c.gridx = 3;
    c.gridy = 3;
    c.gridwidth = 1;
    c.gridheight = 2;
    
    JButton rollDieButton = new JButton("Roll Die");
    rollDieButton.setAlignmentX(Component.CENTER_ALIGNMENT); 
    rollDieButton.setPreferredSize(new Dimension(190, 230));
    
    rollDieButton.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                //ADD FUNCTIONALITY HERE
            }
        });      
    
    rollDiePanel.setLayout(new BoxLayout(rollDiePanel, BoxLayout.PAGE_AXIS)); 
    rollDiePanel.add(Box.createVerticalGlue()); 
    rollDiePanel.add(rollDieButton);
    rollDiePanel.add(Box.createVerticalGlue()); 
    
    pane.add(rollDiePanel, c);
    
    // Enter Panel--------------------------------------------------------------
    JPanel enterPanel = new JPanel();
    enterPanel.setBackground(Color.GRAY);
    enterPanel.setPreferredSize(new Dimension(200, 120));   
    
    c.gridx = 2;
    c.gridy = 4;
    c.gridwidth = 1;
    c.gridheight = 1;
    
    JButton enterButton = new JButton("Enter");
    enterButton.setAlignmentX(Component.CENTER_ALIGNMENT); 
    
    enterButton.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {

                System.out.println(textField.getText());
                chatBoxTextPane.setText(chatBoxTextPane.getText() + "\n" + name+": " + textField.getText() );
                connections.sendChatMessage(textField.getText(), name);

            }
        });      
    
    enterPanel.setLayout(new BoxLayout(enterPanel, BoxLayout.PAGE_AXIS)); 
    enterPanel.add(Box.createVerticalGlue()); 
    enterPanel.add(enterButton);
    enterPanel.add(Box.createVerticalGlue()); 
    
    pane.add(enterPanel, c);
  }

  /**
   * Create the GUI and show it. For thread safety, this method should be
   * invoked from the event-dispatching thread.
   */
  private void createAndShowGUI() {
    // Create and set up the window.
    JFrame frame = new JFrame("TableTopTerminal");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);

    // Set up the content pane.
    addComponentsToPane(frame.getContentPane());

    // Display the window.
    frame.pack();
    frame.setVisible(true);
  }
  /*
  public static void main(String[] args) {
    // Schedule a job for the event-dispatching thread:
    // creating and showing this application's GUI.
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }
  */
  

}