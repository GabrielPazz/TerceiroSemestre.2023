import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public void comunicarServidor() throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");
        int port = 5252;

        String texto = "";
        Scanner entrada = new Scanner(System.in);

        while (!texto.trim().equalsIgnoreCase("fim")) {
            System.out.print("Digite uma mensagem: ");
            texto = entrada.nextLine();
            byte saida[];
            saida = texto.getBytes();
            
            DatagramPacket datagram = new DatagramPacket(saida, saida.length, address, port);
            // connect() method
            socket.connect(address, port);

            // send() method
            socket.send(datagram);
            System.out.println("Pacote enviado...");
        }
    }

    public static void main(String[] args) {
        try {
            Client cliente = new Client();
            cliente.comunicarServidor();
        } catch(Exception e){
            e.printStackTrace();
        }
    } 
}
