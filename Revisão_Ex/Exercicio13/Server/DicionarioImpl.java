package Server;

import Comum.Dicionario;
import java.util.ArrayList;

public class DicionarioImpl implements Dicionario {
    private ArrayList<String> dicionario = new ArrayList<>();

    public DicionarioImpl() {
        // No meu construtor, eu preencho o dicionário
        dicionario.add("antes,before");
        dicionario.add("bom,good");
        dicionario.add("depois,after");
        dicionario.add("legal,nice");
        dicionario.add("nulo,null");
    }

    @Override
    public String procuraPalavra(String palavraProcurada) throws java.rmi.RemoteException {

        String[] palavras;
        String palavraEmPortugues;
        String palavraEmIngles;

        for (String palavraETraducao : dicionario) {
            // Depois do split, isso vai virar um vetor de duas posições
            // A posição 0 é a palavra em português, a posição 1 em inglês
            palavras = palavraETraducao.split(",");

            palavraEmPortugues = palavras[0];
            palavraEmIngles = palavras[1];

            if (palavraEmPortugues.equals(palavraProcurada)) {
                return palavraEmIngles;
            }
        }

        // Se você chegou aqui, a palavra não foi encontrada
        return null;
    }
}
