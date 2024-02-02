package com.daniel.Model.Dados.Quests;

public class QuestAbelha extends Quest {
    public QuestAbelha(){
        this.nome = "Derrote abelhas";
        this.progresso = 0;
        this.objetivo = 2;
        this.recompensaMoedas= 100;
        this.recompensaXP = 1000;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Abelha";
        this.descricao= "Derrote um total de "+this.objetivo+" abelhas";

    }
}
