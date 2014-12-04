import java.lang.Thread;
import java.net.Socket;
import java.net.SocketException;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.IOException;

public class ServerSocketConnectionRunnable implements Runnable{
	Socket connectionToClient;

	PrintWriter out;
	BufferedReader in;
	String outGoingMessage;
	boolean keepRunning;

	ServerSocketConnectionRunnable(Socket sock){
		this.connectionToClient = sock;
		outGoingMessage = "";
		

		try{
			this.connectionToClient.setSoTimeout(1000);
			out = new PrintWriter(connectionToClient.getOutputStream(), true);
			in = new BufferedReader( new InputStreamReader( connectionToClient.getInputStream() ) );
		} catch ( IOException e){

		}

	}// end constructor

	public void sendMessage(String message){
		outGoingMessage = message;
	}

	public void run(){

		String temp = "empty";
		keepRunning= true;
		while( keepRunning ){	

	
			try{

				// Reading IN from socket
				if(outGoingMessage == ""){
					//read from socket (blocking)
					temp = in.readLine();
					//process anything thats read
						if(temp == null){
							//socket is disconnected i think
							System.out.println("null yall");
						}else{
							//Debug, will be changed later
							System.out.println(temp);
							temp = "";
						}

				}else {
					// Sending OUT from socket
					out.println(outGoingMessage);
					outGoingMessage ="";
				}
				

			}catch(IOException E){
				// this is bad but we need to decide on behavior for this
			}
			
    
		} // end while loop


		return;
	}

	public void closeConnection(){
		try{
			connectionToClient.close();
		}catch(IOException E){

		}
		keepRunning = false;
	}


}// end 