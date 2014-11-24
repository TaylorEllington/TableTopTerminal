import java.util.Observable;
import java.util.Observer;
import java.util.ArrayList;



public class TableTopTerminal{
	public static void main( String [] args){
		ChatLog test = new ChatLog();
		TestObserver tstObserver = new TestObserver();


		test.addObserver(tstObserver);

		ChatMessage one = new ChatMessage("John", "this is the first message" , true);

		test.addMessage(one);


	}
}