package com.daniel.Modelo.Exceptions;

public class CompraErroException extends Exception{
    public CompraErroException() {
        super("Erro ao processar a compra!");
    }
}
