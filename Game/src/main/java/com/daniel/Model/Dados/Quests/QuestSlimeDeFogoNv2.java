package com.daniel.Model.Dados.Quests;

public class QuestSlimeDeFogoNv2 extends Quest {
    public QuestSlimeDeFogoNv2() {
        this.nome = "Derrote os slimes de fogo aprimorados";
        this.progresso = 0;
        this.objetivo = 10;
        this.recompensaMoedas= 500;
        this.recompensaXP = 1000;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Slime de fogo médio";
        this.descricao= "Derrote um total de "+this.objetivo+" slimes de fogo aprimorados";
    }
}
