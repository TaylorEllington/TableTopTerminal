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

	ClientRunnable(String address, int port){

		try{
			//create socket
			this.connectionToServer = new Socket( InetAddress.getByName(address), port);
			this.connectionToServer.setSoTimeout(1000);
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
						System.out.println(temp);
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

	
}