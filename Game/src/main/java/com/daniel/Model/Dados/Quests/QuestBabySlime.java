package com.daniel.Model.Dados.Quests;

public class QuestBabySlime extends Quest {
    public QuestBabySlime(){
        this.nome = "Derrote baby slimes";
        this.progresso = 0;
        this.objetivo = 2;
        this.recompensaMoedas= 100;
        this.recompensaXP = 1000;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Slime";
        this.descricao= "Derrote um total de "+this.objetivo+" baby slimes";
    }
}
