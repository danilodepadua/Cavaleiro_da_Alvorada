package com.daniel.Modelo.Itens.Mapas;

import com.daniel.Dados.CidadeRepositório.Cidades.CidadePortuaria;
import com.daniel.Dados.EntidadesRepositório.Player;
import com.daniel.Modelo.Exceptions.PlayerInexistenteException;
import com.daniel.Modelo.Interfaces.IConsumableOutBattle;
import com.daniel.Modelo.Itens.Item;

public class MapaPortuaria extends Item implements IConsumableOutBattle {
    public MapaPortuaria() {
        super("/com.daniel.Images/Itens/map_01.png", "Cidade portuária", 1, 150, "Mapa para Cidade Portuária");
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().adicionarCidade(new CidadePortuaria());
        Player.getPlayer().getInventario().RemoverItem(this);

    }
}
