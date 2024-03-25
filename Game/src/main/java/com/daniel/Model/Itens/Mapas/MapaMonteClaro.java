package com.daniel.Model.Itens.Mapas;

import com.daniel.Model.Dados.Cidades.Vilas.MonteClaro;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Dados.Textos.TextoNode;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableOutBattle;
import com.daniel.Model.Itens.Item;

public class MapaMonteClaro extends Item implements IConsumableOutBattle {
    public MapaMonteClaro() {
        super("/com.daniel.Images/Itens/map_01.png", new TextoNode("Monte Claro","Monte Claro"), 1, 7000, new TextoNode("Mapa para Monte Claro", "Map to Monte Claro"));
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().adicionarCidade(new MonteClaro());
        Player.getPlayer().getInventario().removerItem(this);

    }
}
