package com.daniel.PrimeiraCamada.Quests;

import com.daniel.PrimeiraCamada.Quest;

public class QuestSlimeDeVentoNv3 extends Quest {
    public QuestSlimeDeVentoNv3(){
        this.nome = "Derrote os slimes de vento super aprimorados";
        this.progresso = 0;
        this.objetivo = 10;
        this.recompensaMoedas= 100;
        this.recompensaXP = 300;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Slime de vento grande";
        this.descricao= "Derrote um total de "+this.objetivo+" slimes de vento super aprimorados";

    }
}
