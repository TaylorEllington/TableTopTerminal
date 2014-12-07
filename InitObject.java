/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tabletopterminal;

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
        
    
    }
    
    public void setPort(){
        port = 2112;
    }
    
    public int getPort(){
        return port;
    }
    
    public void setMapPath(String path){
        mapPath = path;
    }
    
    public String getMapPath(){
        return mapPath;
    }
    
    public void setIPAddress(int address){
        ipAddress = address;
    }
    
    public int getIPAddress(){
        return ipAddress;
    }
    
    public void setIsServer(boolean server){
        isServer = server;
    }
    
    public boolean getIsServer(){
        return isServer;
    }
}
