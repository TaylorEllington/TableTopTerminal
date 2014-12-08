import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Thread;
import java.io.IOException;
import java.net.SocketException;
import java.net.Socket;
import java.net.ServerSocket;



public class TableTopTerminal{
	public static void main( String [] args){
		//NICK - have your code start here, i need a filled initObject so i can start the connection manager from here




		
		
		System.out.println("pickMode- client(0) or server(1)");
		
		Scanner reader = new Scanner(System.in);
		String temp = "empty";
		int status = reader.nextInt();
		ChatLog chat = new ChatLog();

		ConnectionManager manager = new ConnectionManager(chat);
		boolean loopVar = true;

		if(status == 0){
			manager.startClient("127.0.0.1", 2112);

			

		}else if( status == 1){
			manager.startServer(2112);
			while (true){

				
				temp = reader.nextLine();
				manager.send(temp);
				
				}
				

			
		}
		
		
		GridBagLayoutDemo UI = new GridBagLayoutDemo(chat , manager);
	
		
	}
}