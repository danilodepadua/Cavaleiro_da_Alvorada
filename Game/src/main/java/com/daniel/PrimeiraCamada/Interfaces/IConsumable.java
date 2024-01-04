package com.daniel.PrimeiraCamada.Interfaces;

import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;
import com.daniel.PrimeiraCamada.Personagem;
import com.daniel.PrimeiraCamada.PersonagemLuta;

public interface IConsumable {
    void Consumir(PersonagemLuta p);
    void Consumir()throws PlayerInexistenteException;
}
