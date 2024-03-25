package com.daniel.Model.Quests;

import com.daniel.Model.Dados.Textos.TextoNode;

public class QuestSlimeDeVentoNv3 extends Quest {
    public QuestSlimeDeVentoNv3(){
        this.nome = new TextoNode("Mate ", "Kill ").getTexto()+"slimes de vento";
        this.progresso = 0;
        this.objetivo = 7;
        this.recompensaMoedas= 800;
        this.recompensaXP = 1500;
        this.pontosEvolucao = 2;
        this.nomeInimigo = "Slime de vento grande";
        this.descricao= new TextoNode("Mate ", "Kill ").getTexto()+this.objetivo+" slimes de vento";

    }
}
