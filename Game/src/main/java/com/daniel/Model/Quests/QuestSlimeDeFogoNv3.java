package com.daniel.Model.Quests;

import com.daniel.Model.Dados.Textos.TextoNode;

public class QuestSlimeDeFogoNv3 extends Quest {
    public QuestSlimeDeFogoNv3(){
        this.nome = new TextoNode("Mate ", "Kill ").getTexto()+"slimes de fogo";
        this.progresso = 0;
        this.objetivo = 7;
        this.recompensaMoedas= 800;
        this.recompensaXP = 1500;
        this.pontosEvolucao = 2;
        this.nomeInimigo = "Slime de fogo grande";
        this.descricao= new TextoNode("Mate ", "Kill ").getTexto()+this.objetivo+" slimes de fogo";

    }
}
