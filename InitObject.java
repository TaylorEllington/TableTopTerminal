/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author nickmorris
 */
public class InitObject {
    private int port;
    private String mapPath;
    private int ipAddress;
    private boolean isServer;
    
    public InitObject(){
        setPort();
        mapPath = "";
        ipAddress = 0;
        isServer = true;
    }
    
    // constructor for Server
    public void InitServer(String newMapPath){
        setPort();
        mapPath = newMapPath;
    }
    
    // constructor for Client
    public void InitClient(int newIPAddress){
        ipAddress = newIPAddress;
    }
    
    // Hardcoded, for convenience, to the localhost
    // Used by Server
    public void setPort(){
        port = 2112;
    }
    
    // getter for the port
    public int getPort(){
        return port;
    }
    
    // Useful only for the Server
    public void setMapPath(String path){
        mapPath = path;
    }
    
    // getter for the mapPath
    public String getMapPath(){
        return mapPath;
    }
    
    // Useful only for the Client
    public void setIPAddress(int address){
        ipAddress = address;
    }
    
    // getter for the ipAddress
    public int getIPAddress(){
        return ipAddress;
    }
    
    // Used to set flag whether object is server or not
    public void setIsServer(boolean server){
        isServer = server;
    }
    
    // getter for the isServer boolean
    public boolean getIsServer(){
        return isServer;
    }
}
