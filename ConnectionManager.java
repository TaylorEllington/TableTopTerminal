

public class ConnectionManager{
	

	ChatLog chat;
	ClientRunnable clientrunnable;
	ServerRunnable serverrunnable;
	//Map map;
	//playerIcons;
	//PlayerPointers;
	
	public ConnectionManager(ChatLog chat){
		this.chat = chat;

	}

	public void startServer(int port ){

		serverrunnable = new ServerRunnable(port);
		new Thread(serverrunnable).start();

	}

	public void startClient(String address, int port){
		clientrunnable = new ClientRunnable(address, port);
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

	public void sendChatMessage(String text){

		String message = "chat|" + text;

		if( clientrunnable != null){
			clientrunnable.setMessage(message);
		}else if(serverrunnable != null){
			serverrunnable.broadcastToAllClients(message);
		}else{
			System.out.println("ConnectionManager.send() - this should not happen");
		}

	}

	public void sendPlayerCoordinates(String playerName, int x, int y){

		String message = "coord|" + playerName+ "|" + x + "|" + y;

		if( clientrunnable != null){
			clientrunnable.setMessage(message);
		}else if(serverrunnable != null){
			serverrunnable.broadcastToAllClients(message);
		}else{
			System.out.println("ConnectionManager.send() - this should not happen");
		}

	}


}