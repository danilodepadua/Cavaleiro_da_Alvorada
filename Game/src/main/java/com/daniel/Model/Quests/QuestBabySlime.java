package com.daniel.Model.Quests;

import com.daniel.Model.Dados.Textos.TextoNode;

public class QuestBabySlime extends Quest {
    public QuestBabySlime(){
        this.nome = new TextoNode("Mate ", "Kill ").getTexto()+"baby slimes";
        this.progresso = 0;
        this.objetivo = 2;
        this.recompensaMoedas= 100;
        this.recompensaXP = 1000;
        this.pontosEvolucao = 1;
        this.nomeInimigo = "Slime";
        this.descricao= new TextoNode("Mate ", "Kill ").getTexto()+this.objetivo+" baby slimes";
    }
}
