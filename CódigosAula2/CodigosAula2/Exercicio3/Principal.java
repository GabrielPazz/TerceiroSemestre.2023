public class Principal {
    public static void main(String[] args) {
        Circulo circ = new Circulo(5);
        double areaCirculo = circ.calcArea();
        System.out.println("A área do círculo é " + areaCirculo);

        Forma ret = new Retangulo(5, 10);
        double areaRetangulo = ret.calcArea();
        System.out.println("A área do retângulo é: " + areaRetangulo);
    }
}
