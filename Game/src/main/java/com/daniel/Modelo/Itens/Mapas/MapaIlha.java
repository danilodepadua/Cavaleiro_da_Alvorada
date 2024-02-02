package com.daniel.Modelo.Itens.Mapas;

import com.daniel.Dados.CidadeRepositório.Cidades.Ilha;
import com.daniel.Dados.EntidadesRepositório.Player;
import com.daniel.Modelo.Exceptions.PlayerInexistenteException;
import com.daniel.Modelo.Interfaces.IConsumableOutBattle;
import com.daniel.Modelo.Itens.Item;

public class MapaIlha extends Item implements IConsumableOutBattle {
    public MapaIlha() {
        super("/com.daniel.Images/Itens/map_01.png", "Ilha", 1, 150, "Mapa para Ilha");
    }

    @Override
    public void Consumir() throws PlayerInexistenteException {
        Player.getPlayer().adicionarCidade(new Ilha());
        Player.getPlayer().getInventario().RemoverItem(this);

    }
}
