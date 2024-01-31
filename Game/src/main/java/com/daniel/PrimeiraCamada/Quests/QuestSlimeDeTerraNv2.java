package com.daniel.PrimeiraCamada.Quests;

import com.daniel.PrimeiraCamada.Quest;

public class QuestSlimeDeTerraNv2 extends Quest {
    public QuestSlimeDeTerraNv2() {
        this.nome = "Derrote os slimes de vento  aprimorados";
        this.progresso = 0;
        this.objetivo = 10;
        this.recompensaMoedas= 500;
        this.recompensaXP = 1000;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Slime de terra médio";
        this.descricao= "Derrote um total de "+this.objetivo+" slimes de terra aprimorados";
    }
}
