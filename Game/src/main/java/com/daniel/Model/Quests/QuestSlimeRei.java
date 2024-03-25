package com.daniel.Model.Quests;

import com.daniel.Model.Dados.Textos.TextoNode;

public class QuestSlimeRei extends Quest {
    public QuestSlimeRei() {
        this.nome = "Slime Rei";
        this.progresso = 0;
        this.objetivo = 1;
        this.recompensaMoedas= 1500;
        this.recompensaXP = 1500;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Rei dos slimes";
        this.descricao= new TextoNode("Mate o", "Kill the").getTexto()+" Slime Rei";
    }
}
