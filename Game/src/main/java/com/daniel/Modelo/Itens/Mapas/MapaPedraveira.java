package com.daniel.Modelo.Itens.Mapas;

import com.daniel.Dados.CidadeRepositório.Cidades.BatalhaDePedraveira;
import com.daniel.Dados.EntidadesRepositório.Player;
import com.daniel.Modelo.Exceptions.PlayerInexistenteException;
import com.daniel.Modelo.Interfaces.IConsumableOutBattle;
import com.daniel.Modelo.Itens.Item;

public class MapaPedraveira extends Item implements IConsumableOutBattle {
    public MapaPedraveira() {
        super("/com.daniel.Images/Itens/map_01.png", "Pedraveira", 1, 200, "Mapa para Cidade de Pedraveira");
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().adicionarCidade(new BatalhaDePedraveira());
        Player.getPlayer().getInventario().RemoverItem(this);

    }
}
