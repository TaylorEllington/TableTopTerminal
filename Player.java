public class Player {
	//coordinates
	int currentX;
	int currentY;
	int oldX;
	int oldY;

	String playerName;

	public Player(){

	}

	public void setCurrentX(int x ){this.currentX = x;}
	public int  getCurrentX(){return currentX;}
	public void setCurrentY(int y){this.currentY = y;}
	public int  getCurrentY(){return currentY;}
	public void setOldX(int x){this.oldX = x;}
	public int  getOldX(){return oldX;}
	public void setoldY(int y){this.oldY = y;}
	public int  getoldY(){return oldY;}
}