package com.daniel.PrimeiraCamada.Quests;

import com.daniel.PrimeiraCamada.Quest;

public class QuestSlimeNv3 extends Quest {
    public QuestSlimeNv3() {
        this.nome = "Derrote os Slimes grandes";
        this.progresso = 0;
        this.objetivo = 15;
        this.recompensaMoedas= 100;
        this.recompensaXP = 10;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Slime grande";
        this.descricao= "Derrote um total de "+this.objetivo+" slimes grandes";

    }

}
