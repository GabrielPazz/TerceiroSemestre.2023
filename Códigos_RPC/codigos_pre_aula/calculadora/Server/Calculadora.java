import java.rmi.Remote;

public interface Calculadora extends Remote {
    
    public int soma(int a, int b) throws java.rmi.RemoteException;

}
