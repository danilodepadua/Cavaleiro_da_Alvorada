package com.daniel.PrimeiraCamada.Quests;

public class QuestAbelha extends Quests{
    public QuestAbelha(){
        this.nome = "Derrote abelhas";
        this.descricao= "Derrote um total de duas abelhas";
        this.progresso = 0;
        this.objetivo = 2;
        this.recompensaMoedas= 100;
        this.recompensaXP = 500;
        this.nomeInimigo = "Abelha";
    }
}
