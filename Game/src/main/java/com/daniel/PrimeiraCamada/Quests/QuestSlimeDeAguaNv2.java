package com.daniel.PrimeiraCamada.Quests;

import com.daniel.PrimeiraCamada.Quest;

public class QuestSlimeDeAguaNv2 extends Quest {
    public QuestSlimeDeAguaNv2(){
        this.nome = "Derrote os slimes de água aprimorados";
        this.progresso = 0;
        this.objetivo = 10;
        this.recompensaMoedas= 500;
        this.recompensaXP = 1000;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Slime de água médio";
        this.descricao= "Derrote um total de "+this.objetivo+" slimes de água aprimorados";

    }
}
