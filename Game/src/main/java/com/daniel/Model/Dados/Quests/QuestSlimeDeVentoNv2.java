package com.daniel.Model.Dados.Quests;

public class QuestSlimeDeVentoNv2 extends Quest {
    public QuestSlimeDeVentoNv2(){
        this.nome = "Derrote os slimes de vento aprimorados";
        this.progresso = 0;
        this.objetivo = 10;
        this.recompensaMoedas= 500;
        this.recompensaXP = 1000;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Slime de vento médio";
        this.descricao= "Derrote um total de "+this.objetivo+" slimes de vento aprimorados";

    }
}
