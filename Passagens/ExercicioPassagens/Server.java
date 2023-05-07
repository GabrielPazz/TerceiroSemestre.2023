import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    Socket socketClient;
    ServerSocket serversocket;
    Controlador controlador = new Controlador();

    public boolean connect() {
        try {
            socketClient = serversocket.accept();  // fase de conexao
            return true;
        } catch (IOException e) {
            System.err.println("Nao fez conexao" + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        try {
            Server servidor = new Server();
            servidor.rodarServidor();
        } catch(Exception e){
            e.printStackTrace();
        }
    } 

    public void rodarServidor() throws Exception {
        String textoRecebido = "";
        String textoEnviado = "Olá, Cliente";
        Scanner input = new Scanner(System.in);

        serversocket = new ServerSocket(9600);
        System.out.println("Servidor iniciado!");

        boolean conectado = connect();

        while (conectado && !textoRecebido.trim().equals("fim")) {

            textoRecebido = Conexao.receber(socketClient);

            System.out.println("Cliente enviou: " + textoRecebido);

            // Quebra a mensagem enviada pelo cliente em 2
            String[] codigoEAssento = textoRecebido.split(";");

            String codigoVoo = codigoEAssento[0];
            // Converte o número de assento para um valor numérico
            int numeroAssento = Integer.parseInt(codigoEAssento[1].trim());

            // Verifica o código correspondente do nosso protocolo
            int codigoStatus = controlador.verificarStatus(codigoVoo, numeroAssento);

            // Preciso enviar o código de status em formato de String
            Conexao.enviar(socketClient, Integer.toString(codigoStatus));
        }
        socketClient.close();
        input.close();
    }

}
