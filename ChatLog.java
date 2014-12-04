import java.util.Observable;
import java.util.Observer;
import java.util.ArrayList;

public class ChatLog extends Observable{


	ArrayList<ChatMessage> chatLog;

	public ChatLog(){
		chatLog = new ArrayList<ChatMessage>();
	}

	public void addMessage(ChatMessage msg){
		chatLog.add(msg);
		setChanged();
		notifyObservers(msg.getText());
	}

	public void debugDump(){
		for(int i = 0; i < chatLog.size(); i++){
			System.out.println(chatLog.get(i).getSenderName()+ ": "+ chatLog.get(i).getText() );
		}
	}
}