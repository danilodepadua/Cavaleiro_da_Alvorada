package com.daniel.PrimeiraCamada.Interfaces;

import com.daniel.PrimeiraCamada.Exceptions.PlayerInexistenteException;

public interface IQuest {
    void updateQuestCompleted() throws PlayerInexistenteException;
}
