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
		System.out.println("pickMode- client(0) or server(1)");
		
		Scanner reader = new Scanner(System.in);
		String temp = "empty";
		int status = reader.nextInt();
		ChatLog chat = new ChatLog();
		ConnectionManager manager = new ConnectionManager(chat);
		boolean loopVar = true;

		if(status == 0){
			manager.startClient("127.0.0.1", 2112);

			while(loopVar){
				if(status == 6){
					loopVar = false;
				}else{
				temp = reader.nextLine();
				manager.send(temp);
				status++;
				}

			}

		}else if( status == 1){
			manager.startServer(2112);
			while (true){

				if(status == 6){
					break;
				}else{
				temp = reader.nextLine();
				manager.send(temp);
				status++;
				}
				

			}
		}
		System.out.println("DEBUG - END  LOOPS ");
		manager.closeConnection();




		
		
		


		


	}
}