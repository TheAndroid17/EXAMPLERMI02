/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectrmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author docente05
 */
public interface OperacionInterfaz extends Remote{
    public int calcularMayor(int num1, int num2) throws RemoteException;
    public int calcularMenor(int num1, int num2) throws RemoteException;
}
