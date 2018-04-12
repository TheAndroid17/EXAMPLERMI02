/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectrmi.server;

import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author docente05
 */
public class OperacionServidorRMI extends UnicastRemoteObject implements OperacionInterfaz{

    private static final long serialVersionUID = 985645454554542L;
    private final int PUERTO = 3232;
    public OperacionServidorRMI() throws RemoteException{};
    
    public static void main(String[] args)throws Exception {
        (new OperacionServidorRMI()).iniciarServidor();
    }
    
    public void iniciarServidor(){
        try{
            String dirIP = (InetAddress.getLocalHost().toString());
            System.out.println("Escuchando en.."+dirIP+":"+PUERTO);
            Registry registry = LocateRegistry.createRegistry(PUERTO);
            registry.bind("operacionservidor1", (OperacionInterfaz)this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public int calcularMayor(int num1, int num2) throws RemoteException {
        if(num1>=num2){
            return num1;
        }else{
            return num2;
        }
    }

    @Override
    public int calcularMenor(int num1, int num2) throws RemoteException {
        if(num1<=num2){
            return num1;
        }else{
            return num2;
        }
    }
    
}
