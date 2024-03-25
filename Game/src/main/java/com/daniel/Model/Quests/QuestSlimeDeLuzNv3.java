package com.daniel.Model.Quests;

import com.daniel.Model.Dados.Textos.TextoNode;

public class QuestSlimeDeLuzNv3 extends Quest {
    public QuestSlimeDeLuzNv3() {
        this.nome = new TextoNode("Mate ", "Kill ").getTexto()+"slimes de luz";
        this.progresso = 0;
        this.objetivo = 10;
        this.recompensaMoedas= 800;
        this.recompensaXP = 1000;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Slime de luz grande";
        this.descricao= new TextoNode("Mate ", "Kill ").getTexto()+this.objetivo+" slimes de luz";
    }
}
