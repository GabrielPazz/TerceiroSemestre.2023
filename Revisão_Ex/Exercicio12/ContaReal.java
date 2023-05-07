public class ContaReal implements Conta {

    private double saldo = 3000.0;

    @Override
    public void acessarConta(String username, String senha) throws Exception {

        try {

            System.out.println("Validando o token...");
            Thread.sleep(3000);
            System.out.println("Bem-vindo "+username);
            System.out.println("Você tem R$ " + saldo);
            
        } catch (Exception e) {
            System.out.println("Erro no acesso a sua conta, seu dinheiro agora é nosso.");
        }

    }
}
