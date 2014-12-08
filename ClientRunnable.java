import java.lang.Thread;
import java.net.Socket;
import java.net.SocketException;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.InetAddress;

public class ClientRunnable implements Runnable{

	String messageToSend;
	Socket connectionToServer;

	PrintWriter out;
	BufferedReader in;
	ChatLog chat;
	Players players;

	ClientRunnable(String address, int port, ChatLog chat, Players players){
		this.chat = chat;
		this.players = players;

		try{
			//create socket
			this.connectionToServer = new Socket( InetAddress.getByName(address), port);
			this.connectionToServer.setSoTimeout(10);
			out = new PrintWriter(connectionToServer.getOutputStream(), true);
			in = new BufferedReader( new InputStreamReader( connectionToServer.getInputStream() ) );

		}catch(Exception E){}


		messageToSend = "";
	}
	
	public void run(){

		String temp = "";

		while( ! Thread.currentThread().isInterrupted() ){

	

	
			try{
				if(messageToSend == ""){
					//read from socket (blocking)
					temp = in.readLine();
					if(temp == "null"){
						//socket is disconnected i think
						System.out.println("null yall");
					}else{
						//Debug, will be changed later
						parseInput(temp);
						
						temp = "";
					}
				    
				}else {
					// send outgoing message.
					out.println(messageToSend);
					messageToSend ="";

				}

				

				

			}catch(IOException E){

			}
			
    
		} // end while loop
		System.out.println("DING");
		return;

	}
	
	public void setMessage(String message){
		messageToSend = message;
	}

	public void closeConnection(){
		Thread.currentThread().interrupt();
	}


	public void parseInput(String message){
		
		String[] components = message.split("\\|");

		if(components[0].equals("roll") ){
			GridBagLayoutDemo.updateDieRoll(components[1], Integer.parseInt(components[2]) );
		}else if (components[0].equals("chat")){
			GridBagLayoutDemo.updateChat(components[1], components[2]);
			
		}else if(components[0].equals("cord")){
			GridBagLayoutDemo.updatePlayer(components[1], Integer.parseInt(components[2]), Integer.parseInt(components[3]) );
		}else{
			System.out.println(components[0]);
		}




	}

	
}