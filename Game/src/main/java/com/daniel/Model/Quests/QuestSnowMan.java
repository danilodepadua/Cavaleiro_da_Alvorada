package com.daniel.Model.Quests;

import com.daniel.Model.Dados.Textos.TextoNode;

public class QuestSnowMan extends Quest {
    public QuestSnowMan() {
        this.nome = "Abominavel Rei das neves";
        this.progresso = 0;
        this.objetivo = 1;
        this.recompensaMoedas= 1000;
        this.recompensaXP = 1500;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Abominavel boneco das neves";
        this.descricao= new TextoNode("Mate o", "Kill the").getTexto()+" Abominavel Rei das neves";

    }
}
