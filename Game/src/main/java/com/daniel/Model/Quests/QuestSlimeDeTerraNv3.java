package com.daniel.Model.Quests;

import com.daniel.Model.Dados.Textos.TextoNode;

public class QuestSlimeDeTerraNv3 extends Quest {
    public QuestSlimeDeTerraNv3(){
        this.nome = new TextoNode("Mate ", "Kill ").getTexto()+"slimes de terra";
        this.progresso = 0;
        this.objetivo = 7;
        this.recompensaMoedas= 800;
        this.recompensaXP = 1500;
        this.pontosEvolucao = 2;
        this.nomeInimigo = "Slime de terra grande";
        this.descricao= new TextoNode("Mate ", "Kill ").getTexto()+this.objetivo+" slimes de terra";

    }
}
