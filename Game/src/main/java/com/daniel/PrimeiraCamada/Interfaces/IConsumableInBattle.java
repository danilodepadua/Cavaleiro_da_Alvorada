package com.daniel.PrimeiraCamada.Interfaces;

import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.PersonagemLuta;

public interface IConsumableInBattle {
    String Consumir(PersonagemLuta p) throws PlayerInexistenteException;
}
