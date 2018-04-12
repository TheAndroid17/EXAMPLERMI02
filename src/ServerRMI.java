
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lab-redes
 */
public class ServerRMI extends UnicastRemoteObject implements InterfazOperArit {

    private static final int PUERTO=3002;
    public ServerRMI() throws RemoteException{};
    public static void main(String[] args) throws Exception{
        (new ServerRMI()).startserverRMI();
    }
    public void startserverRMI(){
        
        try {
            String dirIP = "192.168.62.17";
            System.out.println("Escuchando en.."+dirIP+":"+PUERTO);
            Registry registry = LocateRegistry.createRegistry(PUERTO);
            registry.bind("Servidor1", (InterfazOperArit)this);
        } catch (Exception ex) {
            Logger.getLogger(ServerRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @Override
    public long factorial(int n) throws RemoteException {
     long f = 1;
        for(int i=1;i<=n;i++){
            f=f*i;
        }
     return f;
    }
    
}
