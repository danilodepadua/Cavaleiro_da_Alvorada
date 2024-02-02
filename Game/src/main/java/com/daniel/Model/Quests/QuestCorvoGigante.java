package com.daniel.Model.Quests;

public class QuestCorvoGigante extends Quest {
    public QuestCorvoGigante() {
        this.nome = "Derrote Corvos";
        this.progresso = 0;
        this.objetivo = 7;
        this.recompensaMoedas= 800;
        this.recompensaXP = 1500;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Corvo gigante";
        this.descricao= "Derrote um total de "+this.objetivo+" corvos";

    }
}
