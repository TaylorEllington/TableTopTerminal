

public class ConnectionManager{
	

	ChatLog chat;
	Players players;
	ClientRunnable clientrunnable;
	ServerRunnable serverrunnable;

	
	public ConnectionManager(ChatLog chat, Players players){
		this.chat = chat;
		this.players = players;

	}

	public void startServer(int port ){

		serverrunnable = new ServerRunnable(port, chat, players);
		new Thread(serverrunnable).start();

	}

	public void startClient(String address, int port){
		clientrunnable = new ClientRunnable(address, port, chat, players);
		new Thread(clientrunnable).start();

	}

	public void closeConnection(){
		if( clientrunnable != null){
			clientrunnable.closeConnection();
		}else if(serverrunnable != null){
			serverrunnable.closeConnection();
		}else{
			System.out.println("ConnectionManager.closeConnection() - this should not happen");
		}
	}

	public void send(String message){

		if( clientrunnable != null){
			clientrunnable.setMessage(message);
		}else if(serverrunnable != null){
			serverrunnable.broadcastToAllClients(message);
		}else{
			System.out.println("ConnectionManager.send() - this should not happen");
		}

	}

	public void sendChatMessage(String text, String playername){

		String message = "chat|" + playername+ "|" + text;

		if( clientrunnable != null){
			clientrunnable.setMessage(message);
		}else if(serverrunnable != null){
			serverrunnable.broadcastToAllClients(message);
		}else{
			System.out.println("ConnectionManager.send() - this should not happen");
		}

	}

	public void sendPlayerCoordinates(String playerName, int x, int y){

		String message = "cord|" + playerName+ "|" + x + "|" + y;

		if( clientrunnable != null){
			clientrunnable.setMessage(message);
		}else if(serverrunnable != null){
			serverrunnable.broadcastToAllClients(message);
		}else{
			System.out.println("ConnectionManager.send() - this should not happen");
		}

	}

	public void sendPlayerCoordinates(String playerName, int value){

		String message = "roll|" + playerName+ "rolled a " + value;

		if( clientrunnable != null){
			clientrunnable.setMessage(message);
		}else if(serverrunnable != null){
			serverrunnable.broadcastToAllClients(message);
		}else{
			System.out.println("ConnectionManager.send() - this should not happen");
		}

	}
	public void serverEchoChatMessage(String text, String playername ){
		String message = "chat|" + playername+ "|" + text;
		if(serverrunnable != null){
			serverrunnable.broadcastToAllClients(message);
		}
	}

	public void serverEchoPlayerCoord(String playerName, int x, int y){

		String message = "cord|" + playerName+ "|" + x + "|" + y;

		if(serverrunnable != null){
			serverrunnable.broadcastToAllClients(message);
		}
	}




}