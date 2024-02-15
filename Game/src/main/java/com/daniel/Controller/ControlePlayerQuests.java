package com.daniel.Controller;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Quests.Quest;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.game.Main;

import java.util.ArrayList;
import java.util.List;

public class ControlePlayerQuests {
    private JogoFachada jogoFachada; //atributo para poder puxar uma instancia da fachada

    public ControlePlayerQuests(JogoFachada jogoFachada) {
        this.jogoFachada = jogoFachada;
    }

    public void completarQuest(Quest quest) throws PlayerInexistenteException { //verifica se o player completou a quest especifica, se sim, dropa as recompensas.
        if (Player.getPlayer().getQuestsAtuais().contains(quest)) {
            jogoFachada.ganharXp(quest.getRecompensaXP());
            Player.getPlayer().ganharCoins(quest.getRecompensaMoedas());
            jogoFachada.ganhaPontos(quest.getPontosEvolucao());
            Player.getPlayer().getQuestsAtuais().remove(quest);
        }
    }
    public List<Quest> obterQuestsComuns() throws PlayerInexistenteException { //metodo pra obter todas as quests em comum entre o player e a cidade
        List<Quest> questsCidade = Main.cidadeAtual.getQuests();  //pega as quests
        List<Quest> questsComuns = new ArrayList<>();  //cria o array pras quests comuns

        for (Quest questJogador : Player.getPlayer().getQuestsAtuais()) { //for each pra iterar sobre as quests do player, no caso, o player possui todas em seu construtor
            boolean questComum = questsCidade.stream().anyMatch(questCidade -> questJogador.getNome().equals(questCidade.getNome()));
            //se tiver um elemento igual de nome, ele retorna true
            if (questComum) {
                questsComuns.add(questJogador);  // Adiciona a quest comum à lista
            }
        }
        return new ArrayList<>(questsComuns);  // Retorna o arraylist contendo as quests comuns
    }
}
