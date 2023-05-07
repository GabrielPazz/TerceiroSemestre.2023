import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    Socket socket;

    public void comunicarComServidor() throws Exception {
        String codigoVoo = "";
        int assento;
        String textoRequisicao = "Conexão estabelecida";

        String textoRecebido = "";
        socket = new Socket("localhost", 9600);

        Scanner input = new Scanner(System.in);

        // Roda até o usuário digitar fim
        while (!textoRecebido.trim().equals("fim")) {
            // Lê o vôo procurado
            System.out.print("\nDigite o código de vôo ");
            codigoVoo = input.nextLine();

            // Lê o assento procurado
            System.out.print("Digite o assento: ");
            assento = input.nextInt();

            // Envia vôo e assento para o Servidor
            textoRequisicao = codigoVoo + ";" + assento;
            
            // Enviar mensagem para o servidor
            Conexao.enviar(socket, textoRequisicao);

            // Receber mensagem do servidor
            textoRecebido = Conexao.receber(socket);
            System.out.println(textoRecebido);

            // Vou converter a mensagem do servidor para um inteiro
            int codigoDeResposta = Integer.parseInt(textoRecebido.trim());
            mostrarRespostaServidor(codigoDeResposta);

            input.nextLine();
        }
    }


    public void mostrarRespostaServidor(int respostaServer) {
        switch (respostaServer) {
            case 0:
                System.out.println("vôo disponível");
                break;
            case 1:
                System.out.println("assento indisponível");
                break;
            case 2:
                System.out.println("assento inexistente");
                break;
            default: // case 3
                System.out.println("vôo inexistente");
        }
    }


    public static void main(String[] args) {
        try {
            Client cliente = new Client();
            cliente.comunicarComServidor();
        } catch(Exception e){
            e.printStackTrace();
        }
    } 
}
