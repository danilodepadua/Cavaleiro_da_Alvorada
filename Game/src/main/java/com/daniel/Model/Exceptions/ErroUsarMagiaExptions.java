package com.daniel.Model.Exceptions;

import com.daniel.Model.BatalhaDeTurnos.Comportamento;

public class ErroUsarMagiaExptions extends Exception {
     public ErroUsarMagiaExptions(String i, Comportamento c){
         super("A classe de inimigo: " + i + ", falhou ao tentar usar magia usando a classe de comportamento: " + c.getClass().getName());
     }
}
