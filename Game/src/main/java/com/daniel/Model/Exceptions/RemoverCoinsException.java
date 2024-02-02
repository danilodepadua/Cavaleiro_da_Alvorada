package com.daniel.Model.Exceptions;

public class RemoverCoinsException extends Exception{

    public RemoverCoinsException() {
        super("Quantidade inválida ou moedas insuficientes.");
    }
}
