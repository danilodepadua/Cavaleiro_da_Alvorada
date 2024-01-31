package com.daniel.PrimeiraCamada.Quests;

import com.daniel.PrimeiraCamada.Quest;

public class QuestSlimeDeFogoNv3 extends Quest {
    public QuestSlimeDeFogoNv3(){
        this.nome = "Derrote os slimes de fogo super aprimorados";
        this.progresso = 0;
        this.objetivo = 7;
        this.recompensaMoedas= 800;
        this.recompensaXP = 1500;
        this.pontosEvolucao = 2;
        this.nomeInimigo = "Slime de fogo grande";
        this.descricao= "Derrote um total de "+this.objetivo+" slimes de fogo super aprimorados";

    }
}
