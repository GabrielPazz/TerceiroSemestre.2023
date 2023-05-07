/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 12522172106
 */
public class Produto {
    private String nome;
    private String marca;
    private double preco;
    private double peso;
    
    public Produto(String nome, String marca, 
            double preco, double peso) {
        this.nome = nome;
        this.marca= marca;
        this.preco = preco;
        this.peso = peso;
    }
    
    public String toString() {
        return "Nome: " + nome +
               "\nMarca: " + marca + 
                "\nPreço: " + preco +
                "\nPeso: " + peso + "kg";
    }
}
