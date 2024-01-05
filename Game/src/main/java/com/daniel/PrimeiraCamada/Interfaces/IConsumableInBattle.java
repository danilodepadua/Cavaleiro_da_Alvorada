package com.daniel.PrimeiraCamada.Interfaces;

import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.PersonagemLuta;

public interface IConsumableInBattle {
    void Consumir(PersonagemLuta p) throws PlayerInexistenteException;
}
