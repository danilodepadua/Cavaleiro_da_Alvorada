package com.daniel.PrimeiraCamada.Exceptions;

public class SenhaIncorretaException extends Exception{
    public SenhaIncorretaException() {
        super("Senha incorreta");
    }
}
