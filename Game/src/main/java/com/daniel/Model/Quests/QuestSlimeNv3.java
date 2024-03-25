package com.daniel.Model.Quests;

import com.daniel.Model.Dados.Textos.TextoNode;

public class QuestSlimeNv3 extends Quest {
    public QuestSlimeNv3() {
        this.nome = new TextoNode("Mate ", "Kill ").getTexto()+" Slimes grandes";
        this.progresso = 0;
        this.objetivo = 15;
        this.recompensaMoedas= 700;
        this.recompensaXP = 1500;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Slime grande";
        this.descricao= new TextoNode("Mate ", "Kill ").getTexto()+this.objetivo+" slimes grandes";

    }

}
