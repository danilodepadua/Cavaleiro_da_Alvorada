package com.daniel.Model.Dados.Quests;

public class QuestSlimeDeEscuridaoNv3 extends Quest {
    public QuestSlimeDeEscuridaoNv3(){
        this.nome = "Derrote os slimes da escuridão super aprimorados";
        this.progresso = 0;
        this.objetivo = 7;
        this.recompensaMoedas= 800;
        this.recompensaXP = 1500;
        this.pontosEvolucao = 2;
        this.nomeInimigo = "Slime de escuridão grande";
        this.descricao= "Derrote um total de "+this.objetivo+" slimes da escuridão super aprimorados";

    }
}