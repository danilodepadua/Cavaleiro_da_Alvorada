package com.daniel.Model.Quests;

import com.daniel.Model.Dados.Textos.TextoNode;

public class QuestCobraGigante extends Quest {
    public QuestCobraGigante() {
        this.nome = new TextoNode("Mate ", "Kill ").getTexto()+"Cobras";
        this.progresso = 0;
        this.objetivo = 5;
        this.recompensaMoedas= 800;
        this.recompensaXP = 1500;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Cobra gigante";
        this.descricao= new TextoNode("Mate ", "Kill ").getTexto()+this.objetivo+" cobras";

    }
}
