package com.daniel.Modelo.Exceptions;

public class RemoverCoinsException extends Exception{

    public RemoverCoinsException() {
        super("Quantidade inválida ou moedas insuficientes.");
    }
}
