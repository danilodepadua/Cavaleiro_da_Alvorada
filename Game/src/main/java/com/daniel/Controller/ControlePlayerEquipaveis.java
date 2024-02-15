package com.daniel.Controller;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Itens.Arma;
import com.daniel.Model.Itens.Armaduras.Calca;
import com.daniel.Model.Itens.Armaduras.Calcas.NullCalca;
import com.daniel.Model.Itens.Armaduras.Capacete;
import com.daniel.Model.Itens.Armaduras.Capacetes.NullCapacete;
import com.daniel.Model.Itens.Armaduras.Peitorais.NullPeitoral;
import com.daniel.Model.Itens.Armaduras.Peitoral;
import com.daniel.Model.Itens.Armas.NullArma;
import com.daniel.Model.Itens.Item;
import com.daniel.Model.Exceptions.PlayerInexistenteException;

public class ControlePlayerEquipaveis {
    //Classe pra gerir os itens equipaveis do player
    public void equipar(Item item) throws PlayerInexistenteException {
        if (item != null) {
            if (podeEquiparItem(item)) {  //verifica se pode equipar, se sim desequipa o item atual da categoria pra colocar o novo
                desequipar(item);
                //Instancia o tipo do item ate achar o padrao
                if (item instanceof Arma) {
                    Player.getPlayer().setArma((Arma) item);

                } else if (item instanceof Calca) {
                    Player.getPlayer().setCalca((Calca) item);

                } else if (item instanceof Peitoral) {
                    Player.getPlayer().setPeitoral((Peitoral) item);

                } else if (item instanceof Capacete) {
                    Player.getPlayer().setCapacete((Capacete) item);
                }
            }
        } else {
            throw new PlayerInexistenteException();
        }
    }
    public void desequipar(Item item) throws PlayerInexistenteException { //verifica se o item atual da categoria é igual ao selecionado, se sim, a manipulação fica ativa.
        if (Player.getPlayer().getArma().equals(item)) {
            Player.getPlayer().setArma(new NullArma());
        } else if (Player.getPlayer().getPeitoral().equals(item)) {
            Player.getPlayer().setPeitoral(new NullPeitoral());
        } else if (Player.getPlayer().getCapacete().equals(item)) {
            Player.getPlayer().setCapacete(new NullCapacete());
        } else if (Player.getPlayer().getCalca().equals(item)) {
            Player.getPlayer().setCalca(new NullCalca());
        }

    }

    public boolean podeEquiparItem(Item item) throws PlayerInexistenteException { //verifica se o item equipado da categorial é codizente com o parametro
        return !Player.getPlayer().getPeitoral().equals(item) &&
                !Player.getPlayer().getCapacete().equals(item) &&
                !Player.getPlayer().getCalca().equals(item) &&
                !Player.getPlayer().getArma().equals(item);
    }

}
