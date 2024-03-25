package com.daniel.Model.Quests;

import com.daniel.Model.Dados.Textos.TextoNode;

public class QuestSlimeDeRaioNv3 extends Quest {
    public QuestSlimeDeRaioNv3() {
        this.nome = new TextoNode("Mate ", "Kill ").getTexto()+"slimes de raio";
        this.progresso = 0;
        this.objetivo = 10;
        this.recompensaMoedas= 800;
        this.recompensaXP = 1000;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Slime de raio grande";
        this.descricao= new TextoNode("Mate ", "Kill ").getTexto()+this.objetivo+" slimes de raio";
    }
}
