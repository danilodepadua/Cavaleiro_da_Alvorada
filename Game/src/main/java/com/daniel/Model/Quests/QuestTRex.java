package com.daniel.Model.Quests;

import com.daniel.Model.Dados.Textos.TextoNode;

public class QuestTRex extends Quest {
    public QuestTRex(){
        this.nome = "T-Rex";
        this.progresso = 0;
        this.objetivo = 1;
        this.recompensaMoedas= 1500;
        this.recompensaXP = 1500;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "T-Rex";
        this.descricao= new TextoNode("Mate o", "Kill the").getTexto()+" T-REX";

    }
}
