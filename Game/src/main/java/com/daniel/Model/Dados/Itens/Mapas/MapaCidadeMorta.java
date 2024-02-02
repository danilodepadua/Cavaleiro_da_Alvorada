package com.daniel.Model.Dados.Itens.Mapas;

import com.daniel.Model.Dados.CidadeRepositorio.Cidades.CidadeMorta;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableOutBattle;
import com.daniel.Model.Dados.Itens.Item;

public class MapaCidadeMorta extends Item implements IConsumableOutBattle {
    public MapaCidadeMorta() {
        super("/com.daniel.Images/Itens/map_01.png", "Cidade morta", 1, 50, "Mapa para Cidade Morta");
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().adicionarCidade(new CidadeMorta());
        Player.getPlayer().getInventario().removerItem(this);

    }
}

