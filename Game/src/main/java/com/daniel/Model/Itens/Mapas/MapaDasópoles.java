package com.daniel.Model.Itens.Mapas;

import com.daniel.Model.Dados.Cidades.Vilas.Dasópoles;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableOutBattle;
import com.daniel.Model.Itens.Item;

public class MapaDasópoles extends Item implements IConsumableOutBattle {
    public MapaDasópoles() {
        super("/com.daniel.Images/Itens/map_01.png", new TextoNode("Dasópoles", "Dasópoles"), 1, 1500, new TextoNode("Mapa para Dasópoles", "Map to Desópoles"));
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().adicionarCidade(new Dasópoles());
        Player.getPlayer().getInventario().removerItem(this);

    }
}
