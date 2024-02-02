package com.daniel.Model.Dados.Quests;

public class QuestSlimeDeRaioNv2 extends Quest {
    public QuestSlimeDeRaioNv2() {
        this.nome = "Derrote os slimes de raio aprimorados";
        this.progresso = 0;
        this.objetivo = 10;
        this.recompensaMoedas= 500;
        this.recompensaXP = 1000;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Slime de raio médio";
        this.descricao= "Derrote um total de "+this.objetivo+" slimes de raio aprimorados";
    }
}
