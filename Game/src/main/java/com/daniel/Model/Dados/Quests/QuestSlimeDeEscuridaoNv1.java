package com.daniel.Model.Dados.Quests;

public class QuestSlimeDeEscuridaoNv1 extends Quest {
    public QuestSlimeDeEscuridaoNv1(){
        this.nome = "Derrote os slimes da escuridão";
        this.progresso = 0;
        this.objetivo = 15;
        this.recompensaMoedas= 200;
        this.recompensaXP = 500;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Slime de escuridão pequeno";
        this.descricao= "Derrote um total de "+this.objetivo+" slimes da escuridão";

    }
}
