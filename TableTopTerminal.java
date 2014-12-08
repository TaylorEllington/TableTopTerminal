import java.io.IOException;
import java.lang.Thread;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;




public class TableTopTerminal{
        InitObject tempObject = new InitObject();

        public static ChatLog chat;
        public static Players players;


	public static void main( String [] args){
		//NICK - have your code start here, i need a filled initObject so i can start the connection manager from here
        // InitObject tempObject = new InitObject();
        //Title titleScreen = new Title();

        if(args.length < 1){
                System.out.println("Syntax: TableTopTerminal <Your name> <server or client> <server ip address>");
                System.exit(1);
        }

        chat = new ChatLog();
	players = new Players();

	ConnectionManager manager = new ConnectionManager(chat, players);
		
        String name = args[0];
        String mode = args[1];
        String ip = null;
        if(mode.equals("client") ){
        	ip = args[2];
        	manager.startClient(ip, 2112);
        }else{
        	manager.startServer(2112);
        }
         
                
	
		
		GridBagLayoutDemo UI = new GridBagLayoutDemo( manager, name , players);
		chat.addObserver(UI);
	




	}
}