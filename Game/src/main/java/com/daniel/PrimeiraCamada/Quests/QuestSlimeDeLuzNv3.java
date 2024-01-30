package com.daniel.PrimeiraCamada.Quests;

import com.daniel.PrimeiraCamada.Quest;

public class QuestSlimeDeLuzNv3 extends Quest {
    public QuestSlimeDeLuzNv3() {
        this.nome = "Derrote os slimes de luz super aprimorados";
        this.progresso = 0;
        this.objetivo = 10;
        this.recompensaMoedas= 100;
        this.recompensaXP = 1000;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Slime de luz grande";
        this.descricao= "Derrote um total de "+this.objetivo+" slimes de luz super aprimorados";
    }
}
