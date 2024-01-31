package com.daniel.PrimeiraCamada.Quests;

import com.daniel.PrimeiraCamada.Quest;

public class QuestCobraGigante extends Quest {
    public QuestCobraGigante() {
        this.nome = "Derrote Cobras";
        this.progresso = 0;
        this.objetivo = 5;
        this.recompensaMoedas= 800;
        this.recompensaXP = 1500;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Cobra gigante";
        this.descricao= "Derrote um total de "+this.objetivo+" cobras";

    }
}
