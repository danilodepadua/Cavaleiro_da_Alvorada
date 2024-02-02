package com.daniel.Modelo.Exceptions;

import com.daniel.Modelo.BatalhaDeTurnos.Comportamento;

public class ErroUsarMagiaExptions extends Exception {
     public ErroUsarMagiaExptions(String i, Comportamento c){
         super("A classe de inimigo: " + i + ", falhou ao tentar usar magia usando a classe de comportamento: " + c.getClass().getName());
     }
}
