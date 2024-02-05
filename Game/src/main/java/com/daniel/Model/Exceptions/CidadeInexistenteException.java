package com.daniel.Model.Exceptions;

public class CidadeInexistenteException extends Exception{
    public CidadeInexistenteException() {
        super("Cidade não selecionada");
    }
}
