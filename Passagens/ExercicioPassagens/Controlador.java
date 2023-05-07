import java.util.ArrayList;

public class Controlador {

    // total de voos que eu tenho
    public final int NUM_VOOS = 10;

    private ArrayList<Voo> voos = new ArrayList<>();

    // Aqui eu inicio o Controlador do voo
    Controlador() {
        // Aqui eu crio os voos e adiciono na lista
        for (int numero = 0; numero < NUM_VOOS; numero++) {
            // O código de voo é formado por letra e número
            String codigoVoo = "A" + numero;
            Voo voo = new Voo(codigoVoo);
            voos.add(voo);
        }
    }

    public Voo procurarVoo (String codigoVoo) {
        // Percorre todos os voos até encontrar um que o código bate
        for (Voo v : voos) {
            // Se o código do voo bater, devolve o voo
            if (codigoVoo.equals(v.getCodigoVoo())) {
                return v;
            }
        }
        // Se eu não encontrar nada, retorno nulo
        return null;
    }

    // Recebo o código do vôo e o assento e retorno o código correspondente do protocolo
    public int verificarStatus (String codigoVoo, int numeroAssento) {
        // Procurar vôo
        Voo voo = procurarVoo(codigoVoo);

        // Se o vôo não for encontrado, código de erro 3
        if (voo == null) {
            return 3;
        }
        // Se eu encontrar o vôo, procuro o assento nele
        Assento assento = voo.procurarAssento(numeroAssento);

        // Se o assento não existir, código de erro 2
        if (assento == null) {
            return 2;
        }

        // Se o assento existir, vejo se ele está disponível
        if (!assento.isDisponivel()) {
            // Se não está disponível, código de erro 1
            return 1;
        }

        // Se eu encontrar o assento e ele estiver disponível
        return 0;
    }

    public ArrayList<Voo> getVoos() {
        return voos;
    }

    public void setVoos(ArrayList<Voo> voos) {
        this.voos = voos;
    }

    
}
