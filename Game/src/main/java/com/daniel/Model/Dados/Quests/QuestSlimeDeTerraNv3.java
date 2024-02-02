package com.daniel.Model.Dados.Quests;

public class QuestSlimeDeTerraNv3 extends Quest {
    public QuestSlimeDeTerraNv3(){
        this.nome = "Derrote os slimes de terra super aprimorados";
        this.progresso = 0;
        this.objetivo = 7;
        this.recompensaMoedas= 800;
        this.recompensaXP = 1500;
        this.pontosEvolucao = 2;
        this.nomeInimigo = "Slime de terra grande";
        this.descricao= "Derrote um total de "+this.objetivo+" slimes de terra super aprimorados";

    }
}
