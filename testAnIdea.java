public class testAnIdea{
	ChatLog local;
	
	public testAnIdea(ChatLog local){
	this.local = local;
	}

		public void doSomething(){

		ChatMessage one = new ChatMessage("John", "this is the second message" , true);

		local.addMessage(one);
		}

}