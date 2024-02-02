package com.daniel.Modelo.Interfaces;

import com.daniel.Modelo.Exceptions.PlayerInexistenteException;

public interface IEquipable {

    void equipar() throws PlayerInexistenteException;
    void desequipar() throws PlayerInexistenteException;
}
