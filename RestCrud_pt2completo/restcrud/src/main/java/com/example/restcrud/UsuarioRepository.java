/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.restcrud;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author gustavo
 */
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    
}
