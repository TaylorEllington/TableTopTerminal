
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
public class Players extends Observable{
	
	public ArrayList<Player> players;

	public Players(){
		players = new ArrayList<Player>();
	}

	public void changesMade(){
		setChanged();
		notifyObservers();

	}
}