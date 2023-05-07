/**
 * Assento
 */
public class Assento {

    private int numero;
    private boolean disponivel;

    Assento(int numero, boolean disponivel) {
        this.numero = numero;
        this.disponivel = disponivel;
    }

    public String toString() {
        return "Assento número " + this.numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    
}