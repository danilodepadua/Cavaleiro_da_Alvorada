package com.daniel.Modelo.Interfaces;

import com.daniel.Modelo.Exceptions.PlayerInexistenteException;
import com.daniel.Modelo.BatalhaDeTurnos.PersonagemLuta;

public interface IConsumableInBattle {
    String Consumir(PersonagemLuta p) throws PlayerInexistenteException;
}
