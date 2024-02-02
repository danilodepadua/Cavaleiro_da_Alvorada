package com.daniel.Modelo.Quests;

public class QuestSlimeDeEscuridaoNv2 extends Quest {
    public QuestSlimeDeEscuridaoNv2(){
        this.nome = "Derrote os slimes da escuridão aprimorados";
        this.progresso = 0;
        this.objetivo = 10;
        this.recompensaMoedas= 500;
        this.recompensaXP = 1000;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Slime de escuridão médio";
        this.descricao= "Derrote um total de "+this.objetivo+" slimes da escuridão";

    }
}
