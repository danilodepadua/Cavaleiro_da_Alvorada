package com.daniel.Model.Exceptions;

public class SenhaIncorretaException extends Exception{
    public SenhaIncorretaException() {
        super("Senha incorreta");
    }
}
