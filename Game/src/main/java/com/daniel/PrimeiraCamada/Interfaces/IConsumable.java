package com.daniel.PrimeiraCamada.Interfaces;

import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;

public interface IConsumable {
    void Consumir() throws PlayerInexistenteException;
}
