package com.daniel.Model.Exceptions;

public class SemMoedasParaLojaException extends Exception{
    public SemMoedasParaLojaException() {
        super("Sem moedas sufiecientes para compra!");
    }
}
