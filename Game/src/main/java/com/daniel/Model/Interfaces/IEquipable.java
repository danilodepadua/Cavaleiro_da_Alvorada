package com.daniel.Model.Interfaces;

import com.daniel.Model.Exceptions.PlayerInexistenteException;

public interface IEquipable {

    void equipar() throws PlayerInexistenteException;
    void desequipar() throws PlayerInexistenteException;
}
