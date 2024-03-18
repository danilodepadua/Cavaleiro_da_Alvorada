package com.daniel.Model.Itens.Mapas;

import com.daniel.Model.Dados.Cidades.Vilas.Ilha;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableOutBattle;
import com.daniel.Model.Itens.Item;

public class MapaIlha extends Item implements IConsumableOutBattle {
    public MapaIlha() {
        super("/com.daniel.Images/Itens/map_01.png", new TextoNode("Ilha","Island"), 1, 150, new TextoNode("Mapa para Ilha", "Map to the Island"));
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().adicionarCidade(new Ilha());
        Player.getPlayer().getInventario().removerItem(this);

    }
}
