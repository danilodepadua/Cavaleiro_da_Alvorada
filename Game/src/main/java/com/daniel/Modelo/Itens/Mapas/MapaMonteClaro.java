package com.daniel.Modelo.Itens.Mapas;

import com.daniel.Dados.CidadeRepositório.Cidades.MonteClaro;
import com.daniel.Dados.EntidadesRepositório.Player;
import com.daniel.Modelo.Exceptions.PlayerInexistenteException;
import com.daniel.Modelo.Interfaces.IConsumableOutBattle;
import com.daniel.Modelo.Itens.Item;

public class MapaMonteClaro extends Item implements IConsumableOutBattle {
    public MapaMonteClaro() {
        super("/com.daniel.Images/Itens/map_01.png", "Monte Claro", 1, 70, "Mapa para Monte Claro");
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().adicionarCidade(new MonteClaro());
        Player.getPlayer().getInventario().RemoverItem(this);

    }
}
