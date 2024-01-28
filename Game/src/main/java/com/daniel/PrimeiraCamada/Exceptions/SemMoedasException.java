package com.daniel.PrimeiraCamada.Exceptions;

public class SemMoedasException extends Exception{
    public SemMoedasException(){
        super("Sem moedas suficientes para a viageem");
    }
}
