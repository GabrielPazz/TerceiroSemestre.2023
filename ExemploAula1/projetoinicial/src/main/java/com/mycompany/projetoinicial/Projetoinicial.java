/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.projetoinicial;

/**
 *
 * @author 12522172106
 */
public class Projetoinicial {

    public static void main(String[] args) {
        Pessoa pedro = new Pessoa("Pedro", 24);

        System.out.println(pedro.getNome() + " tem "
                + pedro.getIdade() + " anos.");

        pedro.andar();

        pedro.setIdade(25);

        System.out.println(pedro.getNome() + " tem "
                + pedro.getIdade() + " anos.");
    }
}
