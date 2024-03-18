package com.daniel.Model.Itens.Mapas;

import com.daniel.Model.Dados.Cidades.Vilas.CidadeMorta;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableOutBattle;
import com.daniel.Model.Itens.Item;

public class MapaCidadeMorta extends Item implements IConsumableOutBattle {
    public MapaCidadeMorta() {
        super("/com.daniel.Images/Itens/map_01.png", new TextoNode("Cidade morta", "Dead City"), 1, 50, new TextoNode("Mapa para Cidade Morta", "Map to Dead city"));
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().adicionarCidade(new CidadeMorta());
        Player.getPlayer().getInventario().removerItem(this);

    }
}

