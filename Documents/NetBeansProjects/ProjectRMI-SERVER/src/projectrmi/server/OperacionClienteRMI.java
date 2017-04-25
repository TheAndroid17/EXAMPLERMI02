/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectrmi.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author docente05
 */
public class OperacionClienteRMI {
    public static void main(String[] args){
        OperacionInterfaz servidorObj;
        
        String serverAddress = "192.168.244.18";
        int serverPort = 3232;
        try{
            Registry registry = LocateRegistry.getRegistry(serverAddress,serverPort);
            servidorObj = (OperacionInterfaz) (registry.lookup("operacionservidor1"));
            int mayor = servidorObj.calcularMayor(3, 2);
            int menor = servidorObj.calcularMenor(3, 5);
            System.out.println("Mayor es.."+mayor);
            System.out.println("Menor es.."+menor);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
