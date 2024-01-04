package com.daniel.PrimeiraCamada.Interfaces;

import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.PersonagemLuta;

public interface IConsumableOutBattle {
    void Consumir()throws PlayerInexistenteException;
}
