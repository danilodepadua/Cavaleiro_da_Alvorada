package com.daniel.Modelo.Quests;

public class QuestSlimeDeAguaNv1 extends Quest {
    public QuestSlimeDeAguaNv1(){
        this.nome = "Derrote os slimes de água";
        this.progresso = 0;
        this.objetivo = 15;
        this.recompensaMoedas= 200;
        this.recompensaXP = 500;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Slime de água pequeno";
        this.descricao= "Derrote um total de "+this.objetivo+" slimes de água";

    }
}
