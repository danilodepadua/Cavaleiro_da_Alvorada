package com.daniel.Model.Quests;

public class QuestSlimeDeFogoNv1 extends Quest {
    public QuestSlimeDeFogoNv1(){
        this.nome = "Derrote os slimes de fogo";
        this.progresso = 0;
        this.objetivo = 15;
        this.recompensaMoedas= 200;
        this.recompensaXP = 500;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Slime de fogo pequeno";
        this.descricao= "Derrote um total de "+this.objetivo+" slimes de fogo";

    }
}
