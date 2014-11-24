import java.util.Observable;
import java.util.Observer;
import java.util.ArrayList;

public class TestObserver implements Observer {

	
	public void update( Observable obj, Object arg){
		System.out.println("Zhu Li did the thing " + arg);
	}
	

}