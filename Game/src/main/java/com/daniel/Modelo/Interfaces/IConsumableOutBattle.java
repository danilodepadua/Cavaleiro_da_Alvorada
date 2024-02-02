package com.daniel.Modelo.Interfaces;

import com.daniel.Modelo.Exceptions.PlayerInexistenteException;

public interface IConsumableOutBattle {
    void Consumir()throws PlayerInexistenteException;
}
