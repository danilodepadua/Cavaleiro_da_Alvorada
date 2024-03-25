package com.daniel.Model.Quests;

import com.daniel.Model.Dados.Textos.TextoNode;

public class QuestTigerMan extends Quest {
    public QuestTigerMan() {
        this.nome = "Tiger Man";
        this.progresso = 0;
        this.objetivo = 1;
        this.recompensaMoedas= 2000;
        this.recompensaXP = 1000;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Tiger Man";
        this.descricao= new TextoNode("Mate o", "Kill the").getTexto()+" Tiger Man";
    }
}
