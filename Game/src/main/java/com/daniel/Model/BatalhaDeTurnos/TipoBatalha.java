package com.daniel.Model.BatalhaDeTurnos;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Dados.Entidades.Inimigos.Inimigo;
import com.daniel.Model.Itens.Item;
import com.daniel.Model.Quests.Quest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public abstract class TipoBatalha {
    public Inimigo inimigo;
    public boolean escapavel = true, finalizado = false;
    public int xpGanho, dinheiroGanho;
    public ArrayList<Item> itensDropados = new ArrayList<>();
    public abstract void Inicializar();
    public final void Vitoria() throws PlayerInexistenteException, IOException {
        for (Quest quest : Player.getPlayer().getQuestsAtuais()) {
            if (quest.getNomeInimigo().equals(inimigo.getNome())) {
                try {
                    quest.updateQuestCompleted();
                } catch (PlayerInexistenteException e) {
                    System.err.println("Erro ao atualizar quests: " + e.getMessage());
                }
            }
        }
        Player.getPlayer().getBestiario().adicionarInimigos(inimigo);
        xpGanho += inimigo.getDropXp();
        dinheiroGanho += inimigo.getMoedas();
        ArrayList<Item> novosItens = inimigo.getLootTable().drop();
        for(int i = 0; i<novosItens.size(); i++){
            boolean tem = false;
            for(int j = 0; j<itensDropados.size();j++){
                if(Objects.equals(itensDropados.get(j).getNome(), novosItens.get(i).getNome())){
                    itensDropados.get(j).MaisQuant(novosItens.get(i).getQuant());
                    tem = true;
                    break;
                }
            }
            if(!tem){
                itensDropados.add(novosItens.get(i));
            }
        }
        this.LogicaVitoria();
    }
    public abstract void LogicaVitoria() throws IOException, PlayerInexistenteException;
    public abstract void Derrota() throws IOException;
}
