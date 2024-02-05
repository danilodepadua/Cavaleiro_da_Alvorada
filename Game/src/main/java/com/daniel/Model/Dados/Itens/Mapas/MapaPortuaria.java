package com.daniel.Model.Dados.Itens.Mapas;

import com.daniel.Model.Dados.CidadeRepositorio.Cidades.CidadePortuaria;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableOutBattle;
import com.daniel.Model.Dados.Itens.Item;

public class MapaPortuaria extends Item implements IConsumableOutBattle {
    public MapaPortuaria() {
        super("/com.daniel.Images/Itens/map_01.png", "Cidade portuária", 1, 150, "Mapa para Cidade Portuária");
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().adicionarCidade(new CidadePortuaria());
        Player.getPlayer().getInventario().removerItem(this);

    }
}