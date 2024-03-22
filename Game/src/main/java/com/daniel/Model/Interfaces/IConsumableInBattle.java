package com.daniel.Model.Interfaces;

import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.BatalhaDeTurnos.PersonagemLuta;

public interface IConsumableInBattle {
    TextoNode Consumir(PersonagemLuta p) throws PlayerInexistenteException;
}
