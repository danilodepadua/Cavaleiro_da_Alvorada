package com.daniel.Model.Dados.Itens.Mapas;

import com.daniel.Model.Dados.CidadeRepositorio.Cidades.MonteClaro;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableOutBattle;
import com.daniel.Model.Dados.Itens.Item;

public class MapaMonteClaro extends Item implements IConsumableOutBattle {
    public MapaMonteClaro() {
        super("/com.daniel.Images/Itens/map_01.png", "Monte Claro", 1, 70, "Mapa para Monte Claro");
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().adicionarCidade(new MonteClaro());
        Player.getPlayer().getInventario().removerItem(this);

    }
}
