package Client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import Comum.Dicionario;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Cliente digita a palavra procurada
            System.out.println("Digite a palavra palavra procurada: ");
            String palavraEmPortugues = sc.next();


            // Se conectar ao binder (Registry)
            Registry registry = LocateRegistry.getRegistry("localhost", 18000);

            // Procurando por um registro que utilize a interface Dicionario
            // Se encontrado, pode executar os métodos no stub
            Dicionario stub = (Dicionario) registry.lookup("Dicionario");

            // Procura a palavra
            String palavraEmIngles = stub.procuraPalavra(palavraEmPortugues);

            // Se eu não encontrei a palavra em inglês
            if (palavraEmIngles == null) {
                System.out.println("Palavra não encontrada");
            } else {
                System.out.println("A tradução em inglês é " + palavraEmIngles);
            }

        } catch (Exception e) {
            // Mostra a mensagem de erro
            System.out.println(e.getMessage());
        }
        sc.close();
    }
}
