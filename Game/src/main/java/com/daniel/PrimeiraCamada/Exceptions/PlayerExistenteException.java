package com.daniel.PrimeiraCamada.Exceptions;

public class PlayerExistenteException extends Exception{
    //Implementar
    public PlayerExistenteException(){
        super("Player não existe");
    }
}
