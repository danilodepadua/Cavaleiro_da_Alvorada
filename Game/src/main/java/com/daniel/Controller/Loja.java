package com.daniel.Controller;

import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Itens.Item;
import com.daniel.Model.Exceptions.CompraErroException;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Exceptions.RemoverCoinsException;
import com.daniel.Model.Exceptions.SemMoedasParaLojaException;
import com.daniel.Model.Interfaces.IEquipable;

public class Loja {
    /**
     * Realiza a compra de um item na loja.
     *
     * @param item O item a ser comprado.
     * @throws CompraErroException       Exceção lançada em caso de erro na compra.
     * @throws SemMoedasParaLojaException Exceção lançada se o jogador não tiver moedas suficientes.
     * @throws PlayerInexistenteException Exceção lançada se o jogador não existir.
     * @throws RemoverCoinsException      Exceção lançada se ocorrer um erro ao remover moedas do jogador.
     */
    public void comprarItem(Item item) throws CompraErroException, SemMoedasParaLojaException, PlayerInexistenteException, RemoverCoinsException {
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
                Player.getPlayer().desequiparItemSeEquipado(equipableItem);
            }
            int precoItem = item.getPreco();
            Player.getPlayer().ganhaCoins(precoItem * 70 / 100);
            Player.getPlayer().getInventario().removerItem(item);
        }
    }
}
