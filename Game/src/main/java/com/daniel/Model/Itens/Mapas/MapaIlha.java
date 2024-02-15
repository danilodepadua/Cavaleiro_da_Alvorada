package com.daniel.Model.Itens.Mapas;

import com.daniel.Model.Dados.Cidades.Vilas.Ilha;
import com.daniel.Model.Dados.Entidades.Player;
import com.daniel.Model.Exceptions.PlayerInexistenteException;
import com.daniel.Model.Interfaces.IConsumableOutBattle;
import com.daniel.Model.Itens.Item;

public class MapaIlha extends Item implements IConsumableOutBattle {
    public MapaIlha() {
        super("/com.daniel.Images/Itens/map_01.png", "Ilha", 1, 150, "Mapa para Ilha");
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().adicionarCidade(new Ilha());
        Player.getPlayer().getInventario().removerItem(this);

    }
}
