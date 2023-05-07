import java.util.Scanner;

public class Cliente {

    // O cliente só tem acesso real ao proxy
    // Mas na visão dele, parece que ele está acessando a conta diretamente

    public static void main(String[] args) {
        Conta conta = new ContaProxy();
        Scanner sc = new Scanner(System.in);

        try {
            // Pedir username e senha do cliente
            System.out.println("Digite o username: ");
            String username = sc.nextLine();
            
            System.out.println("Digite a senha: ");
            String senha = sc.nextLine(); 

            // Tenta se conectar
            conta.acessarConta(username, senha);
            
        } catch (Exception e) {
            // Se houverr erro de acesso
            System.out.println(e.getMessage());
        }
        sc.close();
    }
}
