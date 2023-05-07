import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Conexao
 */
public class Conexao {

    public static String receber(Socket socket) throws IOException {
        InputStream in = socket.getInputStream();
        byte infoBytes[] = new byte[100];
        int bytesLidos = in.read(infoBytes);

        if (bytesLidos > 0) {
            return new String(infoBytes);
        } else {
            return "";
        }
    }

    public static void enviar(Socket socket, String mensagem) throws IOException {
        OutputStream out = socket.getOutputStream();
        out.write(mensagem.getBytes());
    }
}