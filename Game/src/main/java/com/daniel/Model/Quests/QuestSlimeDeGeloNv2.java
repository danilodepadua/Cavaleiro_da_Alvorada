package com.daniel.Model.Quests;

public class QuestSlimeDeGeloNv2 extends Quest {
    public QuestSlimeDeGeloNv2() {
        this.nome = "Derrote os slimes de gelo aprimorados";
        this.progresso = 0;
        this.objetivo = 10;
        this.recompensaMoedas= 500;
        this.recompensaXP = 1000;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Slime de gelo médio";
        this.descricao= "Derrote um total de "+this.objetivo+" slimes de gelo aprimorados";
    }
}
