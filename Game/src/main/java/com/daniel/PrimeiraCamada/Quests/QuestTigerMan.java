package com.daniel.PrimeiraCamada.Quests;

import com.daniel.PrimeiraCamada.Quest;

public class QuestTigerMan extends Quest {
    public QuestTigerMan() {
        this.nome = "Derrote 3 Tiger Man";
        this.progresso = 0;
        this.objetivo = 3;
        this.recompensaMoedas= 100;
        this.recompensaXP = 10;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Tigrinho";
        this.descricao= "Derrote um total de "+this.objetivo+" Tigrinhos";
    }
}
