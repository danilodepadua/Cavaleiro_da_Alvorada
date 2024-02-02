package com.daniel.Modelo.Exceptions;

public class SemMoedasCassino extends Exception{
    public SemMoedasCassino(){
        super("Sem moedas suficientes para a aposta!");
    }
}
