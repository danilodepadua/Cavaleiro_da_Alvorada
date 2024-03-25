package com.daniel.Model.Quests;

import com.daniel.Model.Dados.Textos.TextoNode;

public class QuestSlimeDeEscuridaoNv3 extends Quest {
    public QuestSlimeDeEscuridaoNv3(){
        this.nome = new TextoNode("Mate ", "Kill ").getTexto()+"slimes da escuridão";
        this.progresso = 0;
        this.objetivo = 7;
        this.recompensaMoedas= 800;
        this.recompensaXP = 1500;
        this.pontosEvolucao = 2;
        this.nomeInimigo = "Slime de escuridão grande";
        this.descricao= new TextoNode("Mate ", "Kill ").getTexto()+this.objetivo+" slimes da escuridão";

    }
}
