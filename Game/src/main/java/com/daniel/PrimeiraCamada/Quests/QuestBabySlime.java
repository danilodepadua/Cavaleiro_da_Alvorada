package com.daniel.PrimeiraCamada.Quests;

import com.daniel.PrimeiraCamada.Quest;

public class QuestBabySlime extends Quest {
    public QuestBabySlime(){
        this.nome = "Derrote baby slimes";
        this.progresso = 0;
        this.objetivo = 10;
        this.recompensaMoedas= 100;
        this.recompensaXP = 500;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Slime";
        this.descricao= "Derrote um total de "+this.objetivo+" baby slimes";
    }
}
