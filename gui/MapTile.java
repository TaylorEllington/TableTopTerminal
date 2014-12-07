import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.*; 

public class MapTile extends JPanel{

	public int row;
	public int column;
	public String color;
	
	/*
	
	public MapTile(int r, int c) {
		this.row = r;
		this.column = c;
	}
	
	public MapTile(int r, int c, String color){
		this.row = r;
		this.column = c;
		this.color = color;
	}
	
	*/
	
	public void setRow(int r){
		this.row = r;
	}
	
	public void setColumn(int c){
		this.column = c;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	public int getRow(){
		return row;
	}
	
	public int getColumn(){
		return column;
	}
	public String getColor(){
		return color;
	}

}