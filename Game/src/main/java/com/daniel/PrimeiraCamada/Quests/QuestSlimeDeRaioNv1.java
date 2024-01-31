package com.daniel.PrimeiraCamada.Quests;

import com.daniel.PrimeiraCamada.Quest;

public class QuestSlimeDeRaioNv1 extends Quest {
    public QuestSlimeDeRaioNv1(){
        this.nome = "Derrote os slimes de Raio";
        this.progresso = 0;
        this.objetivo = 15;
        this.recompensaMoedas= 200;
        this.recompensaXP = 500;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Slime de raio pequeno";
        this.descricao= "Derrote um total de "+this.objetivo+" slimes de raio";

    }
}
