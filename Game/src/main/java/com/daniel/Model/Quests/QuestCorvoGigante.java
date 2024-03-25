package com.daniel.Model.Quests;

import com.daniel.Model.Dados.Textos.TextoNode;

public class QuestCorvoGigante extends Quest {
    public QuestCorvoGigante() {
        this.nome = new TextoNode("Mate ", "Kill ").getTexto()+"Corvos";
        this.progresso = 0;
        this.objetivo = 7;
        this.recompensaMoedas= 800;
        this.recompensaXP = 1500;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Corvo gigante";
        this.descricao= new TextoNode("Mate ", "Kill ").getTexto()+this.objetivo+" corvos";

    }
}
