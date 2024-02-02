package com.daniel.Modelo.Exceptions;

public class SemMoedasException extends Exception{
    public SemMoedasException(){
        super("Sem moedas suficientes para a viagem");
    }
}
