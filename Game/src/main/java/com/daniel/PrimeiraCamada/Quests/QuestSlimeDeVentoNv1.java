package com.daniel.PrimeiraCamada.Quests;

import com.daniel.PrimeiraCamada.Quest;

public class QuestSlimeDeVentoNv1 extends Quest {
    public QuestSlimeDeVentoNv1(){
        this.nome = "Derrote os slimes de vento";
        this.progresso = 0;
        this.objetivo = 25;
        this.recompensaMoedas= 50;
        this.recompensaXP = 70;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Slime de vento pequeno";
        this.descricao= "Derrote um total de "+this.objetivo+" slimes de vento";

    }
}
