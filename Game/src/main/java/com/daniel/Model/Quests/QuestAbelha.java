package com.daniel.Model.Quests;

import com.daniel.Model.Dados.Textos.TextoNode;

public class QuestAbelha extends Quest {
    public QuestAbelha(){
        this.nome = new TextoNode("Mate ", "Kill ").getTexto()+"abelhas";
        this.progresso = 0;
        this.objetivo = 2;
        this.recompensaMoedas= 100;
        this.recompensaXP = 1000;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Abelha";
        this.descricao= new TextoNode("Mate ", "Kill ").getTexto() +this.objetivo+" abelhas";

    }
}
