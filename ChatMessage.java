public class ChatMessage{
	String senderName;
	String text;
	boolean dieResult;

	public ChatMessage(String senderName, String text, boolean dieResult){
		this.senderName = senderName;
		this.text = text;
		this.dieResult = dieResult;
	}

	public String getSenderName(){
		return this.senderName;
	}

	public String getText(){
		return this.text;
	}

	public boolean getDieResult(){
		return this.dieResult;
	}
}