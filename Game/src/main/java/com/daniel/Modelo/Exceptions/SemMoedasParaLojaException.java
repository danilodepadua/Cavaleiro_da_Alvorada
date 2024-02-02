package com.daniel.Modelo.Exceptions;

public class SemMoedasParaLojaException extends Exception{
    public SemMoedasParaLojaException() {
        super("Sem moedas sufiecientes para compra!");
    }
}
