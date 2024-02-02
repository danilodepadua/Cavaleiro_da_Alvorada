package com.daniel.Modelo.Itens.Mapas;

import com.daniel.Dados.CidadeRepositório.Cidades.CidadeMorta;
import com.daniel.Dados.EntidadesRepositório.Player;
import com.daniel.Modelo.Exceptions.PlayerInexistenteException;
import com.daniel.Modelo.Interfaces.IConsumableOutBattle;
import com.daniel.Modelo.Itens.Item;

public class MapaCidadeMorta extends Item implements IConsumableOutBattle {
    public MapaCidadeMorta() {
        super("/com.daniel.Images/Itens/map_01.png", "Cidade morta", 1, 50, "Mapa para Cidade Morta");
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().adicionarCidade(new CidadeMorta());
        Player.getPlayer().getInventario().RemoverItem(this);

    }
}

