package com.daniel.Exceptions;

public class PlayerExistenteException extends Exception{
    //Implementar
    public PlayerExistenteException(){
        super("Player não existe");
    }
}
