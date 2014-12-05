import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.*; 

public class MapMouseListener extends MouseAdapter 
{
	private JPanel panel;
	
	public MapMouseListener(JPanel panel) 
	{
		this.panel = panel;
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		panel.setBackground(Color.white);
	}
}