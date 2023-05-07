/**
 * ContraProxy
 */
public class ContaProxy implements Conta {

    private final Conta conta = new ContaReal();

    private final String username = "aula_revisao";
    private final String senha = "12345678";

    @Override
    public void acessarConta(String username, String senha) throws Exception {
        // Comparando o nome de usuário passado com o nome de usuário verdadeiro
        if (username.equals(this.username) &&
            senha.equals(this.senha))
        {
            conta.acessarConta(username, senha);    
        } else {
            throw new Exception("Usuário ou senha incorretos.");
        }

    }
}