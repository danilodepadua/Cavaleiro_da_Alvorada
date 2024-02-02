package com.daniel.Model.Interfaces;

import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;

public interface IConsumableInBattle {
    String Consumir(PersonagemLuta p) throws PlayerInexistenteException;
}
