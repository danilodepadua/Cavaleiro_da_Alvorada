package com.daniel.Model.Exceptions;

public class SaveInexistenteException extends Exception{
    public SaveInexistenteException() {
        super("Save desatualizado ou inexistente");
    }
}
