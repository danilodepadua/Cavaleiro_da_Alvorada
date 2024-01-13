package com.daniel.PrimeiraCamada.Quests;

import com.daniel.PrimeiraCamada.Quest;

public class QuestTRex extends Quest {
    public QuestTRex(){
        this.nome = "Derrote os T-Rex's";
        this.progresso = 0;
        this.objetivo = 5;
        this.recompensaMoedas= 100;
        this.recompensaXP = 10;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "T-Rex";
        this.descricao= "Derrote um total de "+this.objetivo+" T-Rex's";

    }
}
