import java.util.ArrayList;

public class Voo {
    public final int NUM_ASSENTOS = 50;

    private String codigoVoo;
    private ArrayList<Assento> assentos = new ArrayList<>();

    // Construtor do vôo
    Voo(String codigoVoo) {
        this.codigoVoo = codigoVoo;
        // Quando eu criar um vôo, vou adicionar 50 assentos nele
        for (int numero = 0; numero < NUM_ASSENTOS; numero++) {
            // Cria o assento
            Assento assento = new Assento(numero, true);

            // Coloca o assento no Arraylist
            assentos.add(assento);
        }
    }

    public Assento procurarAssento(int numeroAssento) {
        // Procurar o assento no ArrayList
        for (Assento a : assentos) {
            // Se o número do assento bater com o que eu procuro
            if (numeroAssento == a.getNumero()) {
                // eu retorno o assento
                return a;
            }
        }      
        // Se eu não encontrar o assento, devolvo null
        return null;
    }

    public String getCodigoVoo() {
        return codigoVoo;
    }

    public void setCodigoVoo(String codigoVoo) {
        this.codigoVoo = codigoVoo;
    }

    public ArrayList<Assento> getAssentos() {
        return assentos;
    }

    public void setAssentos(ArrayList<Assento> assentos) {
        this.assentos = assentos;
    }

    
}
