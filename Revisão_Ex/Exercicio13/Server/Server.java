package Server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import Comum.Dicionario;

public class Server extends DicionarioImpl {
    public static void main(String[] args) {
        try {
            // Cria o dicionário
            DicionarioImpl obj = new DicionarioImpl();

            // Exporta o objeto para o stub
            Dicionario stub = (Dicionario) UnicastRemoteObject.exportObject(obj, 0);

            // Adicionando o método remoto no binder
            Registry registry = LocateRegistry.createRegistry(18000);

            registry.rebind("Dicionario", stub);

            System.out.println("Servidor rodando");

        } catch (Exception e) {
            System.out.println("Erro no servidor: " + e.toString());
        }
    }
}
