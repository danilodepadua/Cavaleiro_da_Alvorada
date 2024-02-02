package com.daniel.Model.Interfaces;

import com.daniel.Model.Exceptions.PlayerInexistenteException;

public interface IConsumableOutBattle {
    void Consumir()throws PlayerInexistenteException;
}
