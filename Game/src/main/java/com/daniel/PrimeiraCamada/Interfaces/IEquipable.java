package com.daniel.PrimeiraCamada.Interfaces;

import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;

public interface IEquipable {

    void equipar() throws PlayerInexistenteException;
    void desequipar() throws PlayerInexistenteException;
}
