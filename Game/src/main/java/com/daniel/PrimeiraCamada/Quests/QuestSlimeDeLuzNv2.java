package com.daniel.PrimeiraCamada.Quests;

import com.daniel.PrimeiraCamada.Quest;

public class QuestSlimeDeLuzNv2 extends Quest {
    public QuestSlimeDeLuzNv2() {
        this.nome = "Derrote os slimes de luz aprimorados";
        this.progresso = 0;
        this.objetivo = 10;
        this.recompensaMoedas= 500;
        this.recompensaXP = 1000;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Slime de luz médio";
        this.descricao= "Derrote um total de "+this.objetivo+" slimes de luz aprimorados";
    }
}
