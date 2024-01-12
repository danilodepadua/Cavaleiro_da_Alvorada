package com.daniel.PrimeiraCamada.Quests;

public class QuestBabySlime extends Quests{
    public QuestBabySlime(){
        this.nome = "Derrote baby slimes";
        this.descricao= "Derrote um total de 10 baby slimes";
        this.progresso = 0;
        this.objetivo = 10;
        this.recompensaMoedas= 100;
        this.recompensaXP = 500;
        this.nomeInimigo = "Slime";
    }
}
