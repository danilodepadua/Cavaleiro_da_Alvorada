package com.daniel.Modelo.Quests;

public class QuestSlimeNv3 extends Quest {
    public QuestSlimeNv3() {
        this.nome = "Derrote os Slimes grandes";
        this.progresso = 0;
        this.objetivo = 15;
        this.recompensaMoedas= 700;
        this.recompensaXP = 1500;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Slime grande";
        this.descricao= "Derrote um total de "+this.objetivo+" slimes grandes";

    }

}
