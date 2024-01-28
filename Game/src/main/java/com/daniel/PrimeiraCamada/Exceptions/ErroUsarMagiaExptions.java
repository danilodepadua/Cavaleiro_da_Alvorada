package com.daniel.PrimeiraCamada.Exceptions;

import com.daniel.PrimeiraCamada.Comportamento;
import com.daniel.PrimeiraCamada.Inimigo;

public class ErroUsarMagiaExptions extends Exception {
     public ErroUsarMagiaExptions(String i, Comportamento c){
         super("A classe de inimigo: " + i + ", falhou ao tentar usar magia usando a classe de comportamento: " + c.getClass().getName());
     }
}
