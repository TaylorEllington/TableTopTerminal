import java.lang.Thread;
import java.net.SocketException;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.SocketException;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class ServerRunnable implements Runnable{
	ServerSocket serversocket;
	ArrayList<ServerSocketConnectionRunnable> connections;
	boolean keepRunning;

	ServerRunnable( int port){
		//create server socket
		try{

			serversocket = new ServerSocket(port);
			serversocket.setSoTimeout(1000);
			
		}catch(SocketException E){
		}catch(IOException E){}


		connections = new ArrayList<ServerSocketConnectionRunnable>();
	}
	
	public void run(){
		keepRunning = true;
		Socket temp;
		while( keepRunning ){
			//listen on server socket
			try{
				temp = serversocket.accept();
				//when a connection occurs create a serversocketconnection thread
					if(temp != null){
						ServerSocketConnectionRunnable newConnection = new ServerSocketConnectionRunnable(temp);
						connections.add(newConnection);
						Thread go = new Thread( newConnection );
						go.start();
					}
			}catch (IOException E){

			}
		}

		

		//when interuupted shut everything down
	}
	public void closeConnection(){
		System.out.println("closing server");
		keepRunning = false;
		for(int i = 0; i < connections.size(); i++){
			connections.get(i).closeConnection();
		}
	}

	public void broadcastToAllClients(String message){
		for( int i = 0; i < connections.size() ; i++){
			connections.get(i).sendMessage(message);
		}
	}

}