package com.daniel.PrimeiraCamada.Quests;

import com.daniel.PrimeiraCamada.Quest;

public class QuestSlimeDeVentoNv2 extends Quest {
    public QuestSlimeDeVentoNv2(){
        this.nome = "Derrote os slimes de vento aprimorados";
        this.progresso = 0;
        this.objetivo = 15;
        this.recompensaMoedas= 70;
        this.recompensaXP = 100;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Slime de vento médio";
        this.descricao= "Derrote um total de "+this.objetivo+" slimes de vento aprimorados";

    }
}
