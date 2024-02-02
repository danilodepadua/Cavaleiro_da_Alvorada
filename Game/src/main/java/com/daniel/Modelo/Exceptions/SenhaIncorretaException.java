package com.daniel.Modelo.Exceptions;

public class SenhaIncorretaException extends Exception{
    public SenhaIncorretaException() {
        super("Senha incorreta");
    }
}
