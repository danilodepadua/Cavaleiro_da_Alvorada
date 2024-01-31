package com.daniel.PrimeiraCamada.Quests;

import com.daniel.PrimeiraCamada.Quest;

public class QuestSlimeDeGeloNv1 extends Quest {
    public QuestSlimeDeGeloNv1(){
        this.nome = "Derrote os slimes de gelo";
        this.progresso = 0;
        this.objetivo = 15;
        this.recompensaMoedas= 200;
        this.recompensaXP = 500;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Slime de gelo pequeno";
        this.descricao= "Derrote um total de "+this.objetivo+" slimes de gelo";

    }
}
