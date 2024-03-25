package com.daniel.Model.Quests;

import com.daniel.Model.Dados.Textos.TextoNode;

public class QuestSlimeGod extends Quest {
    public QuestSlimeGod() {
        this.nome = "Deus Slime";
        this.progresso = 0;
        this.objetivo = 1;
        this.recompensaMoedas= 1000;
        this.recompensaXP = 1500;
        this.pontosEvolucao = 2;
        this.nomeInimigo = "Slime primordials";
        this.descricao= new TextoNode("Mate o", "Kill the").getTexto()+" Deus Slime";

    }
}
