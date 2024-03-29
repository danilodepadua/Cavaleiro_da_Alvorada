package com.daniel.Model.Itens.Mapas;

import com.daniel.Model.Dados.Cidades.Vilas.CidadePortuaria;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableOutBattle;
import com.daniel.Model.Itens.Item;

public class MapaPortuaria extends Item implements IConsumableOutBattle {
    public MapaPortuaria() {
        super("/com.daniel.Images/Itens/map_01.png", new TextoNode("Cidade portuária", "Port City"), 1, 35000, new TextoNode("Mapa para Cidade Portuária","Map to Port city"));
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().adicionarCidade(new CidadePortuaria());
        Player.getPlayer().getInventario().removerItem(this);

    }
}
