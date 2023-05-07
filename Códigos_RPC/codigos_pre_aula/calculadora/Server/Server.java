import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends CalculadoraImpl {

    public static void main(String args[]) {
        try {
            // Instanciação
            CalculadoraImpl obj = new CalculadoraImpl();

            // Exportando o objeto para o stub
            Calculadora stub = (Calculadora) UnicastRemoteObject.exportObject(obj, 0);

            // Binding o objeto remoto (stub) no registro
            Registry registry = LocateRegistry.createRegistry(18000);
            registry.rebind("Calculadora", stub);

            System.out.println("Servidor Pronto");
        } catch (Exception e) {
            System.err.println("Exceção do Servidor: " + e.toString());
            e.printStackTrace();
        }
    }
    
}
