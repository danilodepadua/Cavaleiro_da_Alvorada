package com.daniel.PrimeiraCamada.Quests;

import com.daniel.PrimeiraCamada.Quest;

public class QuestSlimeDeGeloNv3 extends Quest {
    public QuestSlimeDeGeloNv3(){
        this.nome = "Derrote os slimes de gelo super aprimorados";
        this.progresso = 0;
        this.objetivo = 7;
        this.recompensaMoedas= 150;
        this.recompensaXP = 1500;
        this.pontosEvolucao = 2;
        this.nomeInimigo = "Slime de gelo grande";
        this.descricao= "Derrote um total de "+this.objetivo+" slimes da gelo super aprimorados";

    }
}
