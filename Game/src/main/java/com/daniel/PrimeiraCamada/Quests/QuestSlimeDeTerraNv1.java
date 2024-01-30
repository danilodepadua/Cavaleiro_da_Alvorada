package com.daniel.PrimeiraCamada.Quests;

import com.daniel.PrimeiraCamada.Quest;

public class QuestSlimeDeTerraNv1 extends Quest {
    public QuestSlimeDeTerraNv1(){
        this.nome = "Derrote os slimes de terra";
        this.progresso = 0;
        this.objetivo = 15;
        this.recompensaMoedas= 50;
        this.recompensaXP = 500;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Slime de terra pequeno";
        this.descricao= "Derrote um total de "+this.objetivo+" slimes de terra";

    }
}