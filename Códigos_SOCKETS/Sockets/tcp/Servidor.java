import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Servidor {
    Socket socketClient;
    ServerSocket serverSocket;

    public boolean connect() {
        try {
            socketClient = serverSocket.accept();
            return true;
        } catch (Exception e) {
            System.out.println("Não fez a conexão.");
            return false;
        }
    }

    public void rodarServidor() throws IOException {
        String textoRecebido = "";
        String textoEnviado = "Olá, cliente";
        Scanner input = new Scanner(System.in);

        serverSocket = new ServerSocket(9600);
        System.out.println("Servidor iniciado com sucesso.");

        boolean conectado = connect();

        while(conectado) {
            textoRecebido = Conexao.receber(socketClient);

            System.out.println("Cliente enviou: " + textoRecebido);

            System.out.println("Envie sua resposta: ");

            textoEnviado = input.nextLine();

            Conexao.enviar(socketClient, textoEnviado);

        }
        socketClient.close();
        input.close();

    }

    public static void main(String[] args) {
        try {
            Servidor servidor = new Servidor();
            servidor.rodarServidor();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
