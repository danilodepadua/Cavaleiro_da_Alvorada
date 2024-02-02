package com.daniel.Controller;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Exceptions.*;
import com.daniel.Model.Interfaces.IEquipable;
import com.daniel.Model.Dados.Itens.Item;

public class LojaFachada {
    private static final LojaFachada instance = new LojaFachada();

    private LojaFachada() {
    }

    public static LojaFachada getInstance() {
        return instance;
    }

    public void comprarItem( Item item) throws PlayerInexistenteException, RemoverCoinsException, CompraErroException, SemMoedasParaLojaException {
        if (Player.getPlayer() != null && item != null) {
            if (podeComprar(item)) {
                // Realize a compra
                Player.getPlayer().removerCoins(item.getPreco()); //remove o ouro
                Player.getPlayer().getInventario().adicionarItem(item); // adiciona o item
            } else {
                throw new SemMoedasParaLojaException();
            }
        } else {
            throw new CompraErroException();
        }
    }
    private boolean podeComprar(Item item) throws PlayerInexistenteException {
        return Player.getPlayer().getCoins() >= item.getPreco();
    }
    public void venderItem(Item item) throws PlayerInexistenteException {
        if (item != null) {
            if (item instanceof IEquipable) {
                IEquipable equipableItem = (IEquipable) item;
                Player.getPlayer().desequiparItemSeEquipado(Player.getPlayer(), equipableItem);
            }
            int precoItem = item.getPreco();
            Player.getPlayer().ganhaCoins(precoItem * 70 / 100);
            Player.getPlayer().getInventario().removerItem(item);
        }
    }


}
