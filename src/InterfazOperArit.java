
import java.rmi.Remote;
import java.rmi.RemoteException;
/*Author: JHOPES*/

public interface InterfazOperArit extends Remote{
    public long factorial(int n) throws RemoteException;
}
