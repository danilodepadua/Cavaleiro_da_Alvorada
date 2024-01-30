package com.daniel.PrimeiraCamada.Quests;

import com.daniel.PrimeiraCamada.Quest;

public class QuestSlimeDeAguaNv3 extends Quest {
    public QuestSlimeDeAguaNv3(){
        this.nome = "Derrote os slimes de água super aprimorados";
        this.progresso = 0;
        this.objetivo = 7;
        this.recompensaMoedas= 150;
        this.recompensaXP = 1500;
        this.pontosEvolucao = 2;
        this.nomeInimigo = "Slime de água grande";
        this.descricao= "Derrote um total de "+this.objetivo+" slimes de água super aprimorados";

    }
}
